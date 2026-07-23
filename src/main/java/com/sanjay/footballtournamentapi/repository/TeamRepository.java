package com.sanjay.footballtournamentapi.repository;

import com.sanjay.footballtournamentapi.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    List<Team> findByGroupId(int groupId);
}
