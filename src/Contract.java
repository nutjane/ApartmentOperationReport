
public class Contract {
	private int contractNO;
	private int roomNO;
	private String ternantID1;
	private String ternantID2;
	private String ternantID3;
	private String checkInDate;
	private String checkOutDate;
	
	
	//set a constructor
	public Contract(int contractNo, int roomNO, String ternantID1, String ternantID2, String ternantID3, String checkInDate, String checkOutDate){
		this.contractNO = contractNo;
		this.roomNO = roomNO;
		this.ternantID1 = ternantID1;
		this.ternantID2 = ternantID2;
		this.ternantID3 = ternantID3;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	
	public int getContractNO(){return this.contractNO;}
	public int getRoomNO() {return this.roomNO;}
	public String getTernantID1() {return this.ternantID1;}
	public String getTernantID2() {return this.ternantID2;}
	public String getTernantID3() {return this.ternantID3;}
	public String getCheckInDate() {return this.checkInDate;}
	public String getCheckOutDate() {return this.checkOutDate;}

}
