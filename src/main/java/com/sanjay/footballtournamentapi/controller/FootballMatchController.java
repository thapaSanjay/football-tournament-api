package com.sanjay.footballtournamentapi.controller;

import com.sanjay.footballtournamentapi.model.FootballMatch;
import com.sanjay.footballtournamentapi.service.FootballMatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class FootballMatchController {

    private final FootballMatchService footballMatchService;

    public FootballMatchController(FootballMatchService footballMatchService) {
        this.footballMatchService = footballMatchService;
    }

    @PostMapping("/home/{homeTeamId}/away/{awayTeamId}")
    public FootballMatch createMatch(
            @PathVariable int homeTeamId,
            @PathVariable int awayTeamId,
            @RequestBody FootballMatch footballMatch
    ) {
        return footballMatchService.createMatch(homeTeamId, awayTeamId, footballMatch);
    }

    @GetMapping
    public List<FootballMatch> getAllMatches() {
        return footballMatchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public FootballMatch getMatchById(@PathVariable int id) {
        return footballMatchService.getMatchById(id);
    }

    @GetMapping("/team/{teamId}")
    public List<FootballMatch> getMatchesByTeamId(@PathVariable int teamId) {
        return footballMatchService.getMatchesByTeamId(teamId);
    }

    @PutMapping("/{id}/score")
    public FootballMatch updateScore(
            @PathVariable int id,
            @RequestBody FootballMatch footballMatch
    ) {
        return footballMatchService.updateScore(id, footballMatch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable int id) {
        footballMatchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
