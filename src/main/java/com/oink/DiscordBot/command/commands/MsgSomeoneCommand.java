package com.oink.DiscordBot.command.commands;

import com.oink.DiscordBot.command.CommandContext;
import com.oink.DiscordBot.command.CommandInterface;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MsgSomeoneCommand implements CommandInterface{

	@Override
	public void handle(CommandContext context) {
		String str = context.getEvent().getMessage().getContentRaw();
		
		
		
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
