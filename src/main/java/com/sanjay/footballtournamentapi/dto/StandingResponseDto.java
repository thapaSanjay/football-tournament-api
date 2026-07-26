package com.sanjay.footballtournamentapi.dto;

public class StandingResponseDto {

    private int teamId;
    private String teamName;
    private String groupName;

    private int played;
    private int won;
    private int drawn;
    private int lost;

    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;

    private int points;

    public StandingResponseDto(
            int teamId,
            String teamName,
            String groupName,
            int played,
            int won,
            int drawn,
            int lost,
            int goalsFor,
            int goalsAgainst,
            int goalDifference,
            int points
    ) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.groupName = groupName;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getGroupName() {
        return groupName;
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
}