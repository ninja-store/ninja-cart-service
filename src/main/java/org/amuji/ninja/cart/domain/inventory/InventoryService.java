package org.amuji.ninja.cart.domain.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("ninja-inventory-service")
public interface InventoryService {
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    List<Product> allProducts();
}
