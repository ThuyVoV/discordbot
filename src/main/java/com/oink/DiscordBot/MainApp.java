package com.oink.DiscordBot;

import java.io.BufferedReader;
import java.io.FileReader;

import com.oink.DiscordBot.commands.Calculate;
import com.oink.DiscordBot.events.helloCmd;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class MainApp 
{
    public static void main( String[] args ) throws Exception{

    	BufferedReader brTest = new BufferedReader(new FileReader("stuff"));
        String str = brTest .readLine();
        brTest.close();


        JDA jda = JDABuilder.createDefault(str).build();
        
        jda.addEventListener(new helloCmd());
        jda.addEventListener(new Calculate());
    }
}
