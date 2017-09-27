package ca.ulaval.glo4002.cart.infrastructure.persistence.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import ca.ulaval.glo4002.cart.domain.cart.Cart;
import ca.ulaval.glo4002.cart.domain.cart.CartRepository;

public class InMemoryCartRepository implements CartRepository {
    private static final Map<String, Cart> CARTS = new HashMap<>();

    @Override
    public void insert(Cart cart) {
        CARTS.put(cart.ownerEmail, cart);
    }

    @Override
    public void update(Cart cart) {
        CARTS.replace(cart.ownerEmail, cart);
    }

    @Override
    public Optional<Cart> findCartByOwner(String email) {
        Cart cart = CARTS.get(email);
        return Optional.ofNullable(cart);
    }
}
