package ca.ulaval.glo4002.cart.context.filler;

import java.util.logging.Logger;

import ca.ulaval.glo4002.cart.application.locator.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;

public class DemoDataFiller implements Filler {

    @Override
    public void run() {
        Logger.getGlobal().info("Prefilling data in the shop for the demo");

        ShopRepository shopRepository = ServiceLocator.INSTANCE.resolve(ShopRepository.class);
        shopRepository.insert(new ShopItem("1251521", "Peanuts", 1.20, true));
        shopRepository.insert(new ShopItem("236637", "Clean Code", 0.50, false));
        shopRepository.insert(new ShopItem("235265", "Détendeur Mares Abyss Navy 22", 0.15, true));
        shopRepository.insert(new ShopItem("276101", "Imprimante 3D", 0.60, true));
        shopRepository.insert(new ShopItem("818113", "GoPro", 4.60, true));
        shopRepository.insert(new ShopItem("51-153", "Peinture à numéro", 1.40, true));
    }
}
