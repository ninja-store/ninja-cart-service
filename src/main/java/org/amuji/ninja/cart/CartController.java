package org.amuji.ninja.cart;

import org.amuji.ninja.cart.domain.cart.Cart;
import org.amuji.ninja.cart.domain.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService service;

    @GetMapping("/{id}")
    public Cart theCart(@PathVariable String id) {
        return service.getCart(id);
    }
}
