package card.transactions.presentation.models.card.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CardResponse {
    protected Long id;

    @JsonProperty("numero")
    protected String number;

    @JsonProperty("senha")
    protected String password;
}
