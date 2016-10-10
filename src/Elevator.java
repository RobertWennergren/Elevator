import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;

public class Elevator<E> implements Queue<E> {

	public static enum statusElevator{
		MOVING, EMPTY, LEAVING
	
	}

	Person[] space;
	int floor;
	int id = 0;
	statusElevator statusE;
	Queue<Integer> queue = new LinkedList<Integer>();
	Timer waiting = new Timer();
		
	public Elevator(){
		
		this.id = id++;
		this.space = new Person[2];
		this.floor = 0;
		this.statusE = statusElevator.EMPTY;
		
	}
	
	void move() throws InterruptedException{
		this.statusE = statusElevator.MOVING;
		//waiting.wait(1000);
		this.floor = queue.poll();
		System.out.println("Elevator " + this.id + " has arrived at floor " + this.floor);
	}
	
	void gettingReady() throws InterruptedException{
		this.statusE = statusElevator.LEAVING;
		System.out.println("Elevator " + this.id + " is getting ready to leave " + this.floor);
		//waiting.wait(1000);	
	}
	
	boolean checkLeaving(){
		return this.statusE == statusElevator.LEAVING;
	}
	
	int readQueue(){
		
		return queue.peek();
		
	}
	
	void status(){
		System.out.println("Elevator: " + this.id + " is at " + this.floor + " and is moving to " + queue.peek() );
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

}

