package card.transactions.infra.repositories;

import card.transactions.infra.entities.EntidadeBase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends EntidadeBase, K> extends CrudRepository<T, K> {
}
