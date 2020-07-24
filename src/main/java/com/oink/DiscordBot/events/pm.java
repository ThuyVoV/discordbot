package com.oink.DiscordBot.events;

import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class pm extends ListenerAdapter{

	public void onPrivateMessageReceived(PrivateMessageReceivedEvent e) {
		//save the message that was sent
		String sentMsg = e.getMessage().getContentRaw();
		
		//get the name of the person who send tht message
		String name = e.getAuthor().getName();

		//if it is a user and not a bot, do this action
		if( !e.getAuthor().isBot())
			e.getChannel().sendMessage("hello friend " + name + ", you said " + sentMsg + " to me!").queue();
	}
}
