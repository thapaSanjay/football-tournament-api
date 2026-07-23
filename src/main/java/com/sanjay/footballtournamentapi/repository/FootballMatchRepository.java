package com.sanjay.footballtournamentapi.repository;

import com.sanjay.footballtournamentapi.model.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FootballMatchRepository extends JpaRepository<FootballMatch, Integer> {

    List<FootballMatch> findByHomeTeamIdOrAwayTeamId(int homeTeamId, int awayTeamId);
}
