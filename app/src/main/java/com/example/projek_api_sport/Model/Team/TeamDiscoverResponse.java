package com.example.projek_api_sport.Model.Team;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamDiscoverResponse{

	@SerializedName("teams")
	private List<TeamsDiscoverResultItem> teams;

	public void setTeams(List<TeamsDiscoverResultItem> teams){
		this.teams = teams;
	}

	public List<TeamsDiscoverResultItem> getTeams(){
		return teams;
	}

	@Override
 	public String toString(){
		return 
			"TeamDiscoverResponse{" + 
			"teams = '" + teams + '\'' + 
			"}";
		}
}