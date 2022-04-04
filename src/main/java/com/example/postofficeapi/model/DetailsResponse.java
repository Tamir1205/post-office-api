package com.example.postofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailsResponse {
    private String postId;
    private ClientModel client;
    private ClientModel receiver;
    private String postItem;
    private String status;
}
