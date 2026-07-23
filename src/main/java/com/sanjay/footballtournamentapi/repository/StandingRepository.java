package com.sanjay.footballtournamentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StandingRepository extends JpaRepository<Standing,Integer> {
    Optional<Standing> findByTeamId(int teamId);
    List<Standing> findByGroupIdOrderByPointsDescGoalDifferenceDescGoalsForDesc(int groupId);
}
