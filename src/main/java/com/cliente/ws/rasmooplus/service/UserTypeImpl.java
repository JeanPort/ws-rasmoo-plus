package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.request.PostUserTypeRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateUserTypeRequest;
import com.cliente.ws.rasmooplus.dto.response.GetUserTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostUserTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateUserTypeResponse;
import com.cliente.ws.rasmooplus.exception.NotFoundExcption;
import com.cliente.ws.rasmooplus.mapper.IUserTypeMapper;
import com.cliente.ws.rasmooplus.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeImpl implements IUserTypeService{

    private final UserTypeRepository repository;
    private final IUserTypeMapper mapper;

    public UserTypeImpl(UserTypeRepository repository, IUserTypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<GetUserTypeResponse> findAll() {
        var res = repository.findAll();
        return mapper.toListGetUserTypeResponse(res);
    }

    @Override
    public GetUserTypeResponse findById(Long id) {
        var res = repository.findById(id).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        return mapper.toGetUserTypeResponse(res);
    }

    @Override
    public UpdateUserTypeResponse update(UpdateUserTypeRequest request) {
        repository.findById(request.id()).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        var update = mapper.toUserType(request);
        update = repository.save(update);
        return mapper.toUpdateUserTypeResponse(update);
    }

    @Override
    public void deleteById(Long id) {
        var res = repository.findById(id).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        repository.delete(res);
    }

    @Override
    public PostUserTypeResponse create(PostUserTypeRequest request) {
        var post = mapper.toUserType(request);
        post = repository.save(post);
        return mapper.toPostUserTypeResponse(post);
    }
}
