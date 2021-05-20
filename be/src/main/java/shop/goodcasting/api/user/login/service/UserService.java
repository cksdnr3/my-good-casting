package shop.goodcasting.api.user.login.service;

import shop.goodcasting.api.user.login.domain.UserDTO;
import shop.goodcasting.api.user.login.domain.UserVO;

import java.util.Optional;

public interface UserService {
    String signup(UserDTO userDTO);
    UserDTO signin(UserDTO userDTO);
    UserDTO findById(Long id);
    Optional<UserVO> findByUsername(String username);

    default UserVO dto2Entity(UserDTO dto) {
        return UserVO.builder()
                .userId(dto.getUserId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .position(dto.getPosition())
                .roles(dto.getRoles())
                .build();
    }
    default UserDTO entity2Dto(UserVO entity) {
        return UserDTO.builder()
                .userId(entity.getUserId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .position(entity.getPosition())
                .roles(entity.getRoles())
                .build();
    }
}
