package com.sid.controller;

import java.util.List;
import java.util.Set;

import com.sid.entity.Player;
import com.sid.service.IPL_Service;

public class IPLController {
	IPL_Service service = null;

	// insert new player into a database
	public String addPlayer(int jerseyno, String pname, int runs, int wickets, String team) {

		service = new IPL_Service();
		String result = service.addPlayerInfo(jerseyno, pname, runs, wickets, team);

		return result;
	}

	// delete player form the database
	public String deletePlayer(String pname) {
		service = new IPL_Service();
		String res = service.deletePlayerInfo(pname);

		return res;
	}

	// update existing player information
	public String updatePlayer(String oldname, String newname, int newruns, int newwickets, String newtname) {
		service = new IPL_Service();
		String res = service.updatePlayerInfo(oldname, newname, newruns, newwickets, newtname);

		return res;
	}

	// view all player of a specific team
	public List<String> getAllPlayerController(String team) {

		service = new IPL_Service();
		List<String> allp = service.getAllPlayerService(team);
		return allp;
	}

	// view all teams in the database
	public Set<String> getAllTeam() {
		service = new IPL_Service();
		Set<String> allteams = service.getAllTeams();

		return allteams;
	}

	// get detailed information on a specific player
	public List<Player> getPlayerAllInfo(String playername) {
		service = new IPL_Service();
		List<Player> pallinfo = service.getPlayerAllInfo(playername);
		return pallinfo;
	}

}
