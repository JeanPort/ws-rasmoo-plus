package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.model.SubscriptionType;

import java.util.List;

public interface ISubscriptionTypeService {

    List<SubscriptionType> findAll();
    SubscriptionType findById(Long id);
    SubscriptionType update(SubscriptionType subscriptionType);
    void deleteById(Long id);
    Long create(SubscriptionType subscriptionType);
}
