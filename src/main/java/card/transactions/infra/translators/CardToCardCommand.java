package card.transactions.infra.translators;

import card.transactions.domain.commands.CardCommand;
import card.transactions.infra.entities.Card;

public class CardToCardCommand {
    public static CardCommand translate(Card card) {
        return card != null ?
                CardCommand.builder()
                        .id(card.getId())
                        .number(card.getNumber())
                        .password(card.getPassword())
                        .build() : null;
    }
}
