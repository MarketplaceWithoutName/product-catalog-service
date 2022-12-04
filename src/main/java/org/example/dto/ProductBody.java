package org.example.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductBody {

    UUID id;
    String name;
    String code;
}
