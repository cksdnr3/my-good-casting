package shop.goodcasting.api.user.actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.goodcasting.api.article.profile.domain.Profile;
import shop.goodcasting.api.user.actor.domain.Actor;
import shop.goodcasting.api.user.login.domain.UserDTO;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>
        , QuerydslPredicateExecutor<Actor> {
    @Modifying
    @Query("update UserVO u set u.account = :account where u.userId = :user_id")
    void accountUpdate(@Param("user_id") Long userId, @Param("account") boolean account);

    @Modifying
    @Query("update UserVO u set u.password = :password where u.userId = :user_id")
    void passwordUpdate(@Param("user_id") Long userId, @Param("password") String password);

    @Query("select p.profileId from Actor a left join Profile p on a.actorId = p.actor.actorId where a.actorId = :actor_id")
    Long getProfileId (@Param("actor_id") Long actorId);

}