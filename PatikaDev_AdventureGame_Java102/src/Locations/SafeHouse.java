package Locations;
public class SafeHouse extends Location{

	public SafeHouse(int ID, String Name) {
		super(ID, Name, null);
	}
    @Override
    public void InAction() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Player.RegenHealth();
        Player.ShowProperties();
        System.out.println("[Exit]> 0");
    }
}
