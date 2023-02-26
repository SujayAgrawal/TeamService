package com.sujay.TeamService.service;

import com.sujay.TeamService.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private static List<Team> team = new ArrayList<>();
    static {
        team.add(new Team("Kamlesh",14));
        team.add(new Team("Sujay",7));
        team.add(new Team("Shivani",5));
        team.add(new Team("Rishabh",5));
    }
    public List<Team> getTeam() {
        return team;
    }

    public int addInTeam(Team teamMember) {
        team.add(teamMember);
        return team.size();
    }
}
