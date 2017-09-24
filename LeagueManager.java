import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.menu.MenuImpl;

import java.io.IOException;

public class LeagueManager {

    public static void main(String[] args) {
        Player[] players = Players.load();
        System.out.printf("There are currently %d registered players.%n", players.length);
        MenuImpl menu = new MenuImpl();
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
        } while (option != 4);

    }

}
