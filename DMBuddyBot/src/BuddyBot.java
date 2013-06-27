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
    
    
    //Method to roll an "honest" stat Char. User can specify the number of times they would like the dice rolled.
    //Current method will only work correctly with 3d6 variant, need to add RollDrop method for 4d6 variant. Once this change is made add a check for the value of times.
    public void honestChar(int times, String channel){
    	
    	Dice dice = new Dice(6);
    	sendMessage(channel, "Strength: " + dice.Roll(3));
    	sendMessage(channel, "Dexterity: " + dice.Roll(3));
    	sendMessage(channel, "Constitution: " + dice.Roll(3));
    	sendMessage(channel, "Wisdom: " + dice.Roll(3));
    	sendMessage(channel, "Intelligence: " + dice.Roll(3));
    	sendMessage(channel, "Charisma: " + dice.Roll(3));
    	
    }
    
    
}