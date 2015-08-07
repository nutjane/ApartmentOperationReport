import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Fee {
	private double electricityFee;
	private double waterFee;
	private double internetFee;
	
	
	public Fee(){
		this.ReadFile();
	}
	
	//read file and split it 
			public void ReadFile(){
				File fileToRead = new File("fees.txt");
				FileReader fileReader = null;
				try {
					fileReader = new FileReader(fileToRead);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				Scanner read = new Scanner(fileReader);
			//	while (read.hasNext()==true) {
					this.electricityFee = Double.parseDouble(read.nextLine());
					this.waterFee = Double.parseDouble(read.nextLine());
					this.internetFee = Double.parseDouble(read.nextLine());
					
				}
		
	public double getElectricFee() {return this.electricityFee;}
	public double getWaterFee() {return this.waterFee;}
	public double getInternetFee() {return this.internetFee;}

}
