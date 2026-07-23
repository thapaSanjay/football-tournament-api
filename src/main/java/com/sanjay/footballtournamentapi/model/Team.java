package com.sanjay.footballtournamentapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Team name is required")
    private String name;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Coach name is required")
    private String coachName;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private TournamentGroup group;

    public Team() {
    }

    public Team(String name, String country, String coachName, TournamentGroup group) {
        this.name = name;
        this.country = country;
        this.coachName = coachName;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCoachName() {
        return coachName;
    }

    public TournamentGroup getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public void setGroup(TournamentGroup group) {
        this.group = group;
    }
}
