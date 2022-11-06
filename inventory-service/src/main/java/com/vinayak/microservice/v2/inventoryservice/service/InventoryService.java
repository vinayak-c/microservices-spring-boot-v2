package com.vinayak.microservice.v2.inventoryservice.service;

import com.vinayak.microservice.v2.inventoryservice.model.InventoryResponse;
import com.vinayak.microservice.v2.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventoryResponse ->
                        InventoryResponse.builder()
                                .skuCode(inventoryResponse.getSkuCode())
                                .isInStock(inventoryResponse.getQuantity() > 0)
                                .build()
                ).collect(Collectors.toList());
    }

}
