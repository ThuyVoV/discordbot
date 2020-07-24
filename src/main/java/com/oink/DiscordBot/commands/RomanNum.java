package com.oink.DiscordBot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class RomanNum {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		
		//ignores bots
		if( e.getAuthor().isBot())
			return;
		
		
	}
}
