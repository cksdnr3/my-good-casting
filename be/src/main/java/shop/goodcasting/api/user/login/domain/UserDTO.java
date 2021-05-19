package shop.goodcasting.api.user.login.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@ToString
@Builder
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String username;
    private String password;
    private Boolean position;
    private Timestamp regDate;
    private Timestamp modDate;

    private String token;
}