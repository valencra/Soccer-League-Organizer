import com.teamtreehouse.model.League;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.menu.MenuImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LeagueManager {
    public static void main(String[] args) {
        Player[] players = Players.load();
        System.out.printf("There are currently %d registered players.%n", players.length);

        League league = new League();
        List<Player> playersList = Arrays.asList(players);
        Set<Player> playersSet = new TreeSet<Player>(playersList);
        MenuImpl menu = new MenuImpl(league, playersSet);
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

        } while (option != 4);

    }

}
