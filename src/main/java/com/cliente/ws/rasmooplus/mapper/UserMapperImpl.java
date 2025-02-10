package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.request.PostUserRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateUserRequest;
import com.cliente.ws.rasmooplus.dto.response.GetUserResponse;
import com.cliente.ws.rasmooplus.dto.response.PostUserResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateUserResponse;
import com.cliente.ws.rasmooplus.model.SubscriptionType;
import com.cliente.ws.rasmooplus.model.User;
import com.cliente.ws.rasmooplus.model.UserType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapperImpl implements IUserMapper{


    @Override
    public User toUser(PostUserRequest request, UserType userType, SubscriptionType subscriptionType) {

        if (request == null){
            return null;
        }
        var entity = new User();
        entity.setName(request.name());
        entity.setCpf(request.cpf());
        entity.setEmail(request.email());
        entity.setPhone(request.phone());
        entity.setUserType(userType);
        entity.setSubscriptionType(subscriptionType);
        return entity;
    }

    @Override
    public User toUser(UpdateUserRequest request, UserType userType, SubscriptionType subscriptionType) {
        if (request == null){
            return null;
        }
        var entity = new User();
        entity.setName(request.name());
        entity.setCpf(request.cpf());
        entity.setEmail(request.email());
        entity.setPhone(request.phone());
        entity.setUserType(userType);
        entity.setSubscriptionType(subscriptionType);
        return entity;
    }

    @Override
    public PostUserResponse toPostUserResponse(User user) {
        if (user == null){
            return null;
        }
        return new PostUserResponse(user.getId());

    }

    @Override
    public UpdateUserResponse toUpdateUserResponse(User user) {
        if (user == null) {
            return null;
        }

        return new UpdateUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getCpf(),
                user.getDtSubscription()
        );
    }

    @Override
    public GetUserResponse toGetUserResponse(User user) {
        if (user == null) {
            return null;
        }

        return new GetUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getCpf(),
                user.getDtSubscription(),
                user.getDtExpiration(),
                user.getUserType().getId(),
                user.getSubscriptionType().getId()
        );
    }

    @Override
    public List<GetUserResponse> toListGetUserResponse(List<User> users) {
        if (users == null) {
            return null;
        }

        return users.stream().map(this::toGetUserResponse).toList();
    }
}
