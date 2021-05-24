package shop.goodcasting.api.user.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import shop.goodcasting.api.article.profile.domain.Profile;
import shop.goodcasting.api.user.producer.domain.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long>
        , QuerydslPredicateExecutor<Producer> {

}