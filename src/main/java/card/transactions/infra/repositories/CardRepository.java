package card.transactions.infra.repositories;

import card.transactions.infra.entities.Card;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CardRepository extends BaseRepository<Card, Long> {
    Card findByNumber(String number);
    Card findByNumberAndPassword(String number, String password);
    @Transactional
    @Modifying
    @Query(value = "update cards set balance = :balance, version=version+1 where id = :id and version = :version", nativeQuery = true)
    Integer updateCardBalance(@Param("balance") Double balance, @Param("id") Long id, @Param("version") Integer version);
}
