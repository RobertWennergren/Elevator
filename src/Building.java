import java.util.ArrayList;


public class Building {
	
	Elevator<?> elevator;
	ArrayList<Person> visitors = new ArrayList<Person>();
	
	public Building(){
		
		this.elevator = new Elevator<Integer>();
			
	}
	
	void addVisitor(){
		visitors.add(new Person());	
	}
	
	void setDestinations() throws InterruptedException{
		for(Person v : visitors){
			System.out.println("Person " + v.id + " is " + v.statusP);
		if(v.checkIdle()){
			v.goToFloor();
			v.callElevator(this.elevator);
			v.enterElevator(this.elevator);
			v.getStatus();
			this.elevator.gettingReady();
			this.elevator.move();
			}
		}
	}
	
	void checkReachedDestination(){
		for(Person v : visitors)
			if(v.checkReachedDestination(this.elevator)){
				v.leaveElevator(this.elevator);
				v.getStatus();
				
				removeVisitor(v);
				return;
			}
		
	}
	
	void removeVisitor(Person v){
		visitors.remove(v);
	}
	
	void allStatus(){
		
		this.elevator.status();
		for(Person v : visitors)
			v.status();
		
	}

}
