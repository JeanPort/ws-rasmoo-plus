package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.request.PostSubscriptionTypeUserRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateSubscriptionTypeUserRequest;
import com.cliente.ws.rasmooplus.dto.response.GetSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.model.SubscriptionType;

import java.util.List;

public interface ISubscriptionTypeMapper {

    SubscriptionType toSubscriptionType(PostSubscriptionTypeUserRequest request);
    SubscriptionType toSubscriptionType(UpdateSubscriptionTypeUserRequest request);

    PostSubscriptionTypeResponse toPostSubscriptionTypeResponse(SubscriptionType subscriptionType);
    UpdateSubscriptionTypeUserRequest toUpdateSubscriptionTypeResponse(SubscriptionType subscriptionType);
    GetSubscriptionTypeResponse toGetSubscriptionTypeResponse(SubscriptionType subscriptionType);
    List<GetSubscriptionTypeResponse> toListGetSubscriptionTypeResponse(List<SubscriptionType> subscriptionTypes);
}
