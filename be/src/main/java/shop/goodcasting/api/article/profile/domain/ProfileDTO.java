package shop.goodcasting.api.article.profile.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.goodcasting.api.article.hire.domain.HireDTO;
import shop.goodcasting.api.file.domain.FileDTO;
import shop.goodcasting.api.user.actor.domain.Actor;

import java.sql.Timestamp;
import java.util.ArrayList;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ProfileDTO {
    // pk
    private Long profileId;

    // data
    private boolean privacy;
    private String contents;
    private String career;
    private String resemble;
    private String confidence;
    private Timestamp regDate;
    private Timestamp modDate;

    // join object
    private Actor actor;
    private ArrayList<FileDTO> files;
    private ArrayList<HireDTO> hires;
}