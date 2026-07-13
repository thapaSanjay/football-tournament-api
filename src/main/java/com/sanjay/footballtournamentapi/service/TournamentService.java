package com.sanjay.footballtournamentapi.service;

import com.sanjay.footballtournamentapi.exception.TournamentNotFoundException;
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

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Tournament getTournamentById(int id) {
        return tournamentRepository.findById(id).orElseThrow(()->new TournamentNotFoundException(id));
    }

    public Tournament updateTournament(int id, Tournament tournament) {

        Tournament ExistingTournament = tournamentRepository.findById(id).orElseThrow(()->new TournamentNotFoundException(id));

        ExistingTournament.setName(tournament.getName());
        ExistingTournament.setYear(tournament.getYear());
        ExistingTournament.setHostCountry(tournament.getHostCountry());
        ExistingTournament.setStatus(tournament.getStatus());

        return  tournamentRepository.save(ExistingTournament);

    }

    public void deleteTournament(int id) {
        if(!tournamentRepository.existsById(id)) {
           throw new TournamentNotFoundException(id);
        }

        tournamentRepository.deleteById(id);

    }


}
