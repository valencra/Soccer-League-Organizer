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
        this.sortPlayersByHeight();
        System.out.printf(
                "Added %s, %s to team %s with coach %s%n",
                player.getLastName(),
                player.getFirstName(),
                this.teamName,
                this.coach
        );
        this.displayTeamReport();
    }

    private void sortPlayersByHeight() {
        Collections.sort(this.players, new Comparator<Player>(){
            public int compare(Player current, Player next){
                if(current.getHeightInInches() == next.getHeightInInches())
                    return 0;
                return current.getHeightInInches() < next.getHeightInInches() ? -1 : 1;
            }
        });
    }

    public void displayTeamReport() {
        int counter = 0;
        System.out.println("Team Report:");
        System.out.println(String.join("", Collections.nCopies(62, "-")));
        System.out.printf(
                "%-26s|%-13s|%-20s%n",
                "Player",
                " Height(in.)",
                " Previous Experience"
        );
        System.out.println(String.join("", Collections.nCopies(62, "-")));
        for (Player player : this.players) {
            counter++;
            System.out.printf("%03d. %s%n", counter, player);
        }
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
