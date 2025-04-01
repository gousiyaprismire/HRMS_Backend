package com.hrms.service.SelfService;


import com.hrms.model.SelfService.Profile;

import com.hrms.repository.Selfservice.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile getProfileByEmployeeId(Long employeeId) {
        return profileRepository.findByEmployeeId(employeeId);
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, Profile profileDetails) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();
            profile.setName(profileDetails.getName());
            profile.setEmail(profileDetails.getEmail());
            profile.setPhone(profileDetails.getPhone());
            profile.setAddress(profileDetails.getAddress());
            profile.setDateOfBirth(profileDetails.getDateOfBirth());
            profile.setGender(profileDetails.getGender());
            profile.setDepartment(profileDetails.getDepartment());
            return profileRepository.save(profile);
        }
        return null;
    }

    public boolean deleteProfile(Long id) {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
