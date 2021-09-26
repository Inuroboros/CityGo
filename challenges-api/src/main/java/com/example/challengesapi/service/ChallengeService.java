package com.example.challengesapi.service;

import com.example.challengesapi.dao.ChallengeDAO;
import com.example.challengesapi.model.Challenge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {
    private ChallengeDAO challengeDAO;

    public void createChallenge(Challenge challenge) {
        challengeDAO.save(challenge);
    }

    public List<Challenge> getChallengeList() {
        return challengeDAO.findAll();
    }

    public void deleteChallenge(Challenge challenge) {
        challengeDAO.delete(challenge);
    }

    public void updateChallenge(Challenge challenge) {
        Challenge originalChallenge = challengeDAO.getById(challenge.getId());
        if (originalChallenge != null) {
            challengeDAO.save(challenge);
        }
    }

}
