package io.github.mooy1.infinitylib.commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

final class HelpCommand extends SubCommand {

    private final ParentCommand command;

    HelpCommand(ParentCommand command) {
        super("help", "显示此帮助");
        this.command = command;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("");
        sender.sendMessage("&7----------&b /" + command.fullName() + " 帮助 &7----------");
        sender.sendMessage("");
        for (SubCommand sub : command.available(sender)) {
            sender.sendMessage("/" + sub.fullName() + ChatColor.YELLOW + " - " + sub.description());
        }
        sender.sendMessage("");
    }

    @Override
    public void complete(CommandSender sender, String[] args, List<String> tabs) {

    }

}
