package shop.goodcasting.api.file.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.goodcasting.api.article.hire.domain.Hire;
import shop.goodcasting.api.article.profile.domain.Profile;

import java.sql.Timestamp;

@ToString
@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private Long fileId;
    private String fileName;
    private String uuid;
    private boolean first;
    private Profile profile;
    private Hire hire;
    private Timestamp regDate;
    private Timestamp modDate;
}