package com.teamtreehouse.model;

import java.util.*;

public class League {
    private List<Team> teams;
    private List<Player> availablePlayers;

    public League(List<Player> availablePlayers) {
        this.teams = new ArrayList<>();
        this.availablePlayers = availablePlayers;
    }

    public void displayLeagueBalanceReport() {
        int counter = 0;
        for (Team team : this.teams) {
            counter++;
            System.out.println(String.join("", Collections.nCopies(58, "-")));
            System.out.printf("%03d. Team %s with coach %s%n", counter, team.getTeamName(), team.getCoach());
            System.out.println(String.join("", Collections.nCopies(58, "-")));
            team.calculateExperienceStatistics();
            System.out.printf("Experienced players: %d%n", team.getExperiencedCount());
            System.out.printf("Inexperienced players: %d%n", team.getInexperiencedCount());
            System.out.printf("Percent experienced players: %3.2f %%%n%n", team.getPercentExperienced());
        }
    }

    public void createNewTeam(String teamName, String coach) {
        Team team = new Team(teamName, coach);
        this.teams.add(team);
        this.displayTeams();
    }

    public void displayTeams() {
        Collections.sort(this.teams);
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
        Collections.sort(this.availablePlayers);
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

    public void addPlayer(Player player) {
        this.availablePlayers.add(player);
        Collections.sort(this.availablePlayers);
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
