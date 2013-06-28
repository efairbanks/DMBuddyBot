
public class IrcUserSession
{

	enum BotState { DefaultState, SayingHelloState, MimicingState };
	
	public IrcUserSession(String username)
	{
		this.userName = username;
		this.isAddressingBot = false;
		this.botState = BotState.DefaultState;
	}
	
	public String userName;
	
	public Boolean isAddressingBot;
	
	public BotState botState;
	
}
