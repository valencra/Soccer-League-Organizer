package com.teamtreehouse.model;

import java.util.Set;
import java.util.TreeSet;

public class Team implements Comparable{
    private String teamName;
    private String coach;
    private Set<Player> players;

    public Team(String teamName, String coach) {
        this.teamName = teamName;
        this.coach = coach;
        this.players = new TreeSet<Player>();
    }

    @Override
    public String toString() {
        return String.format("%-25s | %-25s", this.teamName, this.coach);
    }

    @Override
    public int compareTo(Object o) {
        Team anotherTeam = (Team) o;
        return this.teamName.compareTo(anotherTeam.teamName);
    }
}
