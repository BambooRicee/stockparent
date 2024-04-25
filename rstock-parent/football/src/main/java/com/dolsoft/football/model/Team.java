package com.dolsoft.football.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class Team extends RepresentationModel<Team> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String teamId;
	private String nameTeam;
	private String trainer;
	private String country;
	private String foundationyear;
	}