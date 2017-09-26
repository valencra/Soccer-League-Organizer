package com.teamtreehouse.model;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class League {
    private Set<Team> teams;
    private Set<Player> availablePlayers;

    public League(Set<Player> playersSet) {
        this.teams = new TreeSet<Team>();
        this.availablePlayers = playersSet;
    }

    public void createNewTeam(String teamName, String coach) {
        Team team = new Team(teamName, coach);
        this.teams.add(team);
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

    public void displayPlayersSet() {
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
}
