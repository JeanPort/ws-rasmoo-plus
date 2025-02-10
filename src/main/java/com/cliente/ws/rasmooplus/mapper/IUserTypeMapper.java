package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.request.PostUserTypeRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateUserTypeRequest;
import com.cliente.ws.rasmooplus.dto.response.GetUserTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostUserTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateUserTypeResponse;
import com.cliente.ws.rasmooplus.model.UserType;

import java.util.List;

public interface IUserTypeMapper {

    UserType toUserType(PostUserTypeRequest request);
    UserType toUserType(UpdateUserTypeRequest request);

    PostUserTypeResponse toPostUserTypeResponse(UserType userType);
    UpdateUserTypeResponse toUpdateUserTypeResponse(UserType userType);
    GetUserTypeResponse toGetUserTypeResponse(UserType userType);
    List<GetUserTypeResponse> toListGetUserTypeResponse(List<UserType> userTypes);
}
