package card.transactions.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CommandBase {
    protected Long id;

    protected LocalDateTime createdAt;

    protected LocalDateTime modifiedAt;

    protected LocalDateTime deletedIn;

    protected boolean active = true;

    protected boolean deleted = false;

    protected Integer version;
}
