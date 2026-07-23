package com.sanjay.footballtournamentapi.controller;

import com.sanjay.footballtournamentapi.model.Team;
import com.sanjay.footballtournamentapi.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/group/{groupId}")
    public Team addTeamToGroup(
            @PathVariable int groupId,
            @Valid @RequestBody Team team
    ) {
        return teamService.addTeamToGroup(groupId, team);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable int id) {
        return teamService.getTeamById(id);
    }

    @GetMapping("/group/{groupId}")
    public List<Team> getTeamsByGroupId(@PathVariable int groupId) {
        return teamService.getTeamsByGroupId(groupId);
    }

    @PutMapping("/{id}")
    public Team updateTeam(
            @PathVariable int id,
            @Valid @RequestBody Team team
    ) {
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
