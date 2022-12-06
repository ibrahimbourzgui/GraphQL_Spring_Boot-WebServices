package com.ibrahim.inventory.dto;
//Un record c'est une classe qui contient les getters
public record ProductDto (
     String id,
     String name,
     double price,
     int quantity,
     Long categoryId
) {}
