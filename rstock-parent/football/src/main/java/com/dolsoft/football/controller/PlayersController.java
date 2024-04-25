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

import com.dolsoft.football.model.Players;
import com.dolsoft.football.servise.PlayersService;



@RestController
@RequestMapping(value="v1/players")
public class PlayersController {

	@Autowired
	private PlayersService playersService;

	
	@GetMapping("/{playersId}")
	public ResponseEntity<Players> getPlayers(@PathVariable("playersId") String playersId) {
		
		Players players = playersService.getPlayers(playersId);
		
		players.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlayersController.class)
						.getPlayers(players.getId().toString())).withSelfRel(),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlayersController.class)
						.createPlayers(players)).withRel("createPlayers"),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlayersController.class)
						.updatePlayers(players)).withRel("updatePlayers"),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlayersController.class)
						.deletePlayers(players.getId().toString())).withRel("deletePlayers"));
		
		return ResponseEntity.ok(players);
	}
	
	
	@PutMapping
	public ResponseEntity<String> updatePlayers(@RequestBody Players players) {
		return ResponseEntity.ok(playersService.updatePlayers(players));
	}
	
	
	@PostMapping
	public ResponseEntity<String> createPlayers(@RequestBody Players players) {
		return ResponseEntity.ok(playersService.createPlayers(players));
	}
	
	
	@DeleteMapping(value="/{playersId}")
	public ResponseEntity<String> deletePlayers(@PathVariable("playersId") String playersId) {
		return ResponseEntity.ok(playersService.deletePlayers(playersId));
	}
}

	