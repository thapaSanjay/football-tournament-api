package com.sanjay.footballtournamentapi.controller;

import com.sanjay.footballtournamentapi.model.Tournament;
import com.sanjay.footballtournamentapi.service.TournamentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournament();
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable  int id) {
        return tournamentService.getTournamentById(id);
    }

}
