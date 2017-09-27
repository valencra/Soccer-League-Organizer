package com.teamtreehouse.menu;

import com.teamtreehouse.model.League;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Arrays;

public class MenuImpl implements MenuInterface {
    private League league;
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
        System.out.print("Enter option number: ");
        int option = Integer.parseInt(br.readLine());
        System.out.println("");
        return option;
    }

    @Override
    public void runSelectedOption(int option) throws IOException{
        int teamIdx;
        Team selectedTeam;
        int playerIdx;
        Player selectedPlayer;

        switch (option) {
            case 1:
                System.out.println("Creating a new team...");
                if (this.league.getPlayerCount() > 0) {
                    System.out.print("Enter team name: ");
                    String teamName = this.br.readLine();
                    System.out.printf("Enter coach: ");
                    String coach = this.br.readLine();
                    this.league.createNewTeam(teamName, coach);
                }
                else {
                    System.out.println(
                            "Cannot create a new team. The league already has the maximum number of teams."
                    );
                }
                break;

            case 2:
                System.out.println("Adding players to a team...");
                // select team
                this.league.displayTeams();
                System.out.print("Enter team number: ");
                teamIdx = Integer.parseInt(br.readLine()) - 1;
                selectedTeam = this.league.getTeam(teamIdx);
                System.out.printf(
                        "Selected team: %s with coach %s%n",
                        selectedTeam.getTeamName(),
                        selectedTeam.getCoach()
                );
                // select player
                this.league.displayPlayers();
                System.out.print("Enter player number: ");
                playerIdx = Integer.parseInt(br.readLine()) - 1;
                selectedPlayer = this.league.getPlayer(playerIdx);
                System.out.printf(
                        "Selected player: %s, %s%n",
                        selectedPlayer.getLastName(),
                        selectedPlayer.getFirstName()
                );
                if (selectedTeam.getPlayerCount() < 11) {
                    this.league.removePlayer(playerIdx);
                    selectedTeam.addPlayer(selectedPlayer);
                }
                else {
                    System.out.println(
                            "Cannot add a new player. The selected team already has the maximum number of players."
                    );
                }
                // TO-DO: add team report
                break;
            case 3:
                System.out.println("Removing players from a team...");
                this.league.displayTeams();
                System.out.print("Enter team number: ");
                teamIdx = Integer.parseInt(br.readLine());
                selectedTeam = this.league.getTeam(teamIdx);
                System.out.printf(
                        "Selected Team: %s with coach %s%n",
                        selectedTeam.getTeamName(),
                        selectedTeam.getCoach()
                );
                this.league.displayPlayers();
                break;

            case 4:
                System.out.println("Exiting program...");
                break;

            default:
                teamIdx = -1;
                selectedTeam =null;
                playerIdx = -1;
                selectedPlayer = null;
                System.out.println("--- INVALID OPTION ---");
        }
    }

}