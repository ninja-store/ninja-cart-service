package org.amuji.ninja.cart.domain.cart;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private String name;
    private int qty;
    private float price;
}
