package card.transactions.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
public class TransactionCommand extends CommandBase {
    protected String number;
    protected String password;
    protected Double value;
}
