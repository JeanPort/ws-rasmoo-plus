package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.request.PostUserRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateUserRequest;
import com.cliente.ws.rasmooplus.dto.response.GetUserResponse;
import com.cliente.ws.rasmooplus.dto.response.PostUserResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateUserResponse;

import java.util.List;

public interface IUserService {

    List<GetUserResponse> findAll();
    GetUserResponse findById(Long id);
    UpdateUserResponse update(UpdateUserRequest request);
    void deleteById(Long id);
    PostUserResponse create(PostUserRequest request);
}
