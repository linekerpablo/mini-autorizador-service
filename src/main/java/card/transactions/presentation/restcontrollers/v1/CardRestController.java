package card.transactions.presentation.restcontrollers.v1;

import card.transactions.domain.usecases.card.interfaces.CardCreateUseCase;
import card.transactions.domain.usecases.card.interfaces.CardFindByNumberUseCase;
import card.transactions.presentation.exceptions.ErrorClientException;
import card.transactions.presentation.models.card.request.CardCreateRequest;
import card.transactions.presentation.models.card.response.CardResponse;
import card.transactions.presentation.translators.card.request.CardCreateRequestToCardCommand;
import card.transactions.presentation.translators.card.response.CardCommandToCardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cartoes")
public class CardRestController {

    @Autowired
    private CardCreateUseCase cardCreateUseCase;

    @Autowired
    private CardFindByNumberUseCase cardFindByNumberUseCase;

    @Operation(summary = "Criar novo cartão")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cartão criado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CardResponse.class))}),
            @ApiResponse(responseCode = "422", description = "Cartão já existe cadastrado",
                    content = @Content)})
    @PostMapping
    public ResponseEntity<CardResponse> post(@RequestBody CardCreateRequest cardCreateRequest) {
        cardFindByNumberUseCase.execute(cardCreateRequest.getNumber())
                .ifPresent(card -> {
                    throw new ErrorClientException(CardCommandToCardResponse.translate(card), HttpStatus.UNPROCESSABLE_ENTITY, "Cartão já existe cadastrado");
                });

        var cardCommand = CardCreateRequestToCardCommand.translate(cardCreateRequest);

        cardCommand = cardCreateUseCase.execute(cardCommand);

        return ResponseEntity.status(HttpStatus.CREATED).body(CardCommandToCardResponse.translate(cardCommand));
    }

    @Operation(summary = "Buscar saldo do cartão informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cartão encontrado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CardResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Cartão informado não existe",
                    content = @Content)})
    @GetMapping("/{numeroCartao}")
    public ResponseEntity<CardResponse> getCardBalanceByCardNumber(@PathVariable String cardNumber) {
        var cardCommand = cardFindByNumberUseCase.execute(cardNumber).orElseThrow(() -> new ErrorClientException(null, HttpStatus.NOT_FOUND, "Cartão não existe"));

        return ResponseEntity.status(HttpStatus.CREATED).body(CardCommandToCardResponse.translate(cardCommand));
    }
}
