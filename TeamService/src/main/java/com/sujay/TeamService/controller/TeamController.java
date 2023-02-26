package com.sujay.TeamService.controller;

import com.sujay.TeamService.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.sujay.TeamService.model.Team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to unsecured page";
    }
    @GetMapping("/team")
    public List<Team> getTeam() {
        return teamService.getTeam();
    }

    @PostMapping("/team")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Map<String, Integer> addInTeam(@RequestBody Team team) {
        int totalTeamSize = teamService.addInTeam(team);
        Map<String, Integer> teamSize = new HashMap<>();
        teamSize.put("TotalTeamSize", totalTeamSize);
        return teamSize;

    }
}
