# Football Tournament Management API

This is the Spring Boot backend for the Football Tournament Management System.

## Features

- Create and manage tournaments
- Create groups inside tournaments
- Add teams to groups
- Create football matches
- Update match scores
- Automatically update standings
- Sort standings by points, goal difference, and goals scored
- Show top 2 qualified teams from a group
- Validation for invalid matches and scores
- Clean API response using DTOs
- CORS configured for React frontend

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- REST API
- Maven

## Main API Endpoints

### Tournaments

```bash
GET /tournaments
POST /tournaments
GET /tournaments/{id}
PUT /tournaments/{id}
DELETE /tournaments/{id}

GET /groups
POST /groups/tournament/{tournamentId}
GET /groups/tournament/{tournamentId}
GET /groups/{id}
PUT /groups/{id}
DELETE /groups/{id}

GET /teams
POST /teams/group/{groupId}
GET /teams/{id}
GET /teams/group/{groupId}
PUT /teams/{id}
DELETE /teams/{id}

GET /matches
POST /matches/home/{homeTeamId}/away/{awayTeamId}
GET /matches/{id}
GET /matches/team/{teamId}
PUT /matches/{id}/score
DELETE /matches/{id}

GET /standings/group/{groupId}
GET /standings/group/{groupId}/top-teams