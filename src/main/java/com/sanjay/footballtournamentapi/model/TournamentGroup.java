package com.sanjay.footballtournamentapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class TournamentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Group name is required")
    private String name;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public TournamentGroup() {
    }

    public TournamentGroup(String name, Tournament tournament) {
        this.name = name;
        this.tournament = tournament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
