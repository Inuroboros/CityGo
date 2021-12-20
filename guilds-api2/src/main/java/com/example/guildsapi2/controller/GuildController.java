package com.example.guildsapi2.controller;

import com.example.guildsapi2.model.Guild;
import com.example.guildsapi2.service.GuildService;
import com.example.guildsapi2.model.Guild;
import com.example.guildsapi2.service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuildController {

    @Autowired
    private GuildService guildService;

    @PostMapping("/guild")
    public void CreatePlace(@RequestBody Guild guild) {
        guildService.CreateGuild(guild);
    }

    @GetMapping("/guilds")
    public List<Guild> GetPlaces() {
        return guildService.GetGuilds();
    }
}