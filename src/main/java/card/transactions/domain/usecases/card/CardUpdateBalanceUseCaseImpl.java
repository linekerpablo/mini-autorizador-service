package card.transactions.domain.usecases.card;

import card.transactions.domain.gateways.card.interfaces.CardUpdateBalanceGateway;
import card.transactions.domain.usecases.card.interfaces.CardUpdateBalanceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardUpdateBalanceUseCaseImpl implements CardUpdateBalanceUseCase {

    @Autowired
    private CardUpdateBalanceGateway cardUpdateBalanceGateway;

    @Override
    public Integer execute(Double balance, Long id, Integer version) {
        return cardUpdateBalanceGateway.execute(balance, id, version);
    }
}
