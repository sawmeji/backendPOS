package com.example.backendpos.entity;

public record BestSeller(
        Integer id,
        String name,
        double price,
        long count
) {
}
