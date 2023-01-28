package card.transactions.domain.gateways.card.interfaces;

public interface CardValidateIfCardHasBalanceGateway {
    boolean execute(String cardNumber, String password);
}
