package ca.ulaval.glo4002.cart.context;

import java.util.logging.Logger;

import ca.ulaval.glo4002.cart.context.configuration.Configuration;
import ca.ulaval.glo4002.cart.context.filler.Filler;

public abstract class Context {
    private static final String DEMO_MODE = "demo";
    public static final String MODE_PROPERTY = "mode";
    private static final String PRODUCTION_MODE = "prod";

    public static Context create() {
        String mode = System.getProperty(MODE_PROPERTY);

        if (mode == null || mode.equals(DEMO_MODE)) {
            Logger.getGlobal().info("!! Running with demo context");
            return new DemoContext();
        }

        if (mode.equals(PRODUCTION_MODE)) {
            Logger.getGlobal().info("!! Running with PRODUCTION context");
            return new ProductionContext();
        }

        throw new UnknownModeException("Unknown mode providedd with -Dmode : " + mode);
    }

    public abstract void install();

    public abstract void runFillers();

    protected void applyConfiguration(Configuration configuration) {
        configuration.apply();
    }

    protected void runFiller(Filler filler) {
        filler.run();
    }
}
