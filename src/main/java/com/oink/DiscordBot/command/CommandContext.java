package com.oink.DiscordBot.command;

import java.util.List;

import me.duncte123.botcommons.commands.ICommandContext;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandContext implements ICommandContext{

	private final GuildMessageReceivedEvent event;
	private final List<String> list;
	
	public CommandContext(GuildMessageReceivedEvent event, List<String> list) {
		this.event = event;
		this.list = list;
	}

	// guilds are the discord servers
	@Override
	public Guild getGuild() {
		return this.getEvent().getGuild();
	}
	
	@Override
	public GuildMessageReceivedEvent getEvent() {
		return this.event;
	}

	public List<String> getList(){
		return list;
	}
}
