package shop.goodcasting.api.article.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.goodcasting.api.article.profile.domain.Profile;
import shop.goodcasting.api.article.profile.domain.ProfileDTO;
import shop.goodcasting.api.file.domain.FileVO;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    //    SELECT tracks.name, title, artists.name
//    FROM tracks
//    INNER JOIN albums USING (albumid)
//    INNER JOIN artists USING (artistid)
//    WHERE trackid < 200;
//    @Query("select p from Profile p inner join p.actor a where a.actorId = :actorId")
//    List<Profile> findProfileListByActorId(@Param("actorId") Long actorId, @Param("profileId") Long profileId);

}
