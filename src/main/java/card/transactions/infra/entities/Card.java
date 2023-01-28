package card.transactions.infra.entities;

import card.transactions.domain.commands.CardCommand;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@Where(clause = "deleted = false")
@SQLDelete(sql = "update cards set deleted = true, deleted_in = NOW() where id = ?")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Card extends EntidadeBase {
    protected String number;
    protected String password;

    public Card(CardCommand command) {
        this.number = command.getNumber();
        this.password = command.getPassword();
    }
}
