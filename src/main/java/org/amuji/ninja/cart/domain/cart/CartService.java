package org.amuji.ninja.cart.domain.cart;

import lombok.extern.slf4j.Slf4j;
import org.amuji.ninja.cart.domain.inventory.InventoryService;
import org.amuji.ninja.cart.domain.inventory.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@Service
public class CartService {
    @Autowired
    private InventoryService inventoryService;

    public Cart getCart(String id) {
        Cart cart = new Cart().setId(id);

        List<Product> products = inventoryService.allProducts();

        Random random = new Random();

        int cartSize = random.nextInt(products.size());

        IntStream.range(0, cartSize).forEach(i -> {
            Product product = products.get(random.nextInt(products.size()));
            cart.getItems().add(
                    CartItem.builder()
                            .name(product.getName())
                            .qty(random.nextInt(10))
                            .price(random.nextFloat())
                            .build());
        });

        return cart;
    }
}
