package com.sid.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import com.sid.controller.IPLController;
import com.sid.entity.Player;

public class IPL_Client {
	public static void main(String[] args) {
		int count = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = null;
		IPLController controller = null;
		String menu = "MENU", insert = "1. Insert new player into a database",
				update = "2. Update existing player information", delete = "3. Delete player from the database",
				seeallplayer = "4. View all player of a specific team",
				seeallteam = "5. View all teams in the database",
				seeplayerinfo = "6. Get detailed information on a specific player" + "";

		System.out.println("Welcome to my project");
		System.out.println();

		do {
			System.out.println("===================================================");
			System.out.printf("|	  	%-34s |\n", menu);
			System.out.println("===================================================");
			System.out.printf("|%-50s|\n", insert);
			System.out.println("---------------------------------------------------");
			System.out.printf("|%-50s|\n", update);
			System.out.println("---------------------------------------------------");
			System.out.printf("|%-50s|\n", delete);
			System.out.println("---------------------------------------------------");
			System.out.printf("|%-50s|\n", seeallplayer);
			System.out.println("---------------------------------------------------");
			System.out.printf("|%-50s|\n", seeallteam);
			System.out.println("---------------------------------------------------");
			System.out.printf("|%-50s|\n", seeplayerinfo);
			System.out.println("---------------------------------------------------");

			String exit = "7.Exit";
			if (count >= 1) {
				System.out.printf("|%-30s|\n", exit);
				System.out.println("---------------------------------------------------");

			}
			System.out.println();
			count++;
			int choice = 0;
			System.out.println("Enter Choice");
			try {
				sc = new Scanner(System.in);
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				e.printStackTrace();
				break;
			}

			switch (choice) {
			// insert player info into db
			case 1: {
				int jerseyno = 0, wickets = 0;
				String pname = null, team = null;
				int runs = 0;

				try {

					System.out.println("Enter jersey number");
					jerseyno = sc.nextInt();
					System.out.println("Enter name");
					pname = bf.readLine();
					System.out.println("Enter total runs");
					runs = sc.nextInt();
					System.out.println("Enter total wickets");
					wickets = sc.nextInt();
					System.out.println("Enter team name");
					team = bf.readLine();
				} catch (Exception e) {
					e.getStackTrace();
					break;

				}
				controller = new IPLController();
				String declaration = controller.addPlayer(jerseyno, pname, runs, wickets, team);
				System.out.println(declaration);

				break;
			}

			// update player info into db
			case 2: {
				String oldname = null;
				String newname = null;
				int newwickets = 0;
				int newruns = 0;
				String newtname = null;
				try {
					sc = new Scanner(System.in);
					System.out.println("Enter old player name");
					oldname = bf.readLine();
					System.out.println("Enter updated name");
					newname = bf.readLine();
					System.out.println("enter updated total runs");
					newruns = sc.nextInt();
					System.out.println("enter updated total wickets");
					newwickets = sc.nextInt();
					System.out.println("Enter updated team name");
					newtname = bf.readLine();
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
				controller = new IPLController();
				String result = controller.updatePlayer(oldname, newname, newruns, newwickets, newtname);

				System.out.println(result);
				System.out.println();
				break;
			}

			// delete player from db
			case 3: {
				String pname = null;
				System.out.println("Enter Play Name");
				try {
					pname = bf.readLine();
					//
					controller = new IPLController();
					String acn = controller.deletePlayer(pname);
					System.out.println(acn);

				} catch (IOException e) {
					e.printStackTrace();
					break;

				}

				break;
			}

			// 4. see all player by team
			case 4: {

				System.out.println("Enter tema name");
				String team = null;
				try {
					team = bf.readLine();
				} catch (IOException e) {

					e.printStackTrace();
					break;

				}
				controller = new IPLController();
				List<String> allplayersofteam = controller.getAllPlayerController(team);
				System.out.println();
				String s = " Players of " + team;

				System.out.println("=====================");
				System.out.printf("|%-20s|\n", s);
				System.out.println("=====================");
				for (String string : allplayersofteam) {

					System.out.printf("|%-20s|\n", string);
					System.out.println("---------------------");

				}
				System.out.println("===============================");

				break;
			}

			// see all team in our db.
			case 5: {
				controller = new IPLController();
				Set<String> allteamsofdb = controller.getAllTeam();
				System.out.println("--------");
				for (String string : allteamsofdb) {

					System.out.printf("| %-6s|\n", string);
					System.out.println("--------");

				}

				break;
			}

			// see player all info by player name
			case 6: {
				String playername = null;
				System.out.println("Enter Player Name");
				try {
					playername = bf.readLine();
				} catch (IOException e) {

					e.printStackTrace();
					break;

				}
				controller = new IPLController();
				List<Player> playerinfo = controller.getPlayerAllInfo(playername);
				System.out.println("---------------------------");
				System.out.println("Player full information");
				System.out.println("---------------------------");

				for (Player string : playerinfo) {
					System.out.println(string);
					System.out.println("---------------------------------------------------------------");
				}

				break;
			}

			case 7: {

				break;
			}
			default:
				System.out.println("invalid choice");
				break;
			}

			if (choice == 7) {

				System.out.println("Thank You....!");
				break;
			}
		} while (true);
	}

}
