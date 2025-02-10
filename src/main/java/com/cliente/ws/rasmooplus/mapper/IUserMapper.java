package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.request.PostUserRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateUserRequest;
import com.cliente.ws.rasmooplus.dto.response.GetUserResponse;
import com.cliente.ws.rasmooplus.dto.response.PostUserResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateUserResponse;
import com.cliente.ws.rasmooplus.model.SubscriptionType;
import com.cliente.ws.rasmooplus.model.User;
import com.cliente.ws.rasmooplus.model.UserType;

import java.util.List;

public interface IUserMapper {

    User toUser(PostUserRequest request, UserType userType, SubscriptionType subscriptionType);
    User toUser(UpdateUserRequest request, UserType userType, SubscriptionType subscriptionType);

    PostUserResponse toPostUserResponse(User request);
    UpdateUserResponse toUpdateUserResponse(User request);
    GetUserResponse toGetUserResponse(User request);
    List<GetUserResponse> toListGetUserResponse(List<User> requests);
}
