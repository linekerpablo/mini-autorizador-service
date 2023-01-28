package card.transactions.presentation.translators.card.request;

import card.transactions.domain.commands.CardCommand;
import card.transactions.presentation.models.card.request.CardCreateRequest;

public class CardCreateRequestToCardCommand {
    public static CardCommand translate(CardCreateRequest request) {
        return request != null ?
                CardCommand.builder()
                        .number(request.getNumber())
                        .password(request.getPassword())
                        .build() : CardCommand.builder().build();
    }
}
