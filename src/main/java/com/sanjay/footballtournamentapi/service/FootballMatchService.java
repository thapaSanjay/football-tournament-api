package com.sanjay.footballtournamentapi.service;

import com.sanjay.footballtournamentapi.exception.FootballMatchNotFoundException;
import com.sanjay.footballtournamentapi.exception.TeamNotFoundException;
import com.sanjay.footballtournamentapi.model.FootballMatch;
import com.sanjay.footballtournamentapi.model.Team;
import com.sanjay.footballtournamentapi.repository.FootballMatchRepository;
import com.sanjay.footballtournamentapi.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballMatchService {

    private final FootballMatchRepository footballMatchRepository;
    private final TeamRepository teamRepository;

    public FootballMatchService(
            FootballMatchRepository footballMatchRepository,
            TeamRepository teamRepository
    ) {
        this.footballMatchRepository = footballMatchRepository;
        this.teamRepository = teamRepository;
    }

    public FootballMatch createMatch(
            int homeTeamId,
            int awayTeamId,
            FootballMatch footballMatch
    ) {
        Team homeTeam = teamRepository.findById(homeTeamId)
                .orElseThrow(() -> new TeamNotFoundException(homeTeamId));

        Team awayTeam = teamRepository.findById(awayTeamId)
                .orElseThrow(() -> new TeamNotFoundException(awayTeamId));

        if (homeTeamId == awayTeamId) {
            throw new IllegalArgumentException("Home team and away team cannot be same");
        }

        footballMatch.setHomeTeam(homeTeam);
        footballMatch.setAwayTeam(awayTeam);

        return footballMatchRepository.save(footballMatch);
    }

    public List<FootballMatch> getAllMatches() {
        return footballMatchRepository.findAll();
    }

    public FootballMatch getMatchById(int id) {
        return footballMatchRepository.findById(id)
                .orElseThrow(() -> new FootballMatchNotFoundException(id));
    }

    public List<FootballMatch> getMatchesByTeamId(int teamId) {
        return footballMatchRepository.findByHomeTeamIdOrAwayTeamId(teamId, teamId);
    }

    public FootballMatch updateScore(int id, FootballMatch footballMatch) {
        FootballMatch existingMatch = footballMatchRepository.findById(id)
                .orElseThrow(() -> new FootballMatchNotFoundException(id));

        existingMatch.setHomeScore(footballMatch.getHomeScore());
        existingMatch.setAwayScore(footballMatch.getAwayScore());
        existingMatch.setStatus("COMPLETED");

        return footballMatchRepository.save(existingMatch);
    }

    public void deleteMatch(int id) {
        if (!footballMatchRepository.existsById(id)) {
            throw new FootballMatchNotFoundException(id);
        }

        footballMatchRepository.deleteById(id);
    }
}
