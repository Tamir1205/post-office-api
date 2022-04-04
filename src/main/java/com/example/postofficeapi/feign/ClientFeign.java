package com.example.postofficeapi.feign;

import com.example.postofficeapi.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("client-core-api")
public interface ClientFeign {
    @GetMapping("/client/check")
    String clientCheck();

    @GetMapping("/client/all")
    List<ClientModel> all();

    @GetMapping("/client/{id}")
    ClientModel getClientById(@PathVariable String id);
}