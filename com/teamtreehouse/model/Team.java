package com.teamtreehouse.model;

import java.util.*;

public class Team implements Comparable{
    private String teamName;
    private String coach;
    private List<Player> players;
    private int experiencedCount;
    private int inexperiencedCount;
    private double percentExperienced;

    public Team(String teamName, String coach) {
        this.teamName = teamName;
        this.coach = coach;
        this.players = new ArrayList<Player>();
        this.experiencedCount = 0;
        this.inexperiencedCount = 0;
        this.percentExperienced = 0.00;
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

    public int getExperiencedCount() {
        return experiencedCount;
    }

    public int getInexperiencedCount() {
        return inexperiencedCount;
    }

    public double getPercentExperienced() {
        return percentExperienced;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        this.displayPlayers();
    }

    public void removePlayer(int playerIdx) {
        this.players.remove(playerIdx);
        this.displayPlayers();
    }

    public void calculateExperienceStatistics() {
        this.experiencedCount = 0;
        this.inexperiencedCount = 0;
        this.percentExperienced = 0.00;

        if (this.players.size() != 0) {
            for (Player player : this.players) {
                if (player.isPreviousExperience()) {
                    this.experiencedCount++;
                }
            }
            this.inexperiencedCount = this.players.size() - experiencedCount;
            this.percentExperienced = (double) this.experiencedCount / (double) this.players.size() * 100.00;
        }

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
        Map<String, List<Player>> playersGroupedByHeight = new TreeMap<>();
        // height ranges
        playersGroupedByHeight.put("35-40", new ArrayList<>());
        playersGroupedByHeight.put("41-46", new ArrayList<>());
        playersGroupedByHeight.put("47-50", new ArrayList<>());
        for (Player player : this.players) {
            int height = player.getHeightInInches();
            if (height>=35 && height<=40) {
                playersGroupedByHeight.get("35-40").add(player);
            } else if (height>=41 && height<=46) {
                playersGroupedByHeight.get("41-46").add(player);
            } else if (height>=47 && height<=50) {
                playersGroupedByHeight.get("47-50").add(player);
            } else {
                System.out.printf(
                        "Player %s, %s has a height outside official ranges",
                        player.getLastName(), player.getFirstName()
                );
            }
        }

        // display team report
        System.out.println("Team Report (players grouped by height):");

        // iterate through height ranges
        for (String heightRange : playersGroupedByHeight.keySet()) {
            List<Player> playerList = playersGroupedByHeight.get(heightRange);
            int playerCount = playerList.size();
            int counter = 0;

            // only print group if not empty
            if (playerCount!=0) {
                System.out.println(String.join("", Collections.nCopies(62, "-")));
                System.out.printf("%s inches: %d player/s%n", heightRange, playerCount);
                System.out.println(String.join("", Collections.nCopies(62, "-")));
                System.out.printf(
                        "%-26s|%-13s|%-20s%n",
                        "Player",
                        " Height(in.)",
                        " Previous Experience"
                );
                System.out.println(String.join("", Collections.nCopies(62, "-")));

                // iterate through players with the same height
                for (Player player : playerList) {
                    counter++;
                    System.out.printf("%03d. %s%n", counter, player);
                }
                System.out.println();
            }

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
