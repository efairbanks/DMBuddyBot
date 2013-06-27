import org.jibble.pircbot.*;



public class BuddyBot extends PircBot {

    public BuddyBot() {

        this.setName("DMBuddyBot");

    }

    public void onMessage(String channel, String sender,

                       String login, String hostname, String message) {
        
        if (message.equalsIgnoreCase("roll")) {

        	Dice d6 = new Dice(20);
        	sendMessage(channel, "Ok " + sender + "! The number I rolled for you is " + d6.Roll(1));

        }
        if (message.equalsIgnoreCase("GTFO")) {

        	sendMessage(channel, "Sick of your shit anyway. Roll your own fucking dice.");
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	quitServer();

        }

    }

}