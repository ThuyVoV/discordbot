package com.oink.DiscordBot.command.commands;

import com.oink.DiscordBot.command.CommandContext;
import com.oink.DiscordBot.command.CommandInterface;

import net.dv8tion.jda.api.JDA;

public class PingCommand implements CommandInterface{

	@Override
	public void handle(CommandContext context) {
		JDA jda = context.getJDA();
		
		jda.getRestPing().queue(
				(ping) ->context.getChannel().sendMessageFormat(
						"Rest Ping: %sms\nWS ping %sms", ping, jda.getGatewayPing()).queue()
		);
	}

	@Override
	public String getName() {
		return "ping";
	}

	@Override
	public String getHelp() {
		return "Shows the current ping of the bot to the discord server";
	}
	
}
