package shop.goodcasting.api.article.profile.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import shop.goodcasting.api.article.profile.domain.Profile;
import shop.goodcasting.api.article.profile.domain.ProfileDTO;
import shop.goodcasting.api.article.profile.repository.ProfileRepository;
import shop.goodcasting.api.file.domain.FileVO;
import shop.goodcasting.api.file.domain.FileDTO;
import shop.goodcasting.api.file.repository.FileRepository;
import shop.goodcasting.api.file.service.FileService;
import shop.goodcasting.api.user.actor.domain.Actor;
import shop.goodcasting.api.user.actor.domain.ActorDTO;
import shop.goodcasting.api.user.actor.repository.ActorRepository;
import shop.goodcasting.api.user.actor.service.ActorService;
import shop.goodcasting.api.user.login.domain.UserVO;
import shop.goodcasting.api.user.login.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepo;
    private final FileRepository fileRepo;
    private final FileService fileService;
    private final ActorService actorService;
    private final UserRepository userRepo;
    private final ActorRepository actorRepo;

    @Transactional
    @Override
    public Long register(ProfileDTO profileDTO) {
        Actor actor = profileDTO.getActor();

        System.out.println(actor);

        UserVO user = actor.getUser();

        System.out.println(user);

        Profile profile = dto2Entity(profileDTO);
        System.out.println("service - register - profile: " + profile);

        userRepo.save(user);

        actorRepo.save(actor);

        Profile finalProfile = profileRepo.save(profile);

        System.out.println("final Profile ********************** " + finalProfile);

        List<FileDTO> files = profileDTO.getFiles();

        if(files != null && files.size() > 0) {

            files.forEach(fileDTO -> {
                fileDTO.setProfile(finalProfile);
                FileVO file = fileService.dto2Entity(fileDTO);

                fileRepo.save(file);
            });
        }

        return null;
    }

    @Transactional
    @Override
    public ProfileDTO readProfile(Long profileId) {
        System.out.println("getProfileWithFileByProfileId() entry");

        List<Object[]> profileAndFileAndActor = profileRepo.getProfileAndFileAndActorByProfileId(2L);

        Profile profile = (Profile) profileAndFileAndActor.get(0)[0];
        Actor actor = profile.getActor();
        System.out.println("actor: " + actor);

        ProfileDTO profileDTO = entity2Dto(profile);
        System.out.println("profileDTO: " + profileDTO);

        ActorDTO actorDTO = actorService.entity2Dto(actor);
        System.out.println("actorDTO: " + actorDTO);

        List<FileDTO> fileList = new ArrayList<>();

        profileAndFileAndActor.forEach(arr -> {
            fileList.add(fileService.entity2Dto((FileVO)arr[2]));
        });

        profileDTO.setActor(actor);
        profileDTO.setFiles(fileList);

        System.out.println("profile dto: " + profileDTO);

        return profileDTO;
    }

}
