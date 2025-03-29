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
        return profileRepository.findByEmployeeId(employeeId).orElse(null);
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, Profile updatedProfile) {
        Optional<Profile> existingProfile = profileRepository.findById(id);
        if (existingProfile.isPresent()) {
            Profile profile = existingProfile.get();
            profile.setName(updatedProfile.getName());
            profile.setEmail(updatedProfile.getEmail());
            profile.setPhone(updatedProfile.getPhone());
            profile.setDateOfBirth(updatedProfile.getDateOfBirth());
            profile.setAddress(updatedProfile.getAddress());
            profile.setGender(updatedProfile.getGender());
            profile.setDepartment(updatedProfile.getDepartment());
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

