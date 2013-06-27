import java.util.Arrays;

import org.jibble.pircbot.*;



public class BuddyBot extends PircBot {

    public BuddyBot(String Name) {

        this.setName(Name);

    }
    
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        
        if (message.equalsIgnoreCase("roll")) {

        	Dice d6 = new Dice(20);
        	sendMessage(channel, "Ok " + sender + "! The number I rolled for you is " + d6.Roll(1));

        }
        
        if (message.startsWith("roll a ")) {
        	
        	sendMessage(channel, "And your total roll is..."   );
        	
        	try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
        	sendMessage(channel, Roll(Integer.parseInt( message.substring(7,8) ), Integer.parseInt( message.substring(9,10) ) ) );

        }
        
        if (message.equalsIgnoreCase("Roll Honest Character 3d6")){
        	honestChar(3, channel);
        }
        
        if (message.equalsIgnoreCase("Roll Honest Character 4d6")){
        	honestChar(4, channel);
        }
        
        if (message.equalsIgnoreCase("GTFO")) {

        	sendMessage(channel, "Fine, I'm sick of your shit anyway. Roll your own fucking dice.");
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	quitServer();

        }

    }

    public void onPrivateMessage(String channel, String sender, String login, String hostname, String message) {
    	
    	//This method does not seem to be triggering correctly.
        if (message.startsWith("roll a ")) {
        	
        	sendMessage(sender, "You rolled a" + message.substring(7,10) + "and got " +  Roll(Integer.parseInt( message.substring(7,8) ), Integer.parseInt( message.substring(9,10) ) ) + "." );

        }
    }
    
    public String Roll(int times, int sides){
    	
    	Dice dice = new Dice(sides);
    	
    	return Integer.toString( dice.Roll(times) );	
    	
    }
    
    public int rollDrop(){

    	int sum = 0;
    	int[] Rolls = new int[4];
		Dice dice = new Dice(6);

		for (int i = 0; i < 4; i++){

			Rolls[i]=dice.Roll(1);

		}

		Arrays.sort(Rolls);
		Rolls[0]=0;

		for (int i = 0; i < 4; i++){

			sum += Rolls[i];

		}

    	return sum;

    }
    
    //Method to roll an "honest" stat Char. User can specify the number of times they would like the dice rolled.
    //Current method will only work correctly with 3d6 variant, need to add RollDrop method for 4d6 variant. Once this change is made add a check for the value of times.
    //In the future may include the arguement String sender. Could then save the character in a text file with the name of the sender. Check to see if previous file exists.
    //Could also allow "roll honest character 3d6 Dunkster" call, with "Dunkster" being the name of the file (substring(27, (message.length()-1))
    public void honestChar(int times, String channel){
    	
    	if (times == 3){
    		
    		sendMessage(channel, "Hey, I made you a guy! I think I'll call him Spike... Check it out!");
    		Dice dice = new Dice(6);
    		sendMessage(channel, "Strength: " + dice.Roll(3));
    		sendMessage(channel, "Dexterity: " + dice.Roll(3));
    		sendMessage(channel, "Constitution: " + dice.Roll(3));
    		sendMessage(channel, "Wisdom: " + dice.Roll(3));
    		sendMessage(channel, "Intelligence: " + dice.Roll(3));
    		sendMessage(channel, "Charisma: " + dice.Roll(3));
    		
    	}
    	
    	else if (times ==4){
    		
    		sendMessage(channel, "So I made your guy. I hope you like him. I think I'ma call him Timmy...");
    		sendMessage(channel, "Strength: " + rollDrop());
    		sendMessage(channel, "Dexterity: " + rollDrop());
    		sendMessage(channel, "Constitution: " + rollDrop());
    		sendMessage(channel, "Wisdom: " + rollDrop());
    		sendMessage(channel, "Intelligence: " + rollDrop());
    		sendMessage(channel, "Charisma: " + rollDrop());
    		
    	}
    }
    
    
    
}