package com.cliente.ws.rasmooplus.controller;

import com.cliente.ws.rasmooplus.dto.request.PostSubscriptionTypeRequest;
import com.cliente.ws.rasmooplus.dto.request.UpdateSubscriptionTypeRequest;
import com.cliente.ws.rasmooplus.dto.response.GetSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.PostSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.dto.response.UpdateSubscriptionTypeResponse;
import com.cliente.ws.rasmooplus.service.ISubscriptionTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subscriptions-type")
public class SubscriptionTypeController {


    private final ISubscriptionTypeService service;

    public SubscriptionTypeController(ISubscriptionTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GetSubscriptionTypeResponse>> findAll() {
        var res = service.findAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSubscriptionTypeResponse> findById(@PathVariable Long id){
        var res = service.findById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<PostSubscriptionTypeResponse> create(@RequestBody PostSubscriptionTypeRequest request) {
        var  res = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping
    public ResponseEntity<UpdateSubscriptionTypeResponse> update(@RequestBody UpdateSubscriptionTypeRequest request) {
        var res = service.update(request);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
