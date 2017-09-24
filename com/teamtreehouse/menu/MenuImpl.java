package com.teamtreehouse.menu;

import com.teamtreehouse.model.League;
import com.teamtreehouse.model.Team;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Arrays;

public class MenuImpl implements MenuInterface {
    private  League league;
    private BufferedReader br;

    public MenuImpl(League league) {
        this.league = league;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void displayOptions() {
        System.out.printf("%nSelect from one of the follow options: %n");
        List<String> options = Arrays.asList(
                "1. Create a new team",
                "2. Add players to a team",
                "3. Remove players from a team",
                "4. Exit"
        );
        for (String option : options) {
            System.out.println(option);
        }
    }

    @Override
    public int getSelectedOption() throws IOException {
        System.out.print("Enter choice: ");
        int option = Integer.parseInt(br.readLine());
        System.out.println("");
        return option;
    }

    @Override
    public void runSelectedOption(int option) throws IOException{
        switch (option) {
            case 1:
                System.out.println("Creating a new team...");
                System.out.print("Enter team name: ");
                String teamName = this.br.readLine();
                System.out.printf("Enter coach: ");
                String coach = this.br.readLine();
                this.createNewTeam(teamName, coach);
                break;
            case 2:
                System.out.println("Adding players to a team...");
                break;
            case 3:
                System.out.println("Removing players from a team...");
                break;
            case 4:
                System.out.println("Exiting program...");
                break;
            default:
                System.out.println("--- INVALID OPTION ---");
        }
    }

    @Override
    public void createNewTeam(String teamName, String coach) {
        Team team = new Team(teamName, coach);
        this.league.addTeam(team);
    }


}