package com.cliente.ws.rasmooplus.controller;

import com.cliente.ws.rasmooplus.dto.request.PostUserTypeRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateUserTypeRequest;
import com.cliente.ws.rasmooplus.dto.response.GetUserTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostUserTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateUserTypeResponse;
import com.cliente.ws.rasmooplus.service.IUserTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users-type")
public class UserTypeController {


    private final IUserTypeService service;

    public UserTypeController(IUserTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GetUserTypeResponse>> findAll() {
        var res = service.findAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserTypeResponse> findById(@PathVariable Long id){
        var res = service.findById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<PostUserTypeResponse> create(@RequestBody @Valid PostUserTypeRequest request) {
        var  res = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping
    public ResponseEntity<UpdateUserTypeResponse> update(@RequestBody @Valid UpdateUserTypeRequest request) {
        var res = service.update(request);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
