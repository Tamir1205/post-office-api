package com.example.postofficeapi.feign;

import com.example.postofficeapi.model.ClientModel;
import com.example.postofficeapi.model.PostModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("post-core-api")

public interface PostFeign {
    @GetMapping("/post/check")
    String postCheck();

    @GetMapping("/post/all")
    List<PostModel> all();

    @GetMapping("/post/{id}")
    PostModel getPostById(@PathVariable String id);
}

