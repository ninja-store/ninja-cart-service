package org.amuji.ninja.cart.domain.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@FeignClient(value = "ninja-inventory-service", fallback = InventoryService.DegradedInventoryService.class)
public interface InventoryService {
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    List<Product> allProducts();

    @Component
    @Slf4j
    public static class DegradedInventoryService implements InventoryService {
        @Override
        public List<Product> allProducts() {
            log.error("Failed to connect to inventory service, force return empty list.");
            return Collections.emptyList();
        }
    }
}
