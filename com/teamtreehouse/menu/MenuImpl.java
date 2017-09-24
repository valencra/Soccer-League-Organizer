package com.teamtreehouse.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Arrays;

public class MenuImpl implements MenuInterface {

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

    public int getSelectedOption() throws IOException {
        System.out.print("Enter choice: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int option = Integer.parseInt(br.readLine());
        return option;
    }

    public void runSelectedOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Creating a new team...");
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

}