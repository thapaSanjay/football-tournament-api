package com.sanjay.footballtournamentapi.service;

import com.sanjay.footballtournamentapi.exception.TeamNotFoundException;
import com.sanjay.footballtournamentapi.exception.TournamentGroupNotFoundException;
import com.sanjay.footballtournamentapi.model.Team;
import com.sanjay.footballtournamentapi.model.TournamentGroup;
import com.sanjay.footballtournamentapi.repository.TeamRepository;
import com.sanjay.footballtournamentapi.repository.TournamentGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TournamentGroupRepository tournamentGroupRepository;

    public TeamService(
            TeamRepository teamRepository,
            TournamentGroupRepository tournamentGroupRepository
    ) {
        this.teamRepository = teamRepository;
        this.tournamentGroupRepository = tournamentGroupRepository;
    }

    public Team addTeamToGroup(int groupId, Team team) {
        TournamentGroup group = tournamentGroupRepository.findById(groupId)
                .orElseThrow(() -> new TournamentGroupNotFoundException(groupId));

        team.setGroup(group);

        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(int id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
    }

    public List<Team> getTeamsByGroupId(int groupId) {
        return teamRepository.findByGroupId(groupId);
    }

    public Team updateTeam(int id, Team team) {
        Team existingTeam = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));

        existingTeam.setName(team.getName());
        existingTeam.setCountry(team.getCountry());
        existingTeam.setCoachName(team.getCoachName());

        return teamRepository.save(existingTeam);
    }

    public void deleteTeam(int id) {
        if (!teamRepository.existsById(id)) {
            throw new TeamNotFoundException(id);
        }

        teamRepository.deleteById(id);
    }
}
