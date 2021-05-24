package shop.goodcasting.api.article.hire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import shop.goodcasting.api.article.hire.domain.Hire;
import shop.goodcasting.api.article.profile.domain.Profile;

@Repository
public interface HireRepository extends JpaRepository<Hire, Long>
        , QuerydslPredicateExecutor<Hire> {
}
