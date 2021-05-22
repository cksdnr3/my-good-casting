package shop.goodcasting.api.article.profile.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.goodcasting.api.article.profile.domain.ProfileDTO;
import shop.goodcasting.api.article.profile.service.ProfileServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody ProfileDTO profileDTO) {
        System.out.println("Profile DTO: " + profileDTO);

        service.register(profileDTO);

        return ResponseEntity.ok(1L);
    }

    @GetMapping("/profile-detail/{profileId}")
    public ResponseEntity<ProfileDTO> profileDetail(@PathVariable Long profileId) {
        return ResponseEntity.ok(service.readProfile(profileId));
    }

    @GetMapping("/profile-list")
    public ResponseEntity<List<ProfileDTO>> profileList() {
        return new ResponseEntity<>(service.readProfileList(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Long> update(@RequestBody ProfileDTO profileDTO) {
        service.update(profileDTO);

        return new ResponseEntity<>(1L, HttpStatus.OK);
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<Long> delete(@PathVariable Long profileId) {

        service.delete(profileId);

        return new ResponseEntity<>(1L, HttpStatus.OK);
    }
}
