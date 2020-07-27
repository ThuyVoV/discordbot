package com.oink.DiscordBot.command;

import java.util.List;

public interface CommandInterface {
	
	
	void handle(CommandContext context);
	
	//get name of command
	String getName();
	
	String getHelp();
	
	default List<String> getAliases(){
		return List.of();
	}
}
