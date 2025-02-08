package com.cliente.ws.rasmooplus.controller;

import com.cliente.ws.rasmooplus.model.SubscriptionType;
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
    public ResponseEntity<List<SubscriptionType>> findAll() {
        var res = service.findAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable Long id){
        var res = service.findById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody SubscriptionType subscriptionType) {
        var  res = service.create(subscriptionType);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping
    public ResponseEntity<SubscriptionType> update(@RequestBody SubscriptionType subscriptionType) {
        var res = service.update(subscriptionType);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
