package com.oink.DiscordBot.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oink.DiscordBot.Config;

import me.duncte123.botcommons.BotCommons;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotUpDown extends ListenerAdapter{

	private static final Logger LOGGER = LoggerFactory.getLogger(BotUpDown.class);
	
	public void onReady(ReadyEvent e) {
		LOGGER.info("Bot is ready!");
	}
	
	
	//shutdown method
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		String prefix = Config.get("PREFIX");
		String msg = e.getMessage().getContentRaw();

		if ( msg.equalsIgnoreCase(prefix+"shutdown") 
				&& e.getAuthor().getId().equals(Config.get("OWNER_ID"))) {
			
			LOGGER.info("Bot is shutting down");
			e.getJDA().shutdown();
			BotCommons.shutdown(e.getJDA());
		}
	}
}
