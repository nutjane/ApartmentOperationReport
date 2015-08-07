
public class Ternant {
	private int ternantID;
	private String firstName;
	private String lastName;
	private String gender;
	private String birthDay;
	
	//set a constructor
	public Ternant(int ternantID, String firstName, String lastName, String gender, String birthDay){
		this.ternantID = ternantID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDay = birthDay;
	}
	
	public int getTernantID(){ return this.ternantID;}
	public String getFirstName(){ return this.firstName;}
	public String getLastName(){ return this.lastName;}
	public String getGender() { return this.gender;}
	public String getBirthDay() { return this.birthDay;}

}
