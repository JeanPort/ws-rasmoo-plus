package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.request.PostSubscriptionTypeRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateSubscriptionTypeRequest;
import com.cliente.ws.rasmooplus.dto.response.GetSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.exception.NotFoundExcption;
import com.cliente.ws.rasmooplus.mapper.ISubscriptionTypeMapper;
import com.cliente.ws.rasmooplus.repository.SubscriptionTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypeImpl implements ISubscriptionTypeService{

    private final SubscriptionTypeRepository repository;
    private final ISubscriptionTypeMapper mapper;

    public SubscriptionTypeImpl(SubscriptionTypeRepository repository, ISubscriptionTypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<GetSubscriptionTypeResponse> findAll() {
        var res = repository.findAll();
        return mapper.toListGetSubscriptionTypeResponse(res);
    }

    @Override
    public GetSubscriptionTypeResponse findById(Long id) {
        var res = repository.findById(id).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        return mapper.toGetSubscriptionTypeResponse(res);
    }

    @Override
    public UpdateSubscriptionTypeResponse update(UpdateSubscriptionTypeRequest request) {
        repository.findById(request.id()).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        var update = mapper.toSubscriptionType(request);
        update = repository.save(update);
        return mapper.toUpdateSubscriptionTypeResponse(update);
    }

    @Override
    public void deleteById(Long id) {
        var res = repository.findById(id).orElseThrow(() -> new NotFoundExcption("Não encontrado"));
        repository.delete(res);
    }

    @Override
    public PostSubscriptionTypeResponse create(PostSubscriptionTypeRequest request) {
        var post = mapper.toSubscriptionType(request);
        post = repository.save(post);
        return mapper.toPostSubscriptionTypeResponse(post);
    }
}
