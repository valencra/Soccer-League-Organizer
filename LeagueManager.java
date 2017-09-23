import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.menu.MenuImpl;

public class LeagueManager {

  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("There are currently %d registered players.%n", players.length);
    MenuImpl menu = new MenuImpl();
    menu.displayOptions();
  }

}
