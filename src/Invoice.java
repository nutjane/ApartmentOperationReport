
public class Invoice {
	private int contractNO;
	private int month; //month that issue this invoice
	private int year;  //year that issue this invoice 
	private double electricUsed;
	private double waterUsed;
	private String datePaid; // the payment date will be at the beginning of the following months
	
	public Invoice(int contractNO, int month, int year, double electricUsed, double waterUsed, String datePaid){
		this.contractNO = contractNO;
		this.month = month;
		this.year = year;
		this.electricUsed = electricUsed;
		this.waterUsed = waterUsed;
		this.datePaid = datePaid;
	}
	
	public int getContractNO() {return this.contractNO;}
	public int getMonth() {return this.month;}
	public int getYear() {return this.year;}
	public double getElectricUsed() {return this.electricUsed;}
	public double getWaterUsed() {return this.waterUsed;}
	public String getDatePaid() {return this.datePaid;}
}
