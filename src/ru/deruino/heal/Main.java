package ru.deruino.heal;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getLogger().info("Heal Plugin registered!!!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("heal")) {
            if (args.length < 1) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;

                    player.setHealth(20.0);

                    sender.sendMessage("Здоровье успешно восстановлено.");
                } else {
                    sender.sendMessage("Вы не являетесь игроком.");
                }
            } else {
                Player player = Bukkit.getServer().getPlayer(args[0]);

                if (player != null) {
                    player.setHealth(20.0);

                    sender.sendMessage("Здоровье успешно восстановлено игроку " + args[0]);
                } else {
                    sender.sendMessage("Игрок " + args[0] + " не найден.");
                }
            }
        }

        return true;
    }
}
