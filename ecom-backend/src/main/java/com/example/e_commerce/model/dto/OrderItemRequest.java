package com.example.e_commerce.model.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {
}
