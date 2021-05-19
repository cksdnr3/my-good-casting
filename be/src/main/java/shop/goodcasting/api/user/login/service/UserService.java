package shop.goodcasting.api.user.login.service;

import shop.goodcasting.api.user.login.domain.UserDTO;
import shop.goodcasting.api.user.login.domain.UserVO;

public interface UserService {
//    String signup(UserDTO userDTO);
//    UserDTO signin(UserDTO userDTO);

    default UserVO dto2Entity(UserDTO userDTO) {
        return UserVO.builder()
                .userId(userDTO.getUserId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .position(userDTO.getPosition())
                .build();
    }
    default UserDTO entity2Dto(UserVO userVO) {
        return UserDTO.builder()
                .userId(userVO.getUserId())
                .username(userVO.getUsername())
                .password(userVO.getPassword())
                .position(userVO.getPosition())
                .build();
    }
}
