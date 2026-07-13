package com.sanjay.footballtournamentapi.controller;

import com.sanjay.footballtournamentapi.model.Tournament;
import com.sanjay.footballtournamentapi.service.TournamentService;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public Tournament updateTournament(@PathVariable int id, @RequestBody Tournament tournament) {
        return tournamentService.updateTournament(id,tournament);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable int id) {
        boolean deleted = tournamentService.deleteTournament(id);

        if(!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
