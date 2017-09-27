package ca.ulaval.glo4002.cart.infrastructure.persistence.shop;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.PersistenceException;
import ca.ulaval.glo4002.cart.infrastructure.persistence.XmlUtils;

import static java.util.stream.Collectors.toList;

public class XmlShopRepository implements ShopRepository {
    private static final String SHOP_STORAGE = "shop";
    private static File storageFile;

    static {
        storageFile = XmlUtils.createStorageFile(SHOP_STORAGE);
    }

    @Override
    public List<ShopItem> getAvailableItems() {
        return readItemsFromFile().stream().filter(x -> x.isAvailable()).collect(toList());
    }

    @Override
    public void insert(ShopItem item) {
        List<ShopItem> items = readItemsFromFile();
        items.add(item);
        writeItemsToFile(items);
    }

    private List<ShopItem> readItemsFromFile() {
        Unmarshaller unmarshaller = XmlUtils.createUnmarshaller();
        try {
            return ((Shop) unmarshaller.unmarshal(storageFile)).getItems();
        } catch (JAXBException e) {
            return new ArrayList<>();
        }
    }

    private void writeItemsToFile(List<ShopItem> items) {
        Marshaller marshaller = XmlUtils.createMarshaller();
        try {
            marshaller.marshal(new Shop(items), storageFile);
        } catch (JAXBException e) {
            throw new PersistenceException(e);
        }
    }
}
