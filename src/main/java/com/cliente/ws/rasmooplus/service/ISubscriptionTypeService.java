package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.request.PostSubscriptionTypeRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateSubscriptionTypeRequest;
import com.cliente.ws.rasmooplus.dto.response.GetSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.model.SubscriptionType;

import java.util.List;

public interface ISubscriptionTypeService {

    List<GetSubscriptionTypeResponse> findAll();
    GetSubscriptionTypeResponse findById(Long id);
    UpdateSubscriptionTypeResponse update(UpdateSubscriptionTypeRequest subscriptionType);
    void deleteById(Long id);
    PostSubscriptionTypeResponse create(PostSubscriptionTypeRequest subscriptionType);
}
