package card.transactions.infra.repositories;

import card.transactions.infra.entities.Card;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends BaseRepository<Card, Long> {
    Card findByNumber(String number);
}
