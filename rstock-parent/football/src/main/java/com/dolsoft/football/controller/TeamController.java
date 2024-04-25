package com.dolsoft.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dolsoft.football.model.Team;
import com.dolsoft.football.servise.TeamService;



@RestController
@RequestMapping(value="v1/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	
	@GetMapping("/{teamId}")
	public ResponseEntity<Team> getTeam(@PathVariable("teamId") String teamId) {
		
		Team team = teamService.getTeam(teamId);
		
		team.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeamController.class)
						.getTeam(team.getId().toString())).withSelfRel(),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeamController.class)
						.createTeam(team)).withRel("createTeam"),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeamController.class)
						.updateTeam(team)).withRel("updateTeam"),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeamController.class)
						.deleteTeam(team.getId().toString())).withRel("deleteTeam"));
		
		return ResponseEntity.ok(team);
	}
	
	
	@PutMapping
	public ResponseEntity<String> updateTeam(@RequestBody Team team) {
		return ResponseEntity.ok(teamService.updateTeam(team));
	}
	
	
	@PostMapping
	public ResponseEntity<String> createTeam(@RequestBody Team team) {
		return ResponseEntity.ok(teamService.createTeam(team));
	}
	
	
	@DeleteMapping(value="/{teamId}")
	public ResponseEntity<String> deleteTeam(@PathVariable("teamId") String teamId) {
		return ResponseEntity.ok(teamService.deleteTeam(teamId));
	}
}

	