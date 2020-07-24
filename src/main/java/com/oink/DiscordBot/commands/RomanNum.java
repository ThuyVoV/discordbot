package com.oink.DiscordBot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RomanNum extends ListenerAdapter{
	
	
	//convert roman numeral to numeric value
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		
		//ignores bots
		if( e.getAuthor().isBot())
			return;
		
		String[] msg = e.getMessage().getContentRaw().split(" ");
		
		/*
		 * 1. split parse the string delimit by space
		 * 2. check if msg[0] is !roman
		 * 		2a. if message is !roman, check if msg length is 2 if not exit
		 * 3. uppercase everything in msg[1] to match roman numeral chars
		 */
		
		if(msg[0].equalsIgnoreCase("!roman")) {
			if(msg.length != 2)
				usage(e);
			else {
				int value = calculate(msg[1]);
				
				if(value != -1)
					e.getChannel().sendMessage("the value for " + msg[1] + " is: " + value).queue();
				else
					usage(e);
			}
		}
	}

	public int calculate(String roman) {
		
		int sum = 0;
		if(roman.length() < 1)
			return 0;
		
		if(roman.length()==1)
			return (getVal(roman.charAt(0)));
		
		for (int i = 0; i < roman.length(); i++) {
			
			//add the value of the last char to the sum, then break
			if ( i == roman.length() - 1) {
				sum += getVal(roman.charAt(i));
				break;
			}
			
			//getting the value of the characters
			int curNum = getVal(roman.charAt(i));
			int nextNum = getVal(roman.charAt(i+1));
			
			//if any of the characters are invalid roman char, it exits
			if (curNum == -1 || nextNum == -1)
				return -1;
			
			//cases if a I followed by V (IV) means 4
			if ( nextNum > curNum) {
				sum += (nextNum - curNum);
				i++;
			}
			else 
				sum += curNum;
		}
		
		
		return sum;
	}
	
	//convers tthe character to the numeric value
	public int getVal(char c) {
		int value;
		
		switch(c) {
			case 'I':
			case 'i':
				value = 1;
				break;
			case 'V':
			case 'v':
				value = 5;
				break;
			case 'X':
			case 'x':
				value = 10;
				break;
			case 'L':
			case 'l':
				value = 50;
				break;
			case 'C':
			case 'c':
				value = 100;
				break;
			case 'D':
			case 'd':
				value = 500;
				break;
			case 'M':
			case 'm':
				value = 1000;
			default:
				value = -1;
		}
		
		return value;
	}
	
	public void usage(GuildMessageReceivedEvent event) {
		event.getChannel().sendMessage("```!roman romanNumeral```").queue();
		event.getChannel().sendMessage("example: ```!roman XXII```").queue();
	}
}
