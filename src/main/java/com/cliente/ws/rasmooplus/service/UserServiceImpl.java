package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.request.PostUserRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateUserRequest;
import com.cliente.ws.rasmooplus.dto.response.GetUserResponse;
import com.cliente.ws.rasmooplus.dto.response.PostUserResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateUserResponse;
import com.cliente.ws.rasmooplus.exception.NotFoundExcption;
import com.cliente.ws.rasmooplus.mapper.IUserMapper;
import com.cliente.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.cliente.ws.rasmooplus.repository.UserRepository;
import com.cliente.ws.rasmooplus.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    private final UserRepository repository;
    private final SubscriptionTypeRepository subscriptionTypeRepository;
    private final UserTypeRepository userTypeRepository;
    private final IUserMapper mapper;

    public UserServiceImpl(UserRepository repository, SubscriptionTypeRepository subscriptionTypeRepository, UserTypeRepository userTypeRepository, IUserMapper mapper) {
        this.repository = repository;
        this.subscriptionTypeRepository = subscriptionTypeRepository;
        this.userTypeRepository = userTypeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetUserResponse> findAll() {
        var res = repository.findAll();
        return mapper.toListGetUserResponse(res);
    }

    @Override
    public GetUserResponse findById(Long id) {
        var res = repository.findById(id).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        return mapper.toGetUserResponse(res);
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        repository.findById(request.id()).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        var userType = userTypeRepository.findById(request.userTypeId()).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        var subscriptionType = subscriptionTypeRepository.findById(request.subscriptionTypeId()).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        var update = mapper.toUser(request, userType, subscriptionType);
        update = repository.save(update);
        return mapper.toUpdateUserResponse(update);
    }

    @Override
    public void deleteById(Long id) {
        var res = repository.findById(id).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        repository.delete(res);
    }

    @Override
    public PostUserResponse create(PostUserRequest request) {

        var userType = userTypeRepository.findById(request.userTypeId()).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        var post = mapper.toUser(request, userType, null);
        post = repository.save(post);
        return mapper.toPostUserResponse(post);
    }
}
