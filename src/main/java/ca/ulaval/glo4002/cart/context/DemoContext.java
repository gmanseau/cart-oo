package ca.ulaval.glo4002.cart.context;

import java.util.logging.Logger;

import ca.ulaval.glo4002.cart.context.configuration.InMemoryPersistenceConfiguration;
import ca.ulaval.glo4002.cart.context.configuration.PromoShopConfiguration;
import ca.ulaval.glo4002.cart.context.configuration.StandardShopConfiguration;
import ca.ulaval.glo4002.cart.context.configuration.XmlPersistenceConfiguration;
import ca.ulaval.glo4002.cart.context.filler.DemoDataFiller;

public class DemoContext extends Context {

    private static final String STORE_TYPE_PROPERTY = "store";
    private static final String SHOP_PROMO_FLAG = "promo";
    private static final String STORE_TYPE_XML = "xml";

    @Override
    public void install() {
        installPersistence();
        installShop();
    }

    private void installPersistence() {
        String storeType = System.getProperty(STORE_TYPE_PROPERTY);
        if (storeType == null || storeType.equals(STORE_TYPE_XML)) {
            Logger.getGlobal().info("Using XML store");
            applyConfiguration(new XmlPersistenceConfiguration());
        } else {
            Logger.getGlobal().info("Using in-memory store");
            applyConfiguration(new InMemoryPersistenceConfiguration());
        }
    }

    private void installShop() {
        String isPromo = System.getProperty(SHOP_PROMO_FLAG);
        if (isPromo != null && isPromo.equals("true")) {
            Logger.getGlobal().info("Using PROMO store");
            applyConfiguration(new PromoShopConfiguration());
        } else {
            Logger.getGlobal().info("Using standard store");
            applyConfiguration(new StandardShopConfiguration());
        }
    }

    @Override
    public void runFillers() {
        runFiller(new DemoDataFiller());
    }
}
