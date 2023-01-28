package card.transactions.infra.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
public class Card extends EntidadeBase {
    protected String number;

    protected String password;

    protected Double balance;
}
