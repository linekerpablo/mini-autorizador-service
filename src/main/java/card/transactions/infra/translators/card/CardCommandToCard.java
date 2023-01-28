package card.transactions.infra.translators.card;

import card.transactions.domain.commands.CardCommand;
import card.transactions.infra.entities.Card;

public class CardCommandToCard {
    public static Card translate(CardCommand command) {
        return command != null ?
                Card.builder()
                        .number(command.getNumber())
                        .password(command.getPassword())
                        .balance(command.getBalance())
                        .createdAt(command.getCreatedAt())
                        .deleted(command.isDeleted())
                        .deletedIn(command.getDeletedIn())
                        .active(command.isActive())
                        .build() : Card.builder().build();
    }
}
