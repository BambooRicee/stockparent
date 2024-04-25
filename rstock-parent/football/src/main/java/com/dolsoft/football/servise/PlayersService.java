package com.dolsoft.football.servise;

import org.springframework.stereotype.Service;

import com.dolsoft.football.model.Players;
@Service
public class PlayersService {
	public Players getPlayers(String playersId) {
		
		Players players = new Players();
		players.setId(Long.parseLong(playersId));
		players.setName("Сальников Кирилл Иванович");
		players.setPosition("Вратарь");
		players.setDateOfBirth("21.01.2000");
		players.setHeight("182");
		players.setHeight("72");
		return players;
		}
	public String createPlayers(Players players){
		String responseMessage = null;
		if(players != null) {
			responseMessage = String.format("This is the post and the object is: %s",
					players.toString());
			}
		return responseMessage;
		}
	
	public String updatePlayers(Players players){
		String responseMessage = null;
		if (players != null) {
			responseMessage = String.format("This is the put and the object is: %s", 
					players.toString());
			}
		return responseMessage;
		}
	public String deletePlayers(String playersId){
		String responseMessage = null;
		responseMessage = String.format("Deleting  with id %s for the football  %s",playersId);
		return responseMessage;
		}
}
