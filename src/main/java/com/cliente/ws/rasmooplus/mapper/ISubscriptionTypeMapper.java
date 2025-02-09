package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.request.PostSubscriptionTypeRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateSubscriptionTypeRequest;
import com.cliente.ws.rasmooplus.dto.response.GetSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.model.SubscriptionType;

import java.util.List;

public interface ISubscriptionTypeMapper {

    SubscriptionType toSubscriptionType(PostSubscriptionTypeRequest request);
    SubscriptionType toSubscriptionType(UpdateSubscriptionTypeRequest request);

    PostSubscriptionTypeResponse toPostSubscriptionTypeResponse(SubscriptionType subscriptionType);
    UpdateSubscriptionTypeResponse toUpdateSubscriptionTypeResponse(SubscriptionType subscriptionType);
    GetSubscriptionTypeResponse toGetSubscriptionTypeResponse(SubscriptionType subscriptionType);
    List<GetSubscriptionTypeResponse> toListGetSubscriptionTypeResponse(List<SubscriptionType> subscriptionTypes);
}
