package com.sanjay.footballtournamentapi.repository;

import com.sanjay.footballtournamentapi.model.Standing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StandingRepository extends JpaRepository<Standing,Integer> {
    Optional<Standing> findByTeamId(int teamId);
    List<Standing> findByGroupIdOrderByPointsDescGoalDifferenceDescGoalsForDesc(int groupId);
}
