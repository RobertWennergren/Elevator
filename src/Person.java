import java.util.Random;

public class Person{
		
		public enum statusPerson{
			IDLE, ACTIVE, RIDING
		
		}
		
		Random random = new Random(); 
		
		statusPerson statusP;
		int floor, movingToFloor;
		static int id = 0;
		int elevatorPosition;
			
		Person(){
			
			id = ++id;
			this.statusP = statusPerson.IDLE;
			this.floor = 0;
			this.movingToFloor = 1;			
			
		}
		
		void goToFloor(){
			//this.movingToFloor = 2;
			this.movingToFloor = random.nextInt(50);
			this.statusP = statusPerson.ACTIVE;
		}
		
		void getStatus(){		
			if(floor == movingToFloor)
				System.out.println("Person: " + this.id + " is on floor: " + this.floor + " and is not heading anywhere");
			else
				System.out.println("Person: " + this.id + " is on floor: " + this.floor + " and is heading towards: " + this.movingToFloor);		
		}
		
		void callElevator(Elevator<?> elevator){
			elevator.floor = this.floor;		
		}
		
		void enterElevator(Elevator<?> elevator) throws InterruptedException{
			if(elevator.space[0] == null){
				elevator.space[0] = this;
				elevatorPosition = 0;
				elevator.queue.add(this.movingToFloor);
				//if(!elevator.checkLeaving())
				//elevator.gettingReady();
				return;
			}
			if(elevator.space[1] == null){
				elevator.space[1] = this;
				elevatorPosition = 1;
				elevator.queue.add(this.movingToFloor);
				//if(!elevator.checkLeaving())
				//elevator.gettingReady();
			}
		}
		
		void leaveElevator(Elevator<?> elevator){
			if(elevator.floor == this.movingToFloor){
				System.out.println("Person " + this.id + " has reached his destination");
				elevator.space[this.elevatorPosition] = null;
				this.floor = this.movingToFloor;
				this.getStatus();
				elevator.queue.poll();
			}		
		}
		
		boolean checkIdle(){
			
			return this.statusP == statusPerson.IDLE;
		}
		
		boolean checkActive(){
			
			return this.statusP == statusPerson.ACTIVE;
		}
		
		boolean checkReachedDestination(Elevator<?> elevator){
			
			return elevator.floor == this.movingToFloor;
		}
		
		void status(){
			
			System.out.println("Person: " + this.id + " is on floor " + this.floor + " and is heading towards " + this.movingToFloor);
			
		}
		
	}