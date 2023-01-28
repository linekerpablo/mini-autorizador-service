package card.transactions.infra.gateways.card;

import card.transactions.domain.gateways.card.interfaces.CardValidateIfCardHasBalanceGateway;
import card.transactions.infra.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardValidateIfCardHasBalanceGatewayImpl implements CardValidateIfCardHasBalanceGateway {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public boolean execute(String cardNumber, String password) {
        return false;
    }
}
