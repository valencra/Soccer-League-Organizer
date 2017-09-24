package com.teamtreehouse.model;

import java.util.Set;
import java.util.TreeSet;

public class League {
    private Set<Team> teams;

    public League() {
        this.teams = new TreeSet<Team>();
    }

    public void addTeam(Team team) {
        this.teams.add(team);
        this.displayTeams();
    }

    public void displayTeams() {
        System.out.println("Current teams on the league: ");
        int counter = 0;
        for (Team entry: teams) {
            counter++;
            System.out.printf("%d. %s%n", counter, entry);
        }
    }
}
