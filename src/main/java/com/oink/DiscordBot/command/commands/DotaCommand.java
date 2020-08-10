package com.oink.DiscordBot.command.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class DotaCommand extends Command{
	
	public DotaCommand() {
		this.name="dota";
		
	}
	
	@Override
	protected void execute(CommandEvent event) {
		String[] msg = event.getMessage().getContentRaw().split(" ");
		try {
			event.reply("https://dota2.gamepedia.com/" + msg[1]);
		}
		catch (NullPointerException e) {
			
		}
	}
	
}
