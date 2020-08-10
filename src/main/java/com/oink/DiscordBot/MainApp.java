package com.oink.DiscordBot;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.oink.DiscordBot.command.commands.CalculateCommand;
import com.oink.DiscordBot.command.commands.DotaCommand;
import com.oink.DiscordBot.command.commands.RomanCommand;
import com.oink.DiscordBot.event.events.helloCmd;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class MainApp 
{
	
	
    public static void main( String[] args ) throws Exception{
        
        JDA jda = JDABuilder.createDefault(Config.get("TOKEN"))
        	.addEventListeners(new BotUpDown())
        	.build();
        
        CommandClientBuilder builder = new CommandClientBuilder();

        builder.setOwnerId(Config.get("OWNER_ID"));
        builder.setPrefix(Config.get("PREFIX"));
        builder.setHelpWord(Config.get("HELP_WORD"));
        
        builder.setActivity(Activity.playing("OINK OINK GOTTA CODE!!"));

        builder.addCommand(new CalculateCommand());
        builder.addCommand(new DotaCommand());
        CommandClient client = builder.build();
        

        jda.addEventListener(client);
        
        jda.addEventListener(new helloCmd());
        jda.addEventListener(new RomanCommand());
    }
}
