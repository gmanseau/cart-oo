package ca.ulaval.glo4002.cart.infrastructure.persistence;

public class CannotUpdateException extends RuntimeException {
    public CannotUpdateException(String msg) {
        super(msg);
    }
}
