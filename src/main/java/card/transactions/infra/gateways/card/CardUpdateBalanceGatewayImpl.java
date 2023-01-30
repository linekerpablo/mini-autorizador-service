package card.transactions.infra.gateways.card;

import card.transactions.domain.gateways.card.interfaces.CardUpdateBalanceGateway;
import card.transactions.infra.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardUpdateBalanceGatewayImpl implements CardUpdateBalanceGateway {

    @Autowired
    private CardRepository cardRepository;


    @Override
    public Integer execute(Double balance, Long id, Integer version) {
        return cardRepository.updateCardBalance(balance, id, version);
    }
}
