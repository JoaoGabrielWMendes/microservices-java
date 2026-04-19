package br.edu.atitus.productservice.dtos;

import com.sun.jdi.DoubleValue;

public record ProductDTO(
    Long id,
    String description,
    String brand,
    String model,
    Double price,
    String currency,
    Integer stock,
    String environment,
    Double convertedPrice,
    String requestedCurrency
) {
}
