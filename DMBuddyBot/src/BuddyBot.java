import org.jibble.pircbot.*;



public class BuddyBot extends PircBot {

    public BuddyBot(String Name) {

        this.setName(Name);

    }

    public void onJoin(String channel, String sender, String login, String hostname){
    	
    	sendMessage(channel, "Sup Mothafucka?!");
    	
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
    	
        if (message.startsWith("roll a ")) {
        	
        	sendMessage(sender, "And your total roll is..."   );
        	
        	try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
        	sendMessage(sender, Roll(Integer.parseInt( message.substring(7,8) ), Integer.parseInt( message.substring(9,10) ) ) );

        }
    }
    
    public String Roll(int side, int times){
    	
    	Dice dice = new Dice(side);
    	
    	return Integer.toString( dice.Roll(times) );	
    	
    }
    
    public static Integer tryParse(String text) {
    	  try {
    	    return new Integer(text);
    	  } catch (NumberFormatException e) {
    	    return null;
    	  }
    	}
    
}