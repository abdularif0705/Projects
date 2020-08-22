public class NimPlayers {
	
	private String Player1;
	private String Player2;
	
	public NimPlayers(String Player1)
	{
		this.Player1 = Player1;
	}
	
	public NimPlayers(String Player1, String Player2)
	{
		this.Player1 = Player1;
		this.Player2 = Player2;
	}
	
	public String getPlayer1()
	{
		return Player1;
	}
	
	public String getPlayer2()
	{
		return Player2;
	}

}
