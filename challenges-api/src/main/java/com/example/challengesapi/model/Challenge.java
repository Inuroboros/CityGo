package com.example.challengesapi.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "challenges")
public class Challenge {
    private @Id @GeneratedValue Long id;
    private String riddle;
    private String answer;
    private Long sponsorId;
    private Date startDate;
    private Date endDate;
}
