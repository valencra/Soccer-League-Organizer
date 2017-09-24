package com.teamtreehouse.menu;

import java.io.IOException;

public interface MenuInterface {
    void displayOptions();

    int getSelectedOption() throws IOException;

    void runSelectedOption(int option) throws IOException;

    void createNewTeam(String teamName, String coach);

    void displayPlayersSet();
}