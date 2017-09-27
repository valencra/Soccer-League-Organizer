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

    public Player getPlayer(int playerIdx) {
        return this.players.get(playerIdx);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        this.displayPlayers();
    }

    public void removePlayer(int playerIdx) {
        this.players.remove(playerIdx);
        this.displayPlayers();
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

    public void displayPlayers() {
        // sort by last name and first name, then display list
        Collections.sort(this.players);
        int counter = 0;
        System.out.println("Team Players: ");
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

    public void displayTeamReport() {
        // sort by height, then display list
        this.sortPlayersByHeight();
        int counter = 0;
        System.out.println("Team Report (players sorted by height):");
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
