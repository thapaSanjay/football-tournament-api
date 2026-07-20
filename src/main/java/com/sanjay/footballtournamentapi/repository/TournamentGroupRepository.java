package com.sanjay.footballtournamentapi.repository;

import com.sanjay.footballtournamentapi.model.TournamentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentGroupRepository extends JpaRepository<TournamentGroup, Integer> {
    List<TournamentGroup> findByTournamentId(int tournamentId);
}
