package com.example.challengesapi.controller;

import com.example.challengesapi.model.Challenge;
import com.example.challengesapi.service.ChallengeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService service;

    @PostMapping("/register")
    public void createChallenge(@RequestBody Challenge challenge) {
        service.createChallenge(challenge);
    }

    @PutMapping("/update")
    public void updateChallenge(@RequestBody Challenge challenge) {
        service.updateChallenge(challenge);
    }

    @GetMapping("")
    public List<Challenge> getAllChallenges() {
        return service.getChallengeList();
    }

    @DeleteMapping("/delete")
    public void deleteChallenge(@RequestBody Challenge challenge) {
        service.deleteChallenge(challenge);
    }
}
