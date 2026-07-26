package com.sanjay.footballtournamentapi.service;

import com.sanjay.footballtournamentapi.model.FootballMatch;
import com.sanjay.footballtournamentapi.model.Standing;
import com.sanjay.footballtournamentapi.model.Team;
import com.sanjay.footballtournamentapi.model.TournamentGroup;
import com.sanjay.footballtournamentapi.repository.StandingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandingService {
    private final StandingRepository standingRepository;

    public StandingService(StandingRepository standingRepository) {
        this.standingRepository = standingRepository;
    }

    public void updateStandingsForMatch(FootballMatch match) {
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();

        int homeScore = match.getHomeScore();
        int awayScore = match.getAwayScore();

        updateTeamStanding(homeTeam, homeTeam.getGroup(), homeScore,awayScore);
        updateTeamStanding(awayTeam,awayTeam.getGroup(),awayScore,homeScore);
    }

    private void updateTeamStanding(
            Team team,
            TournamentGroup group,
            int goalsFor,
            int goalsAgainst
    ) {
        Standing standing = standingRepository.findByTeamId(team.getId())
                .orElse(new Standing(team, group));

        standing.setPlayed(standing.getPlayed() + 1);
        standing.setGoalsFor(standing.getGoalsFor() + goalsFor);
        standing.setGoalsAgainst(standing.getGoalsAgainst() + goalsAgainst);
        standing.setGoalDifference(
                standing.getGoalsFor() - standing.getGoalsAgainst()
        );

        if (goalsFor > goalsAgainst) {
            standing.setWon(standing.getWon() + 1);
            standing.setPoints(standing.getPoints() + 3);
        } else if (goalsFor == goalsAgainst) {
            standing.setDrawn(standing.getDrawn() + 1);
            standing.setPoints(standing.getPoints() + 1);
        } else {
            standing.setLost(standing.getLost() + 1);
        }

        standingRepository.save(standing);
    }

    public List<Standing> getStandingsByGroupId(int groupId) {
        return standingRepository.findByGroupIdOrderByPointsDescGoalDifferenceDescGoalsForDesc(groupId);
    }

    public List<Standing> getTopTwoTeamsByGroupId(int groupId) {
        return standingRepository
                .findByGroupIdOrderByPointsDescGoalDifferenceDescGoalsForDesc(groupId)
                .stream()
                .limit(2)
                .toList();
    }
}
