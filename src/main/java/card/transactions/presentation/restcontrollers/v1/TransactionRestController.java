package card.transactions.presentation.restcontrollers.v1;

import card.transactions.domain.usecases.transaction.interfaces.TransactionCreateUseCase;
import card.transactions.presentation.models.card.response.CardResponse;
import card.transactions.presentation.models.transaction.request.TransactionCreateRequest;
import card.transactions.presentation.translators.transaction.request.TransactionCreateRequestToTransactionCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transacoes")
public class TransactionRestController {

    @Autowired
    private TransactionCreateUseCase transactionCreateUseCase;

    @Operation(summary = "Realizar uma Transação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação realizada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CardResponse.class))}),
            @ApiResponse(responseCode = "422", description = "Erro ao realizar transação",
                    content = @Content)})
    @PostMapping
    public ResponseEntity post(@RequestBody TransactionCreateRequest transactionCreateRequest) {
        var transactionCommand = TransactionCreateRequestToTransactionCommand.translate(transactionCreateRequest);

        transactionCreateUseCase.execute(transactionCommand);

        return ResponseEntity.ok("OK");
    }
}
