package com.oink.DiscordBot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.oink.DiscordBot.commands.Calculate;
import com.oink.DiscordBot.commands.RomanNum;
import com.oink.DiscordBot.events.helloCmd;
import com.oink.DiscordBot.events.pm;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class MainApp 
{
    public static void main( String[] args ) throws Exception{

//    	BufferedReader brTest = new BufferedReader(new FileReader("stuff"));
//        String str = brTest .readLine();
//        brTest.close();
    	
    	
        
        List<String> list = Files.readAllLines(Paths.get("config.txt"));
        String token = list.get(0);
        String ownerId = list.get(1);
        String prefix = list.get(2);
        
        JDA jda = JDABuilder.createDefault(token).build();
        
        CommandClientBuilder builder = new CommandClientBuilder();
        System.out.println(prefix);
        builder.setOwnerId(ownerId);
        builder.setPrefix(prefix);
        builder.setHelpWord("bothelp");

        //builder.addCommand(command);
        
        CommandClient client = builder.build();
        builder.addCommand(new Calculate());
        jda.addEventListener(new helloCmd());
        //jda.addEventListener(new Calculate());
        jda.addEventListener(new pm());
        jda.addEventListener(new RomanNum());
    }
}
