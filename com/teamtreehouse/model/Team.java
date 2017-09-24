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

    public void displayPlayers() {
        int counter = 0;
        for (Player player : this.players) {
            counter++;
            System.out.printf(
                    "%d. %s",
                    counter,
                    player
            );
        }
    }

    @Override
    public String toString() {
        return String.format("Team name: %s | Coach: %s", this.teamName, this.coach);
    }

    @Override
    public int compareTo(Object o) {
        Team anotherTeam = (Team) o;
        return this.teamName.compareTo(anotherTeam.teamName);
    }
}
