package org.amuji.ninja.cart.domain.cart;

import lombok.ToString;
import org.amuji.ninja.cart.infrastructure.IdGenerator;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Cart {
    private String id = IdGenerator.next();
    private List<CartItem> items = new ArrayList<>();

    public String getId() {
        return id;
    }

    public Cart setId(String id) {
        this.id = id;
        return this;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public Cart setItems(List<CartItem> items) {
        this.items = items;
        return this;
    }
}
