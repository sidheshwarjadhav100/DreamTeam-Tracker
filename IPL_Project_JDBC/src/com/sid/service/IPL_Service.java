package com.sid.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sid.dao.IPL_Dao;
import com.sid.entity.Player;

public class IPL_Service {
	IPL_Dao dao = null;
	List<Player> allplayerdbb = null;

	// update any existing player record
	public String updatePlayerInfo(String oldname, String newname, int newruns, int newwickets, String newtname) {
		dao = new IPL_Dao();
		String result = dao.updatePlayerInfo(oldname, newname, newruns, newwickets, newtname);
		return result;
	}

	// insert new player into a database
	public String addPlayerInfo(int jerseyno, String pname, int runs, int wickets, String team) {
		String resutl = null;
		dao = new IPL_Dao();

		List<Player> alreadypresentdata = dao.getAllPlayerData();
		int count = 0;
		dao = new IPL_Dao();

		for (Player player : alreadypresentdata) {

			if (player.getName().equalsIgnoreCase(pname)) {
				count++;
			}

		}
		if (count == 0) {
			resutl = dao.addPlayerData(jerseyno, pname, runs, wickets, team);

		} else {

			resutl = "Player alredy present";

		}

		return resutl;
	}

	// delete player form the database
	public String deletePlayerInfo(String pname) {
		dao = new IPL_Dao();
		String deleteresult = dao.deletePlayerData(pname);
		return deleteresult;
	}

	// view all player of a specific team
	public List<String> getAllPlayerService(String team) {
		dao = new IPL_Dao();
		allplayerdbb = dao.getAllPlayerData();
		List<String> getallteamplayer = new ArrayList<String>();
		for (Player pl : allplayerdbb) {

			if (pl.getTeam().equalsIgnoreCase(team)) {

				getallteamplayer.add(pl.getName());

			}
			// System.out.println("ops success");
		}

		return getallteamplayer;
	}

	// view all teams in the database
	public Set<String> getAllTeams() {
		dao = new IPL_Dao();
		allplayerdbb = dao.getAllPlayerData();

		Set<String> allteam = new LinkedHashSet<String>();

		String teams = null;
		for (Player player : allplayerdbb) {

			teams = player.getTeam();
			allteam.add(teams.toUpperCase());

		}

		return allteam;
	}

	// get detailed information on a specific player
	public List<Player> getPlayerAllInfo(String playername) {
		dao = new IPL_Dao();
		allplayerdbb = dao.getAllPlayerData();
		List<Player> playerallinfo = new ArrayList<Player>();

		for (Player pl : allplayerdbb) {

			if (pl.getName().equalsIgnoreCase(playername)) {
				playerallinfo.add(pl);
			}
		}

		return playerallinfo;
	}

}
