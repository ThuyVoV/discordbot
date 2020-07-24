package com.oink.DiscordBot.events;

import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class pm extends ListenerAdapter{

	public void onPrivateMessageReceived(PrivateMessageReceivedEvent e) {
		//String messageSent = e.getMessage().getContentRaw();
		
		String name = e.getAuthor().getName();

		
		if( !e.getAuthor().isBot())
			e.getChannel().sendMessage("hello friend " + name).queue();
	}
}
