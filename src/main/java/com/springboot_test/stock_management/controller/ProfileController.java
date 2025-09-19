package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.model.dto.ProfileDto;
import com.springboot_test.stock_management.model.entity.Profile;
import com.springboot_test.stock_management.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
@RequiredArgsConstructor
public class ProfileController {
    
    @Autowired
    private final ProfileService profileService;

    @GetMapping("/hello")
    public static String hello() {
        return "Hello from ProfileController!";
    }

    @GetMapping("/all")
    public List<Profile> getAllProfiles() {
        return this.profileService.getAllProfiles();
    }

    @PostMapping
    public Profile createProfile(@RequestBody final ProfileDto request) {
        return this.profileService.createProfile(request);
    }

    @GetMapping("{id}")
    public Profile getProfileById(@PathVariable final long id) {
        return this.profileService.getProfileById(id);
    }

    @DeleteMapping("{id}")
    public String deleteProfile(@PathVariable final long id) {
        return this.profileService.deleteProfile(id);
    }

    @PatchMapping("{id}")
    public Profile updateProfile(@PathVariable final long id, @RequestBody final Profile profile) {
        return this.profileService.updateProfile(id, profile);
    }
}
