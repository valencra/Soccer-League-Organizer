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
        // generate height-players map
        Map<Integer, List<Player>> playersGroupedByHeight = new TreeMap<>();
        for (Player player : this.players) {
            Integer height = player.getHeightInInches();
            List<Player> playerList = playersGroupedByHeight.get(height);
            if (playerList == null) {
                playersGroupedByHeight.put(height, new ArrayList<>());
            }
            playersGroupedByHeight.get(height).add(player);
        }

        // display team report
        System.out.println("Team Report (players grouped by height):");
        System.out.println(String.join("", Collections.nCopies(62, "-")));
        System.out.printf(
                "%-26s|%-13s|%-20s%n",
                "Player",
                " Height(in.)",
                " Previous Experience"
        );
        System.out.println(String.join("", Collections.nCopies(62, "-")));
        // iterate through heights
        for (Integer height : playersGroupedByHeight.keySet()) {
            List<Player> playerList = playersGroupedByHeight.get(height);
            int counter = 0;
            // iterate through players with the same height
            for (Player player : playerList) {
                counter++;
                System.out.printf("%03d. %s%n", counter, player);
            }
            System.out.println(String.join("", Collections.nCopies(62, "-")));
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
