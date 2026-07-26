package com.sanjay.footballtournamentapi.controller;

import com.sanjay.footballtournamentapi.model.Standing;
import com.sanjay.footballtournamentapi.service.StandingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/standings")
public class StandingController {
    private final StandingService standingService;

    public StandingController(StandingService standingService) {
        this.standingService = standingService;
    }

    @GetMapping("/group/{groupId}")
    public List<Standing> getStandingsByGroupId(@PathVariable int groupId) {
        return standingService.getStandingsByGroupId(groupId);
    }

    @GetMapping("/group/{groupId}/top-teams")
    public List<Standing> getTopTwoTeamsByGroupId(@PathVariable int groupId) {
        return standingService.getTopTwoTeamsByGroupId(groupId);
    }
}
