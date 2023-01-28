package card.transactions.domain.gateways.card.interfaces;

import card.transactions.domain.commands.CardCommand;

public interface CardCreateGateway {
    CardCommand execute(CardCommand command);
}
