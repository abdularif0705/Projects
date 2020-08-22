public class NimGameMode {
	
	
	private boolean PvP = false;// Changes the game mode from PvP to PvAI
	
	public NimGameMode(boolean PvP)
	{
		this.PvP = PvP;
	}
	
	
	public void setPvP(boolean PvP)
	{
		this.PvP = PvP;
	}
	
	
	public boolean getPvP()
	{
		return this.PvP;
	}
}
