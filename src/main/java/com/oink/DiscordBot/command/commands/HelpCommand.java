package com.oink.DiscordBot.command.commands;

import java.util.List;

import com.oink.DiscordBot.CommandManager;
import com.oink.DiscordBot.Config;
import com.oink.DiscordBot.command.CommandContext;
import com.oink.DiscordBot.command.CommandInterface;

import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand implements CommandInterface{
	
	private final CommandManager manager;
	
	public HelpCommand(CommandManager manager) {
		this.manager = manager;
	}

	@Override
	public void handle(CommandContext context) {
		//args is everything after the "commandWord" in this case "help"
		List<String> args = context.getArgs();
		TextChannel channel = context.getChannel();
		
		//if no argument display all the commands
		if(args.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			builder.append("List of commands\n");
			
			manager.getCommands().stream().map(CommandInterface::getName).forEach(
					(it) -> builder.append(Config.get("PREFIX")).append(it).append("\n")
			);
			
			channel.sendMessage("```"+builder.toString()+"```").queue();
			
			return;
		}

		
		String search = args.get(0);
		CommandInterface command = manager.getCommand(search);
		
		//if there is no command that matches display nothing found
		if(command == null) {
			channel.sendMessage("Nothing found for " + search).queue();
			return;
		}
		
		//if there is an argument display that help message for that command
		channel.sendMessage(command.getHelp()).queue();
	}

	@Override
	public String getName() {
		return "help";
	}

	@Override
	public String getHelp() {
		return "Shows the list of all the commands for the bot\n"
				+ "Usage: `" + Config.get("PREFIX") + "help [command]`";
	}
	
	public List<String> getAliases(){
		return List.of("commands", "cmds","commandlist");
	}

}
