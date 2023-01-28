package card.transactions.infra.translators;

import card.transactions.domain.commands.CardCommand;
import card.transactions.infra.entities.Card;

public class CardCommandToCard {
    public static Card translate(CardCommand command) {
        return command != null ?
                Card.builder()
                        .number(command.getNumber())
                        .password(command.getPassword())
                        .build() : Card.builder().build();
    }
}
