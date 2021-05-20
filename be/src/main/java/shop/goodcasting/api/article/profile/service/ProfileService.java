package shop.goodcasting.api.article.profile.service;

import shop.goodcasting.api.article.profile.domain.Profile;
import shop.goodcasting.api.article.profile.domain.ProfileDTO;

public interface ProfileService {
    Long register(ProfileDTO profileDTO);
    ProfileDTO readProfile(Long profileId);

    default Profile dto2Entity(ProfileDTO dto) {
        return Profile.builder()
                .profileId(dto.getProfileId())
                .career(dto.getCareer())
                .contents(dto.getContents())
                .privacy(dto.isPrivacy())
                .resemble(dto.getResemble())
                .confidence(dto.getConfidence())
                .actor(dto.getActor())
                .build();
    }

    default ProfileDTO entity2Dto(Profile entity) {
        return ProfileDTO.builder()
                .profileId(entity.getProfileId())
                .career(entity.getCareer())
                .contents(entity.getContents())
                .privacy(entity.isPrivacy())
                .resemble(entity.getResemble())
                .confidence(entity.getConfidence())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .actor(entity.getActor())
                .build();
    }

}
