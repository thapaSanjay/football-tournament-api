package com.sanjay.footballtournamentapi.exception;

public class FootballMatchNotFoundException extends RuntimeException {

    public FootballMatchNotFoundException(int id) {
        super("Match not found with id: " + id);
    }
}
