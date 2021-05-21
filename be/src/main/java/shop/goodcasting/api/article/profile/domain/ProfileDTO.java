package shop.goodcasting.api.article.profile.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.goodcasting.api.common.domain.HireProfile;
import shop.goodcasting.api.file.domain.FileDTO;
import shop.goodcasting.api.user.actor.domain.Actor;
import shop.goodcasting.api.user.actor.domain.ActorDTO;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.List;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ProfileDTO {
    // pk
    private Long profileId;
    private String title;
    private boolean privacy;
    private String contents;
    private String career;
    private String resemble;
    private String confidence;
    private Timestamp regDate;
    private Timestamp modDate;

    private ActorDTO actor;

    private List<FileDTO> files;
    private List<HireProfile> hires;
}