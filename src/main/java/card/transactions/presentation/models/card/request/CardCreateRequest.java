package card.transactions.presentation.models.card.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CardCreateRequest {
    @JsonProperty("numero")
    protected String number;
    @JsonProperty("senha")
    protected String password;
}
