package card.transactions.presentation.translators.card.response;

import card.transactions.domain.commands.CardCommand;
import card.transactions.presentation.models.card.response.CardResponse;

public class CardCommandToCardResponse {
    public static CardResponse translate(CardCommand command) {
        return command != null ?
                CardResponse.builder()
                        .id(command.getId())
                        .number(command.getNumber())
                        .password(command.getPassword())
                        .build() : CardResponse.builder().build();
    }
}
