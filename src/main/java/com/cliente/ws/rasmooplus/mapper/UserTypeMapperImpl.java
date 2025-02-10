package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.request.PostUserTypeRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateUserTypeRequest;
import com.cliente.ws.rasmooplus.dto.response.GetUserTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostUserTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateUserTypeResponse;
import com.cliente.ws.rasmooplus.model.UserType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTypeMapperImpl implements IUserTypeMapper{


    @Override
    public UserType toUserType(PostUserTypeRequest request) {

        if (request == null){
            return null;
        }
        var entity = new UserType();
        entity.setName(request.name());
        entity.setDescription(request.description());
        return entity;
    }

    @Override
    public UserType toUserType(UpdateUserTypeRequest request) {
        if (request == null){
            return null;
        }
        var entity = new UserType();
        entity.setId(request.id());
        entity.setName(request.name());
        entity.setDescription(request.description());
        return entity;
    }

    @Override
    public PostUserTypeResponse toPostUserTypeResponse(UserType userType) {
        if (userType == null){
            return null;
        }
        return new PostUserTypeResponse(userType.getId());

    }

    @Override
    public UpdateUserTypeResponse toUpdateUserTypeResponse(UserType userType) {
        if (userType == null) {
            return null;
        }

        return new UpdateUserTypeResponse(
                userType.getId(),
                userType.getName(),
                userType.getDescription());
    }

    @Override
    public GetUserTypeResponse toGetUserTypeResponse(UserType userType) {
        if (userType == null) {
            return null;
        }

        return new GetUserTypeResponse(
                userType.getId(),
                userType.getName(),
                userType.getDescription());
    }

    @Override
    public List<GetUserTypeResponse> toListGetUserTypeResponse(List<UserType> userTypes) {
        if (userTypes == null) {
            return null;
        }

        return userTypes.stream().map(this::toGetUserTypeResponse).toList();
    }
}
