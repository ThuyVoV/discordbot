package com.oink.DiscordBot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.duncte123.botcommons.BotCommons;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotUpDown extends ListenerAdapter{

	private static final Logger LOGGER = LoggerFactory.getLogger(BotUpDown.class);
	private final CommandManager manager = new CommandManager();
	
	public void onReady(ReadyEvent e) {
		LOGGER.info("Bot is ready!");
	}
	
	
	//shutdown method
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		User user = e.getAuthor();
		
		if(user.isBot() || e.isWebhookMessage())
			return;
		
		String prefix = Config.get("PREFIX");
		String msg = e.getMessage().getContentRaw();

		if ( msg.equalsIgnoreCase(prefix+"shutdown") 
				&& user.getId().equals(Config.get("OWNER_ID"))) {
			
			LOGGER.info("Bot is shutting down");
			e.getJDA().shutdown();
			BotCommons.shutdown(e.getJDA());
			
			return;
		}
		
		if (msg.startsWith(prefix)) {
			manager.handle(e);
		}
	}
	
	public void onPrivateMessageReceived(PrivateMessageReceivedEvent e) {
		User user = e.getAuthor();
		
		if(user.isBot())
			return;
		
		String prefix = Config.get("PREFIX");
		String msg = e.getMessage().getContentRaw();

		if ( msg.equalsIgnoreCase(prefix+"shutdown") 
				&& user.getId().equals(Config.get("OWNER_ID"))) {
			
			LOGGER.info("Bot is shutting down");
			e.getJDA().shutdown();
			BotCommons.shutdown(e.getJDA());
		}
	}

}
