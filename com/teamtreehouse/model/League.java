package com.teamtreehouse.model;

import java.util.*;

public class League {
    private List<Team> teams;
    private List<Player> availablePlayers;

    public League(List<Player> availablePlayers) {
        this.teams = new ArrayList<>();
        this.availablePlayers = availablePlayers;
    }

    public void createNewTeam(String teamName, String coach) {
        Team team = new Team(teamName, coach);
        this.teams.add(team);
        Collections.sort(this.teams);
        this.displayTeams();
    }

    public void displayTeams() {
        System.out.println("Current teams on the league: ");
        System.out.println(String.join("", Collections.nCopies(58, "-")));
        System.out.printf(
                "%-31s|%-25s%n",
                "Team",
                " Coach"
        );
        System.out.println(String.join("", Collections.nCopies(58, "-")));
        int counter = 0;
        for (Team entry: teams) {
            counter++;
            System.out.printf("%03d. %s%n", counter, entry);
        }
    }

    public Team getTeam(int teamIdx) {
        return this.teams.get(teamIdx);
    }

    public void displayPlayers() {
        int counter = 0;
        System.out.println("Available players: ");
        System.out.println(String.join("", Collections.nCopies(62, "-")));
        System.out.printf(
                "%-26s|%-13s|%-20s%n",
                "Player",
                " Height(in.)",
                " Previous Experience"
        );
        System.out.println(String.join("", Collections.nCopies(62, "-")));
        for (Player player : this.availablePlayers) {
            counter++;
            System.out.printf("%03d. %s%n", counter, player);
        }
    }

    public void removePlayer(int playerIdx) {
        this.availablePlayers.remove(playerIdx);
    }

    public Player getPlayer(int playerIdx) {
        return this.availablePlayers.get(playerIdx);
    }

    public int getPlayerCount() {
        return this.availablePlayers.size();
    }
}
