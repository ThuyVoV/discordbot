package com.oink.DiscordBot.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class helloCmd extends ListenerAdapter{
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String messageSent = event.getMessage().getContentRaw();
		
		if(messageSent.equalsIgnoreCase("hello")) {
			
			if( !event.getMember().getUser().isBot())
				event.getChannel().sendMessage("what's up ").queue();
		}
	}
}