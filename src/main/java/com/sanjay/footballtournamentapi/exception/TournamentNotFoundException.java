package com.sanjay.footballtournamentapi.exception;

public class TournamentNotFoundException extends RuntimeException {
    public TournamentNotFoundException(int id) {
        super("Tournament not found with id: " + id);
    }
}
