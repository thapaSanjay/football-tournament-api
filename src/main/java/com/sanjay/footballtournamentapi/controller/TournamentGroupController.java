package com.sanjay.footballtournamentapi.controller;

import com.sanjay.footballtournamentapi.model.TournamentGroup;
import com.sanjay.footballtournamentapi.service.TournamentGroupService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class TournamentGroupController {

    private final TournamentGroupService tournamentGroupService;

    public TournamentGroupController( TournamentGroupService tournamentGroupService ) {
        this.tournamentGroupService = tournamentGroupService;
    }

    @PostMapping("/tournament/{tournamentId}")
    public TournamentGroup addGroupToTournament(@PathVariable int tournamentId, @Valid @RequestBody TournamentGroup tournamentGroup) {
        return tournamentGroupService.addGroupToTournament(tournamentId, tournamentGroup);
    }

    @GetMapping
    public List<TournamentGroup> getAllGroups() {
        return tournamentGroupService.getAllGroups();
    }

    @GetMapping("/tournament/{tournamentId}")
    public List<TournamentGroup> getGroupsByTournamentId(@PathVariable int tournamentId) {
        return tournamentGroupService.getGroupsByTournamentId(tournamentId);
    }

}
