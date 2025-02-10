package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.request.PostUserTypeRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateUserTypeRequest;
import com.cliente.ws.rasmooplus.dto.response.GetUserTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostUserTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateUserTypeResponse;

import java.util.List;

public interface IUserTypeService {

    List<GetUserTypeResponse> findAll();
    GetUserTypeResponse findById(Long id);
    UpdateUserTypeResponse update(UpdateUserTypeRequest userType);
    void deleteById(Long id);
    PostUserTypeResponse create(PostUserTypeRequest userType);
}
