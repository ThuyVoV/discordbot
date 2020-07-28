package com.oink.DiscordBot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import com.oink.DiscordBot.command.CommandContext;
import com.oink.DiscordBot.command.CommandInterface;
import com.oink.DiscordBot.command.commands.HelpCommand;
import com.oink.DiscordBot.command.commands.MsgSomeoneCommand;
import com.oink.DiscordBot.command.commands.PingCommand;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandManager {
	private final List<CommandInterface> commands = new ArrayList<CommandInterface>();
	
	//adding my commands
	public CommandManager() {
		addCommand(new PingCommand());
		addCommand(new HelpCommand(this));
		addCommand(new MsgSomeoneCommand());
	}
	
	//if command already exists do not add, else add it
	private void addCommand(CommandInterface cmd) {
		
		//iterates through the commands list, check to see if the command matches
		boolean nameFound = this.commands.stream().anyMatch(
				(it) -> it.getName().equalsIgnoreCase(cmd.getName()));
		
		
		if (nameFound) {
			throw new IllegalArgumentException("This command name already exist");
		}
		
		commands.add(cmd);
	}
	
	public List<CommandInterface> getCommands(){
		return commands;
	}
	
	//allows us to return null
	@Nullable
	public CommandInterface getCommand(String search) {
		String searchLower = search.toLowerCase();
		
		//checks for the command we inputted
		for (CommandInterface cmd : this.commands) {
			if(cmd.getName().equals(searchLower) || cmd.getAliases().contains(searchLower))
				return cmd;
		}
		
		return null;
	}
	
	void handle(GuildMessageReceivedEvent event) {
		
		/*
		 * gets the original message and removes the prefix
		 * then it will split each "word" that are separated by at least 1 white space
		 * 
		 * (?i) means case insensitive?
		 * \\s+ means 1 or more white spaces, first '\' is an escape char
		 */
		String[] splitMsg = event.getMessage().getContentRaw()
				.replaceFirst("(?i)" + Pattern.quote(Config.get("PREFIX")), "")
				.split("\\s+");
		
		String cmdWord = splitMsg[0].toLowerCase();
		CommandInterface cmd = this.getCommand(cmdWord);
		
		if ( cmd != null) {
			//shows that the bot is typing
			event.getChannel().sendTyping().queue();
			
			//remove first index, starting at 2nd element
			List<String> list = Arrays.asList(splitMsg).subList(1, splitMsg.length);
			
			CommandContext context = new CommandContext(event, list);
			
			cmd.handle(context);
		}
		
	}
}
