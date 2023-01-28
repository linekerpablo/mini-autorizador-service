package card.transactions.infra.repositories;

import card.transactions.infra.entities.Transaction;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long> {
}
