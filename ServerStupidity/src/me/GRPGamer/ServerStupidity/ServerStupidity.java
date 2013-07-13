package me.GRPGamer.ServerStupidity;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerStupidity extends JavaPlugin
{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static ServerStupidity plugin;

  public void onDisable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " Has Now Been Disabled!");
  }

  public void onEnable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Now Been Enabled!");
    getConfig().options().copyDefaults(true);
    saveConfig();
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if (cmd.getName().equalsIgnoreCase("serverstupidity")) {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.GOLD + "Server Stupidity:");
        sender.sendMessage(ChatColor.YELLOW + "- /ss - Shows this help page");
        sender.sendMessage(ChatColor.YELLOW + "- /ss slap - Slaps a Player");
        sender.sendMessage(ChatColor.YELLOW + "- /ss punch - Punches a Player");
        sender.sendMessage(ChatColor.YELLOW + "- /ss poke - Pokes a Player");
        sender.sendMessage(ChatColor.YELLOW + "- /ss burn - Burns a Player");
        sender.sendMessage(ChatColor.YELLOW + "- /ss kill - Kills a Player");
      }

      if (args[0].equalsIgnoreCase("slap")) {
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You cannot perform that command from the console!");
          return true;
        }
        if (!sender.hasPermission("serverstupidity.slap")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to do that.");
          return true;
        }
        if (args.length != 2) {
          sender.sendMessage(ChatColor.RED + "Usage: /serverstupidity slap <player>");
          return true;
        }
        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + args[1] + " is not online!");
          return true;
        }
        target.sendMessage(ChatColor.GREEN + getConfig().getString("SlapRecieve").replaceAll("%sender%", sender.getName()));
        target.damage(1);
        sender.sendMessage(ChatColor.GREEN + getConfig().getString("SlapSend").replaceAll("%victim%", target.getName()));
      }
      else if (args[0].equalsIgnoreCase("punch")) {
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You cannot perform that command from the console!");
          return true;
        }
        if (!sender.hasPermission("serverstupidity.punch")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to do that.");
          return true;
        }
        if (args.length != 2) {
          sender.sendMessage(ChatColor.RED + "Usage: /serverstupidity punch <player>");
          return true;
        }
        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + args[1] + " is not online!");
          return true;
        }
        target.sendMessage(ChatColor.GREEN + getConfig().getString("PunchRecieve").replaceAll("%sender%", sender.getName()));
        target.damage(2);
        sender.sendMessage(ChatColor.GREEN + getConfig().getString("PunchSend").replaceAll("%victim%", target.getName()));
      }
      else if (args[0].equalsIgnoreCase("poke")) {
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You cannot perform that command from the console!");
          return true;
        }
        if (!sender.hasPermission("serverstupidity.poke")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to do that.");
          return true;
        }
        if (args.length != 2) {
          sender.sendMessage(ChatColor.RED + "Usage: /serverstupidity poke <player>");
          return true;
        }
        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + args[1] + " is not online!");
          return true;
        }
        target.sendMessage(ChatColor.GREEN + getConfig().getString("PokeRecieve").replaceAll("%sender%", sender.getName()));
        sender.sendMessage(ChatColor.GREEN + getConfig().getString("PokeSend").replaceAll("%victim%", target.getName()));
      }
      else if (args[0].equalsIgnoreCase("burn")) {
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You cannot perform that command from the console!");
          return true;
        }
        if (!sender.hasPermission("serverstupidity.burn")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to do that.");
          return true;
        }
        if (args.length != 2) {
          sender.sendMessage(ChatColor.RED + "Usage: /serverstupidity burn <player>");
          return true;
        }
        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + args[1] + " is not online!");
          return true;
        }
        target.sendMessage(ChatColor.GREEN + getConfig().getString("BurnRecieve").replaceAll("%sender%", sender.getName()));
        target.setFireTicks(1000);
        sender.sendMessage(ChatColor.GREEN + getConfig().getString("BurnSend").replaceAll("%victim%", target.getName()));
      }
      else if (args[0].equalsIgnoreCase("kill")) {
        if (!(sender instanceof Player)) {
          sender.sendMessage(ChatColor.RED + "You cannot perform that command from the console!");
          return true;
        }
        if (!sender.hasPermission("serverstupidity.kill")) {
          sender.sendMessage(ChatColor.RED + "You do not have permission to do that.");
          return true;
        }
        if (args.length != 2) {
          sender.sendMessage(ChatColor.RED + "Usage: /serverstupidity kill <player>");
          return true;
        }
        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
          sender.sendMessage(ChatColor.RED + args[1] + " is not online!");
          return true;
        }
        target.sendMessage(ChatColor.GREEN + getConfig().getString("KillRecieve").replaceAll("%sender%", sender.getName()));
        target.setHealth(0);
        sender.sendMessage(ChatColor.GREEN + getConfig().getString("KillSend").replaceAll("%victim%", target.getName()));
      }
      else {
        Bukkit.dispatchCommand(sender, "serverstupidity");
      }
    }
    return true;
  }
}