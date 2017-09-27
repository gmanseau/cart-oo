package ca.ulaval.glo4002.cart.application;

import java.util.Optional;

import ca.ulaval.glo4002.cart.application.locator.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.cart.Cart;
import ca.ulaval.glo4002.cart.domain.cart.CartItemFactory;
import ca.ulaval.glo4002.cart.domain.cart.CartRepository;
import ca.ulaval.glo4002.cart.domain.shop.ShopItem;

public class CartApplicationService {

    private CartRepository cartRepository;
    private final CartItemFactory cartItemFactory;

    public CartApplicationService() {
        this.cartRepository = ServiceLocator.INSTANCE.resolve(CartRepository.class);
        this.cartItemFactory = ServiceLocator.INSTANCE.resolve(CartItemFactory.class);
    }

    public Cart findOrCreateCartForClient(String email) {
        Optional<Cart> cart = cartRepository.findCartByOwner(email);
        if (!cart.isPresent()) {
            Cart newCart = new Cart(email);
            cartRepository.insert(newCart);
            return newCart;
        }

        return cart.get();
    }

    public void addItemToCart(String email, ShopItem item) {
        Cart cart = cartRepository.findCartByOwner(email).orElseThrow(CartNotFoundException::new);

        cart.addItem(cartItemFactory.create(item));

        cartRepository.update(cart);
    }
}
