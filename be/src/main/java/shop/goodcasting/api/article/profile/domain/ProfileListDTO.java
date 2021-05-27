package shop.goodcasting.api.article.profile.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.goodcasting.api.file.domain.FileDTO;
import shop.goodcasting.api.user.actor.domain.ActorDTO;

import java.sql.Timestamp;
import java.util.List;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ProfileListDTO {
    // pk
    private Long profileId;

    private boolean privacy;
    private String resemble;
    private Double confidence;
    private String actorName;
    private String fileUuid;
    private String fileName;
    private Timestamp regDate;
    private Timestamp modDate;
}