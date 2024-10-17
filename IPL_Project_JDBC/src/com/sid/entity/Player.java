package com.sid.entity;

//POJO Class 
//encapsulates class
public class Player {

	// all attributes are private
	private int jrno;
	private String name;
	private int runs;
	private int wicket;
	private String team;

	// non parameterized constructor
	public Player() {
		super();
	}

	// parameterized constructor
	public Player(int jrno, String name, int runs, int wicket, String team) {
		super();
		this.jrno = jrno;
		this.name = name;
		this.runs = runs;
		this.wicket = wicket;
		this.team = team;
	}

	// all getters and setters
	public int getJrno() {
		return jrno;
	}

	public void setJrno(int jrno) {
		this.jrno = jrno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWicket() {
		return wicket;
	}

	public void setWicket(int wicket) {
		this.wicket = wicket;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	// toString method
	@Override
	public String toString() {
		return " Jersey no=" + jrno + "\n Name=" + name + "\n Runs=" + runs + "\n Wicket=" + wicket + "\n TSeam="
				+ team;
	}

}
