package card.transactions.domain.gateways.card.interfaces;

public interface CardUpdateBalanceGateway {
    Integer execute(Double balance, Long id, Integer version);
}
