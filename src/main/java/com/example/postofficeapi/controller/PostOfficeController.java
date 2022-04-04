package com.example.postofficeapi.controller;

import com.example.postofficeapi.feign.ClientFeign;
import com.example.postofficeapi.feign.PostFeign;
import com.example.postofficeapi.model.ClientModel;
import com.example.postofficeapi.model.DetailsResponse;
import com.example.postofficeapi.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostOfficeController {

    @Autowired
    private PostFeign postFeign;

    @Autowired
    private ClientFeign clientFeign;

    @GetMapping("/check")
    public String postCheck() {
        return postFeign.postCheck();
    }

    @GetMapping("/all")
    public List<PostModel> all() {
        return postFeign.all();
    }

    @GetMapping("/{id}")
    public PostModel getPostById(@PathVariable String id) {
        return postFeign.getPostById(id);
    }

    @GetMapping("/detail/{id}")
    public DetailsResponse getDetailPostById(@PathVariable String id) {
        DetailsResponse detailsResponse = new DetailsResponse();
        PostModel postModel = postFeign.getPostById(id);
        detailsResponse.setPostId(postModel.getPostId());
        detailsResponse.setPostItem(postModel.getPostItem());
        detailsResponse.setStatus(postModel.getStatus());
        detailsResponse.setClient(clientFeign.getClientById(postModel.getClientId()));
        detailsResponse.setReceiver(clientFeign.getClientById(postModel.getPostRecepientId()));
        return detailsResponse;
    }
}
