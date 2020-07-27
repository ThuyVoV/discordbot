package com.oink.DiscordBot.command;

import java.util.List;

public interface CommandInterface {
	
	void handle(CommandContext context);
	
	//get name of command
	String getName();
	
	default List<String> getAliases(){
		return List.of();
	}
}
