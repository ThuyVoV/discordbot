package com.oink.DiscordBot.command.commands;

import org.apache.commons.lang3.math.NumberUtils;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.oink.DiscordBot.Config;


public class CalculateCommand extends Command{

	public CalculateCommand() {
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
		String prefix = Config.get("PREFIX");
		event.getChannel().sendMessage(prefix+ "calc add/sub num1 num2").queue();
	}
}
