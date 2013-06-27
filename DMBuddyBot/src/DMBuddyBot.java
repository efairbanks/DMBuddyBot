import org.jibble.pircbot.*;



public class DMBuddyBot {

    public static void main(String[] args) throws Exception {

        BuddyBot bot = new BuddyBot("DMBuddyBot");
        bot.setVerbose(true);
        bot.connect("localhost");
        bot.joinChannel("#CoC");

        

    }

    

}