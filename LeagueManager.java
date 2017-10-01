import com.teamtreehouse.model.League;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.menu.MenuImpl;

import java.io.IOException;
import java.util.*;

public class LeagueManager {
    public static void main(String[] args) {
        Player[] players = Players.load();
        System.out.printf("There are currently %d registered players.%n", players.length);

        List<Player> availablePlayers = new ArrayList<Player>(Arrays.asList(players));
        Collections.sort(availablePlayers);
        League league = new League(availablePlayers);
        MenuImpl menu = new MenuImpl(league);
        int option = 0;
        do {
            // display options
            menu.displayOptions();

            // get selected option
            try {
                option = menu.getSelectedOption();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // run selected option
            try {
                menu.runSelectedOption(option);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } while (option != 7);

    }

}
