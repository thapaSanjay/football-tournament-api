package com.sanjay.footballtournamentapi.exception;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(int id) {
        super("Team not found with id: " + id);
    }
}