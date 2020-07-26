package com.oink.DiscordBot.commands;

import org.apache.commons.lang3.math.NumberUtils;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

//public class Calculate extends ListenerAdapter{
//
//	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
//		
//		String[] msg = event.getMessage().getContentRaw().split(" ");
//		
//		
//		if(msg[0].equalsIgnoreCase("!calc") && !event.getMember().getUser().isBot()){
//			if((msg.length != 4)) {
//				usage(event);
//			}
//			else {
//				if(NumberUtils.isCreatable(msg[2]) && NumberUtils.isCreatable(msg[3])) {
//					float num1 = Integer.parseInt(msg[2]);
//					float num2 = Integer.parseInt(msg[3]);
//					if(msg[1].equalsIgnoreCase("add")) {
//						event.getChannel().sendMessage("your sum is " + (num1+num2)).queue();
//					}
//					
//					if(msg[1].equalsIgnoreCase("sub")) {
//						event.getChannel().sendMessage("your diff is " + (num1-num2)).queue();
//					}
//				}
//				else
//					usage(event);
//			}
//		}
//	}

public class Calculate extends Command{

	public Calculate() {
		this.name = "calc";
		this.aliases = new String[] {"calculate"};
		this.help = "given 2 numbers you add or subtract them";
		
	}

	@Override
	protected void execute(CommandEvent event) {
		String[] msg = event.getMessage().getContentRaw().split(" ");
				
				
		if(!event.getMember().getUser().isBot()){
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
	
	public void usage(CommandEvent event) {
		event.getChannel().sendMessage("!calc add/sub num1 num2").queue();
	}
}
