package com.cliente.ws.rasmooplus.controller;

import com.cliente.ws.rasmooplus.dto.request.PostUserRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateUserRequest;
import com.cliente.ws.rasmooplus.dto.response.GetUserResponse;
import com.cliente.ws.rasmooplus.dto.response.PostUserResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateUserResponse;
import com.cliente.ws.rasmooplus.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {


    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GetUserResponse>> findAll() {
        var res = service.findAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> findById(@PathVariable Long id){
        var res = service.findById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<PostUserResponse> create(@RequestBody @Valid PostUserRequest request) {
        var  res = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping
    public ResponseEntity<UpdateUserResponse> update(@RequestBody @Valid UpdateUserRequest request) {
        var res = service.update(request);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
