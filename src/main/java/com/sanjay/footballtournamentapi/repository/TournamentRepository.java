package com.sanjay.footballtournamentapi.repository;

import com.sanjay.footballtournamentapi.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament,Integer> {
}
