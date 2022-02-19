package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class flycommand implements CommandExecutor {

    private ArrayList<Player> list_of_players_flying = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("fly")){
                if(list_of_players_flying.contains(player)){
                    list_of_players_flying.remove(player);
                    player.setAllowFlight(false);
                    player.sendMessage("Fly has been Disabled.");
                }else if(!list_of_players_flying.contains(player)){
                    list_of_players_flying.add(player);
                    player.setAllowFlight(true);
                    player.sendMessage("You can now Fly.");
                }

            }
        }

        return true;
    }

}