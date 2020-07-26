package com.oink.DiscordBot;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.oink.DiscordBot.commands.Calculate;
import com.oink.DiscordBot.commands.RomanNum;
import com.oink.DiscordBot.events.BotReady;
import com.oink.DiscordBot.events.helloCmd;
import com.oink.DiscordBot.events.pm;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class MainApp 
{
	
	
    public static void main( String[] args ) throws Exception{

//        List<String> list = Files.readAllLines(Paths.get("config.txt"));
//        String token = list.get(0);
//        String ownerId = list.get(1);
//        String prefix = list.get(2);
        
        JDA jda = JDABuilder.createDefault(Config.get("TOKEN"))
        		.addEventListeners(new BotReady())
        		.setActivity(Activity.watching("something fun"))
        		.build();
        
        CommandClientBuilder builder = new CommandClientBuilder();
        //System.out.println(prefix);
        builder.setOwnerId(Config.get("OWNDER_ID"));
        builder.setPrefix(Config.get("PREFIX"));
        builder.setHelpWord("bothelp");
        

        //builder.addCommand(command);
        
        builder.addCommand(new Calculate());
        CommandClient client = builder.build();
        

        jda.addEventListener(client);
        
        
        jda.addEventListener(new helloCmd());
        //jda.addEventListener(new Calculate());
        jda.addEventListener(new pm());
        jda.addEventListener(new RomanNum());
    }
}
