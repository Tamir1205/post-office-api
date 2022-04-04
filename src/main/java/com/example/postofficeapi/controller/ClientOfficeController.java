package com.example.postofficeapi.controller;

import com.example.postofficeapi.feign.ClientFeign;
import com.example.postofficeapi.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientOfficeController {
    @Autowired
    private ClientFeign clientFeign;

    @GetMapping("/check")
    public String clientCheck() {
        return clientFeign.clientCheck();
    }

    @GetMapping("/all")
    public List<ClientModel> all() {
        return clientFeign.all();
    }

    @GetMapping("/{id}")
    public ClientModel getClientById(@PathVariable String id){
        return clientFeign.getClientById(id);
    }
}
