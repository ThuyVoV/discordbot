package com.oink.DiscordBot.command.commands;

import com.oink.DiscordBot.command.CommandContext;
import com.oink.DiscordBot.command.CommandInterface;

import net.dv8tion.jda.api.entities.User;

public class MsgSomeoneCommand implements CommandInterface{

	@Override
	public void handle(CommandContext context) {
		String toSend = context.getEvent().getMessage().getContentRaw();
		
		context.getChannel().sendMessage("yeah ok nerd, " + toSend).queue();
		
	}

	@Override
	public String getName() {
		return "msg";
	}

	@Override
	public String getHelp() {
		return "to troll darky";
	}

}
