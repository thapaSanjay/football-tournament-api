package com.sanjay.footballtournamentapi.exception;

public class TournamentGroupNotFoundException extends RuntimeException {

    public TournamentGroupNotFoundException(int id) {
        super("Group not found with id: " + id);
    }
}