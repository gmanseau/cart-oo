package ca.ulaval.glo4002.cart.infrastructure.persistence.cart;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ca.ulaval.glo4002.cart.domain.cart.Cart;
import ca.ulaval.glo4002.cart.domain.cart.CartRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.CannotUpdateException;
import ca.ulaval.glo4002.cart.infrastructure.persistence.PersistenceException;
import ca.ulaval.glo4002.cart.infrastructure.persistence.XmlUtils;

public class XmlCartRepository implements CartRepository {
    private static final String CART_STORAGE = "cart-storage";

    private static File storageFile;

    static {
        storageFile = XmlUtils.createStorageFile(CART_STORAGE);
    }

    @Override
    public void insert(Cart cart) {
        List<Cart> carts = readCartsFromFile();
        carts.add(cart);
        writeCartsToFile(carts);
    }

    @Override
    public void update(Cart cart) {
        List<Cart> carts = readCartsFromFile();
        Optional<Cart> existingCart = carts.stream().filter(c -> c.ownerEmail.equals(cart.ownerEmail)).findFirst();
        if (existingCart.isPresent()) {
            carts.remove(existingCart.get());
        } else {
            throw new CannotUpdateException("Cart for owner " + cart.ownerEmail + " does not exist");
        }

        carts.add(cart);
        writeCartsToFile(carts);
    }

    @Override
    public Optional<Cart> findCartByOwner(String email) {
        List<Cart> carts = readCartsFromFile();
        return carts.stream().filter(c -> c.ownerEmail.equals(email)).findFirst();
    }

    private void writeCartsToFile(List<Cart> carts) {
        Marshaller marshaller = XmlUtils.createMarshaller();
        try {
            marshaller.marshal(new CartList(carts), storageFile);
        } catch (JAXBException e) {
            throw new PersistenceException(e);
        }
    }

    private List<Cart> readCartsFromFile() {
        Unmarshaller unmarshaller = XmlUtils.createUnmarshaller();
        try {
            return ((CartList) unmarshaller.unmarshal(storageFile)).getCarts();
        } catch (JAXBException e) {
            return new ArrayList<>();
        }
    }
}
