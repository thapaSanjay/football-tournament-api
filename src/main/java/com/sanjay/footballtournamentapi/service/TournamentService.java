package com.sanjay.footballtournamentapi.service;

import com.sanjay.footballtournamentapi.model.Tournament;
import com.sanjay.footballtournamentapi.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public List<Tournament> getAllTournament() {
        return tournamentRepository.findAll();
    }


}
