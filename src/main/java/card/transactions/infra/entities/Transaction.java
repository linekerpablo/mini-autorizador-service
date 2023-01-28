package card.transactions.infra.entities;

import card.transactions.domain.commands.TransactionCommand;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
@Where(clause = "deleted = false")
@SQLDelete(sql = "update transactions set deleted = true, deleted_in = NOW() where id = ?")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends EntidadeBase {
    protected String number;
    protected String password;
    protected Double value;
}
