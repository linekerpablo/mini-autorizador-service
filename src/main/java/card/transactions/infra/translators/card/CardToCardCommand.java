package card.transactions.infra.translators.card;

import card.transactions.domain.commands.CardCommand;
import card.transactions.infra.entities.Card;

public class CardToCardCommand {
    public static CardCommand translate(Card card) {
        return card != null ?
                CardCommand.builder()
                        .id(card.getId())
                        .number(card.getNumber())
                        .password(card.getPassword())
                        .balance(card.getBalance())
                        .createdAt(card.getCreatedAt())
                        .deleted(card.isDeleted())
                        .deletedIn(card.getDeletedIn())
                        .active(card.isActive())
                        .build() : null;
    }
}
