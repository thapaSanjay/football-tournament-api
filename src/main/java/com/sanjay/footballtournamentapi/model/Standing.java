package com.sanjay.footballtournamentapi.model;

import jakarta.persistence.*;

@Entity
public class Standing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private TournamentGroup group;

    private int played;
    private int won;
    private int drawn;
    private int lost;

    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;

    private int points;

    public Standing() {
    }

    public Standing(Team team, TournamentGroup group) {
        this.team = team;
        this.group = group;
        this.played = 0;
        this.won = 0;
        this.drawn = 0;
        this.lost = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.goalDifference = 0;
        this.points = 0;
    }

    public int getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public TournamentGroup getGroup() {
        return group;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getDrawn() {
        return drawn;
    }

    public int getLost() {
        return lost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public int getPoints() {
        return points;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setGroup(TournamentGroup group) {
        this.group = group;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public void setDrawn(int drawn) {
        this.drawn = drawn;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
