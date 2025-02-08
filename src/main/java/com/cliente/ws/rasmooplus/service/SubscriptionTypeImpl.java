package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.model.SubscriptionType;
import com.cliente.ws.rasmooplus.repository.SubscriptionTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubscriptionTypeImpl implements ISubscriptionTypeService{

    private final SubscriptionTypeRepository repository;

    public SubscriptionTypeImpl(SubscriptionTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return repository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado"));
    }

    @Override
    public SubscriptionType update(SubscriptionType subscriptionType) {
        repository.findById(subscriptionType.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado"));

        return repository.save(subscriptionType);
    }

    @Override
    public void deleteById(Long id) {
        var res = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado"));
        repository.delete(res);
    }

    @Override
    public Long create(SubscriptionType subscriptionType) {
        return repository.save(subscriptionType).getId();
    }
}
