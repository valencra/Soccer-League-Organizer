package com.teamtreehouse.model;

import java.util.Set;
import java.util.TreeSet;

public class Team {
    private String teamName;
    private String coach;
    private Set<Player> players;

    public Team(String teamName, String coach) {
        this.teamName = teamName;
        this.coach = coach;
        this.players = new TreeSet<Player>();
    }
}
