package com.vinayak.microservice.v2.inventoryservice.service;

import com.vinayak.microservice.v2.inventoryservice.model.InventoryResponse;
import com.vinayak.microservice.v2.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        log.info("Wait started for slow response simulation");
        Thread.sleep(10000);
        log.info("Wait ended for slow response simulation");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventoryResponse ->
                        InventoryResponse.builder()
                                .skuCode(inventoryResponse.getSkuCode())
                                .isInStock(inventoryResponse.getQuantity() > 0)
                                .build()
                ).collect(Collectors.toList());
    }

}
