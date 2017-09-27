package ca.ulaval.glo4002.cart.domain.cart;

import java.util.Optional;

public interface CartRepository {
    void insert(Cart cart);

    void update(Cart cart);

    Optional<Cart> findCartByOwner(String email);
}
