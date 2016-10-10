
public class Main {

	
	public static void main(String[] args) throws InterruptedException{
		
		Building building = new Building();
		int i = 0;
		
		
		while(i < 10){
			i++;
			building.addVisitor();
			building.setDestinations();
			building.checkReachedDestination();
		}
		
	}
	
}
