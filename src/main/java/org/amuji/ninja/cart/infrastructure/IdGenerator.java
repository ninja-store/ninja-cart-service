package org.amuji.ninja.cart.infrastructure;

import java.util.UUID;

public class IdGenerator {
    public static String next() {
        return UUID.randomUUID().toString();
    }
}
