package com.teamtreehouse.model;

import java.util.*;

public class Team implements Comparable{
    private String teamName;
    private String coach;
    private List<Player> players;

    public Team(String teamName, String coach) {
        this.teamName = teamName;
        this.coach = coach;
        this.players = new ArrayList<Player>();
    }

    public String getTeamName() {
        return this.teamName;
    }

    public String getCoach() {
        return this.coach;
    }

    public int getPlayerCount() {
        return this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        Collections.sort(this.players);
        System.out.printf(
                "Added %s, %s to team %s with coach %s%n",
                player.getLastName(),
                player.getFirstName(),
                this.teamName,
                this.coach
        );
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
