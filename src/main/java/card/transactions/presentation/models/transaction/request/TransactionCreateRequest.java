package card.transactions.presentation.models.transaction.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionCreateRequest {
    @JsonProperty("numeroCartao")
    protected String number;

    @JsonProperty("senhaCartao")
    protected String password;

    @JsonProperty("valor")
    protected Double value;
}
