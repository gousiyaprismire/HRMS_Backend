package com.hrms.service.SelfService;


import com.hrms.model.SelfService.Profile;
import com.hrms.repository.Selfservice.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile getProfile(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile updateProfile(Long id, Profile profileData) {
        Optional<Profile> existingProfile = profileRepository.findById(id);
        if (existingProfile.isPresent()) {
            Profile profile = existingProfile.get();
            profile.setName(profileData.getName());
            profile.setEmail(profileData.getEmail());
            profile.setPhone(profileData.getPhone());
            profile.setDepartment(profileData.getDepartment());
            return profileRepository.save(profile);
        }
        return null;
    }
}

