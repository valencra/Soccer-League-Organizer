package com.teamtreehouse.model;

import java.util.Set;
import java.util.TreeSet;

public class League {
    private Set<Team> teams;

    public League() {
        this.teams = new TreeSet<Team>();
    }
}
