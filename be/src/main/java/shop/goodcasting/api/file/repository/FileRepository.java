package shop.goodcasting.api.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.goodcasting.api.article.profile.domain.Profile;
import shop.goodcasting.api.file.domain.FileVO;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileVO, Long>
        , QuerydslPredicateExecutor<FileVO> {
    @Query("select f from FileVO f inner join f.profile p where p.profileId = :profileId")
    List<FileVO> findFileListByProfileId(Long profileId);

    @Query("select f from FileVO f where f.first = :first")
    List<FileVO> findFileListByFirst(boolean first);

    @Query("select f.fileId from FileVO f left join f.profile p where p.profileId = :profileId")
    List<Long> selectFileIdsByProfileId(Long profileId);

    @Modifying
    @Query("delete from FileVO f where f.profile.profileId = :profileId")
    void deleteByProfileId(Long profileId);
}
