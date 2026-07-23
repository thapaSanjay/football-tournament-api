package com.sanjay.footballtournamentapi.service;

import com.sanjay.footballtournamentapi.exception.TournamentGroupNotFoundException;
import com.sanjay.footballtournamentapi.exception.TournamentNotFoundException;
import com.sanjay.footballtournamentapi.model.Tournament;
import com.sanjay.footballtournamentapi.model.TournamentGroup;
import com.sanjay.footballtournamentapi.repository.TournamentGroupRepository;
import com.sanjay.footballtournamentapi.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentGroupService {
    private final TournamentGroupRepository tournamentGroupRepository;
    private  final TournamentRepository tournamentRepository;

    public TournamentGroupService(
            TournamentGroupRepository tournamentGroupRepository,
            TournamentRepository tournamentRepository
    ) {
        this.tournamentGroupRepository = tournamentGroupRepository;
        this.tournamentRepository = tournamentRepository;
    }

    public TournamentGroup addGroupToTournament(int tournamentId, TournamentGroup tournamentGroup) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(()->new TournamentNotFoundException(tournamentId));

        tournamentGroup.setTournament(tournament);

        return tournamentGroupRepository.save(tournamentGroup);
    }

    public List<TournamentGroup> getAllGroups() {
        return tournamentGroupRepository.findAll();
    }

    public List<TournamentGroup> getGroupsByTournamentId(int tournamentId) {
        return tournamentGroupRepository.findByTournamentId(tournamentId);
    }

    public TournamentGroup getGroupById(int id) {
        return tournamentGroupRepository.findById(id)
                .orElseThrow(() -> new TournamentGroupNotFoundException(id));
    }

    public TournamentGroup updateGroup(int id, TournamentGroup tournamentGroup) {
        TournamentGroup existingGroup = tournamentGroupRepository.findById(id)
                .orElseThrow(() -> new TournamentGroupNotFoundException(id));

        existingGroup.setName(tournamentGroup.getName());

        return tournamentGroupRepository.save(existingGroup);
    }

    public void deleteGroup(int id) {
        if (!tournamentGroupRepository.existsById(id)) {
            throw new TournamentGroupNotFoundException(id);
        }

        tournamentGroupRepository.deleteById(id);
    }
}
