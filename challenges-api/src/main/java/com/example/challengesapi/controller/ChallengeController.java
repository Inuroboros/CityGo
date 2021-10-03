package com.example.challengesapi.controller;

import com.example.challengesapi.model.Challenge;
import com.example.challengesapi.model.Log;
import com.example.challengesapi.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    @Autowired
    private ChallengeService service;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/register")
    public void createChallenge() { //@RequestBody Challenge challenge
        Challenge challenge = new Challenge(new Long(1), "Riddle for eureka???", "Answer!!!!", new Long(1), java.util.Calendar.getInstance().getTime(), java.util.Calendar.getInstance().getTime());
        service.createChallenge(challenge);
        Log log = new Log(1,"ChallengeService", "POST", challenge.toString());

        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://logging-api/logs", request, Log.class);

        System.out.println(log.toString());
    }

    @PutMapping("/update")
    public void updateChallenge(@RequestBody Challenge challenge) {
        service.updateChallenge(challenge);
        Log log = new Log(1,"ChallengeService", "UPDATE", challenge.toString());

        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://logging-api/logs", request, Log.class);

        System.out.println(log.toString());
    }

    @GetMapping("")
    public List<Challenge> getAllChallenges() {
        return service.getChallengeList();
    }

    @DeleteMapping("/delete")
    public void deleteChallenge(@RequestBody Challenge challenge) {
        service.deleteChallenge(challenge);
        Log log = new Log(1,"ChallengeService", "DELETE", challenge.toString());

        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://logging-api/logs", request, Log.class);

        System.out.println(log.toString());
    }
}
