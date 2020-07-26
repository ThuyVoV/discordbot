package com.oink.DiscordBot.events;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotReady extends ListenerAdapter{

	public void onReady(ReadyEvent e) {
		System.out.println("Bot is ready!");
	}
}
