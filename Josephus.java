package CircularLinkedList;

public class Josephus {

	private int numOfPeople;
	private int countNum;
	private Node head;
	private Node tail;
	CircularLinkedList circle;

	public Josephus() {

		circle = new CircularLinkedList();
		numOfPeople = 0;
		countNum = 0;
	}

	public void setNumOfPeople(int x) {
		numOfPeople = x;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setCountNum(int x) {
		countNum = x;
	}

	public int getCountNum() {
		return countNum;
	}

	public void addPeople() {
		for (int i = 1; i < numOfPeople; i++) {
			circle.insert(i);
		}
	}

	public void move() {
		for (int i = 0; i < countNum; i++) {
			tail = head;
			head = head.next;
		}
		System.out.println("Killed : " + head.iData);
	}

	public void execute() {
		tail = null;
		head = circle.getFirst();
		while (numOfPeople != 2) {
			move();
			circle.delete(head.iData);
			tail = tail.next;
			head = head.next;
			numOfPeople--;
			display();
		}
	}

	public void display() {
		System.out.println("Alive : ");
		circle.displayList();
	}

}
