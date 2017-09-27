package ca.ulaval.glo4002.cart.context;

import ca.ulaval.glo4002.cart.context.configuration.StandardShopConfiguration;
import ca.ulaval.glo4002.cart.context.configuration.XmlPersistenceConfiguration;

public class ProductionContext extends Context {
    @Override
    public void install() {
        applyConfiguration(new XmlPersistenceConfiguration());
        applyConfiguration(new StandardShopConfiguration());
    }

    @Override
    public void runFillers() {
    }
}
