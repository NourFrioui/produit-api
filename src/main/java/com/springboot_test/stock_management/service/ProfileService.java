package com.springboot_test.stock_management.service;

import com.springboot_test.stock_management.exceptions.NotFoundException;
import com.springboot_test.stock_management.model.dto.ProfileDto;
import com.springboot_test.stock_management.model.entity.Person;
import com.springboot_test.stock_management.model.entity.Profile;
import com.springboot_test.stock_management.repository.PersonRepository;
import com.springboot_test.stock_management.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {
    
    @Autowired
    private final ProfileRepository profileRepository;
    private final PersonRepository personRepository;

    public List<Profile> getAllProfiles() {
        return this.profileRepository.findAll();
    }

    public Profile createProfile(final ProfileDto request) {
        final Person person = this.personRepository.findById(request.getPersonId())
                .orElseThrow(() -> new NotFoundException("Person not found with id " + request.getPersonId()));

        final Profile profile = Profile.builder()
                .bio(request.getBio())
                .profile_picture_url(request.getProfilePictureUrl())
                .person(person)
                .build();

        return this.profileRepository.save(profile);
    }

    public Profile getProfileById(final long id) {
        return this.profileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Profile not found with id " + id));
    }

    public String deleteProfile(final long id) {
        final Optional<Profile> optionalProfile = this.profileRepository.findById(id);
        if (optionalProfile.isEmpty()) {
            throw new NotFoundException("Profile Not Found");
        }
        this.profileRepository.delete(optionalProfile.get());
        return "Profile Deleted Successfully";
    }

    public Profile updateProfile(final long id, final Profile profile) {
        final Optional<Profile> optionalProfile = this.profileRepository.findById(id);
        if (optionalProfile.isEmpty()) {
            throw new NotFoundException("Profile Not Found");
        }

        final Profile updatedProfile = optionalProfile.get();

        if (profile.getBio() != null) {
            updatedProfile.setBio(profile.getBio());
        }
        if (profile.getProfile_picture_url() != null) {
            updatedProfile.setProfile_picture_url(profile.getProfile_picture_url());
        }
        if (profile.getPerson() != null) {
            updatedProfile.setPerson(profile.getPerson());
        }

        return this.profileRepository.save(updatedProfile);
    }
}
