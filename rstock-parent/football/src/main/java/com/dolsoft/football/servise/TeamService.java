package com.dolsoft.football.servise;

import org.springframework.stereotype.Service;

import com.dolsoft.football.model.Team;
@Service
public class TeamService {
	public Team getTeam(String teamId) {
		
		Team team = new Team();
		team.setId(Long.parseLong(teamId));
		team.setNameTeam("Rice");
		team.setTrainer("Шаповал Марк Евгеньевич");
		team.setCountry("Россия");
		team.setFoundationyear("1999");

		return team;
		}
	public String createTeam(Team team){
		String responseMessage = null;
		if(team != null) {
			responseMessage = String.format("This is the post and the object is: %s",
					team.toString());
			}
		return responseMessage;
		}
	
	public String updateTeam(Team team){
		String responseMessage = null;
		if (team != null) {
			responseMessage = String.format("This is the put and the object is: %s", 
					team.toString());
			}
		return responseMessage;
		}
	public String deleteTeam(String teamId){
		String responseMessage = null;
		responseMessage = String.format("Deleting license with id %s for the football team %s", teamId);
		return responseMessage;
		}
}
