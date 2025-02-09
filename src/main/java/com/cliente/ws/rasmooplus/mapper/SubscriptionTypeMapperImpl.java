package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.request.PostSubscriptionTypeRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateSubscriptionTypeRequest;
import com.cliente.ws.rasmooplus.dto.response.GetSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.model.SubscriptionType;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SubscriptionTypeMapperImpl implements ISubscriptionTypeMapper{


    @Override
    public SubscriptionType toSubscriptionType(PostSubscriptionTypeRequest request) {

        if (request == null){
            return null;
        }
        var entity = new SubscriptionType();
        entity.setName(request.name());
        entity.setAccessMonth(request.accessMonth());
        entity.setPrice(request.price());
        entity.setProductKey(request.productKey());
        return entity;
    }

    @Override
    public SubscriptionType toSubscriptionType(UpdateSubscriptionTypeRequest request) {
        if (request == null){
            return null;
        }
        var entity = new SubscriptionType();
        entity.setId(request.id());
        entity.setName(request.name());
        entity.setAccessMonth(request.accessMonth());
        entity.setPrice(request.price());
        entity.setProductKey(request.productKey());
        return entity;
    }

    @Override
    public PostSubscriptionTypeResponse toPostSubscriptionTypeResponse(SubscriptionType subscriptionType) {
        if (subscriptionType == null){
            return null;
        }
        return new PostSubscriptionTypeResponse(subscriptionType.getId());

    }

    @Override
    public UpdateSubscriptionTypeResponse toUpdateSubscriptionTypeResponse(SubscriptionType subscriptionType) {
        if (subscriptionType == null) {
            return null;
        }

        return new UpdateSubscriptionTypeResponse(
                subscriptionType.getId(),
                subscriptionType.getName(),
                subscriptionType.getAccessMonth(),
                subscriptionType.getPrice(),
                subscriptionType.getProductKey());
    }

    @Override
    public GetSubscriptionTypeResponse toGetSubscriptionTypeResponse(SubscriptionType subscriptionType) {
        if (subscriptionType == null) {
            return null;
        }

        return new GetSubscriptionTypeResponse(
                subscriptionType.getId(),
                subscriptionType.getName(),
                subscriptionType.getAccessMonth(),
                subscriptionType.getPrice(),
                subscriptionType.getProductKey());
    }

    @Override
    public List<GetSubscriptionTypeResponse> toListGetSubscriptionTypeResponse(List<SubscriptionType> subscriptionTypes) {
        if (subscriptionTypes == null) {
            return null;
        }

        return subscriptionTypes.stream().map(this::toGetSubscriptionTypeResponse).toList();
    }
}
