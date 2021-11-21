package com.example.challengesapi.service;

import com.example.challengesapi.dao.ChallengeDAO;
import com.example.challengesapi.model.Challenge;
import com.example.challengesapi.model.Company;
import com.example.challengesapi.model.DTO.ChallengeCompanyDTO;
import com.example.challengesapi.model.Log;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    @Autowired
    private ChallengeDAO challengeDAO;

    @Autowired
    private RestTemplate restTemplate;


    public void createChallenge(Challenge challenge) {
        //При создании объекта мы получаем айди спонсора, и мы перед тем как создать такой челлендж
        //должны удостовериться что спонсор по такому айдишнику существует, для этого мы попытаемя получить
        //с микросервиса объект спонсора для проверки.

        Company cp = restTemplate.getForObject("http://company-crud-api/company/" + challenge.getSponsorId(), Company.class);
        //тут достали объект спонсора

        if(cp != null) {
            challengeDAO.save(challenge);

            Log log = new Log(1, "ChallengeService", "POST", challenge.toString());

            HttpEntity<Log> request = new HttpEntity<>(log);
            restTemplate.postForObject("http://logging-api/logs", request, Log.class);

            System.out.println(log.toString());
        } else {
            System.out.println("Company not found! Challenge not created!");
        }
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

//
//    @HystrixCommand(
//            fallbackMethod = "getChallengeDtoByIdFallback",
//            threadPoolKey = "getChallengeDtoById",
//            threadPoolProperties = {
//                    @HystrixProperty(name = "core$size", value="100"),
//                    @HystrixProperty(name = "maxQueueSize", value = "50")
//            }
//    )
    public ChallengeCompanyDTO getChallengeDtoById(Long id) {
        Optional<Challenge> challenge = challengeDAO.findById(id);

        System.out.println("+++++++++++++++++++++" + challenge.toString());
        Company cp = restTemplate.getForObject("http://company-crud-api/company/" + Long.toString(challenge.get().getSponsorId()), Company.class);
        System.out.println("==================" + cp.toString());

        ChallengeCompanyDTO challengeCompanyDTO = new ChallengeCompanyDTO(challenge, cp);
        //System.out.println(challengeCompanyDTO.toString());

        return challengeCompanyDTO;
    }

    public ChallengeCompanyDTO getChallengeDtoByIdFallback(Long id) {
        Optional<Challenge> challenge = challengeDAO.findById(id);
        Company cp = new Company(0, "Not found", "0000", "empty address");

        ChallengeCompanyDTO challengeCompanyDTO = new ChallengeCompanyDTO(challenge, cp);
        return challengeCompanyDTO;
    }

    public Optional<Challenge> getChallenge(Long id) {
        //return challengeDAO.getById(id);
        return challengeDAO.findById(id);
    }
}
