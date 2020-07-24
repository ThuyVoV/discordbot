package com.oink.DiscordBot.events;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class helloCmd extends ListenerAdapter{
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String messageSent = event.getMessage().getContentRaw();
		
		if(messageSent.equalsIgnoreCase("!whisper")) {
			
			if( !event.getMember().getUser().isBot()) {
				event.getChannel().sendMessage("what's up sending msg now").queue();
				
				sendPrivateMessage(event.getAuthor(), "wath up son!!");
			}
		}
	}
	
	public void sendPrivateMessage(User user, String content) {
		
		user.openPrivateChannel().complete().sendMessage(content).queue();
	}
}