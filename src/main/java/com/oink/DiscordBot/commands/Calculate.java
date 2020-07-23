package com.oink.DiscordBot.commands;

import org.apache.commons.lang3.math.NumberUtils;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Calculate extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] msg = event.getMessage().getContentRaw().split(" ");
		
		
		if(msg[0].equalsIgnoreCase("!calc") && !event.getMember().getUser().isBot()){
			if((msg.length != 4)) {
				usage(event);
			}
			else {
				if(NumberUtils.isCreatable(msg[2]) && NumberUtils.isCreatable(msg[3])) {
					float num1 = Integer.parseInt(msg[2]);
					float num2 = Integer.parseInt(msg[3]);
					if(msg[1].equalsIgnoreCase("add")) {
						event.getChannel().sendMessage("your sum is " + (num1+num2)).queue();
					}
					
					if(msg[1].equalsIgnoreCase("sub")) {
						event.getChannel().sendMessage("your diff is " + (num1-num2)).queue();
					}
				}
				else
					usage(event);
			}
		}
	}
	
	public void usage(GuildMessageReceivedEvent event) {
		event.getChannel().sendMessage("!calc add/sub num1 num2").queue();
	}
}
