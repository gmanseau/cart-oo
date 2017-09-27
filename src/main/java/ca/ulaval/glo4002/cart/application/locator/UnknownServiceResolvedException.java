package ca.ulaval.glo4002.cart.application.locator;

public class UnknownServiceResolvedException extends RuntimeException {
    public <T> UnknownServiceResolvedException(Class<T> contract) {
        super("No implementation was registered for contract " + contract.getSimpleName());
    }
}
