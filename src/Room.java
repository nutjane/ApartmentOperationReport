
public class Room  {
	private int roomNO;
	private String roomType;
	private double roomPrice;
	
	//set a constructor
	public Room(int roomNO, String roomType, double roomPrice){
		this.roomNO = roomNO;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
	}
	
	public int getRoomNO(){
		return this.roomNO;
	}
	
	public String getRoomType() {
		return this.roomType;
	}
	
	public double getRoomPrice(){
		return this.roomPrice;
	}
	

}
