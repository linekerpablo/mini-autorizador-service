package card.transactions.domain.usecases.card.interfaces;

public interface CardUpdateBalanceUseCase {
    Integer execute(Double balance, Long id, Integer version);
}
