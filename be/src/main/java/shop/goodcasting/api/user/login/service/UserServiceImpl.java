package shop.goodcasting.api.user.login.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
//    private final UserRepository userRepo;
//    private final ActorRepository actorRepo;
//    private final ProducerRepository producerRepo;
//    private final PasswordEncoder passwordEncoder;

//    private final AuthenticationManager manager;

//    @Override
//    public String signup(UserDTO userDTO) {
//        if(!userRepo.existsByUsername(userDTO.getUsername())){
//            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//
//            Boolean position = userDTO.getPosition();
//            Actor actor = new Actor();
//            Producer producer = new Producer();
//
//            if(position){
//                actorList.add(Role.USER);
//                userDTO.setRoles(actorList);
//
//                UserVO userVO = dto2Entity(userDTO);
//
//                userRepo.save(userVO);
//                actor.changeUserVO(userVO);
//                actorRepo.save(actor);
//            } else {
//                producerList.add(Role.USER);
//                userDTO.setRoles(producerList);
//
//                UserVO userVO = dto2Entity(userDTO);
//
//                userRepo.save(userVO);
//                producer.changeUserVO(userVO);
//                producerRepo.save(producer);
//            }
//            return provider.createToken(userDTO.getUsername(), userDTO.getRoles());
//        }else{
//            throw new SecurityRuntimeException("중복된 username", HttpStatus.UNPROCESSABLE_ENTITY);
//        }
//    }
//
//    @Override
//    public UserDTO signin(UserDTO userDTO) {
//        try{
//            UserVO userVO = dto2Entity(userDTO);
//
//            String token = (passwordEncoder.matches(userVO.getPassword(), userRepo.findByUsername(userVO.getUsername()).get().getPassword()))
//                    ?provider.createToken(userVO.getUsername(), userRepo.findByUsername(userVO.getUsername()).get().getRoles())
//                    : "Wrong password";
//
//            userDTO.setToken(token);
//            return userDTO;
//        }catch(Exception e){
//            throw new SecurityRuntimeException("유효하지 않은 아이디 / 비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
//        }
//    }


}
