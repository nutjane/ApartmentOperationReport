
import java.io.*;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RoomCollection {
	List<Room> roomCollection = new ArrayList<Room>();

	public RoomCollection(){
		this.ReadFile();

	}
	
	//read file and split it with Tokenizer 
	public void ReadFile(){
		File fileToRead = new File("rooms.txt");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(fileToRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner read = new Scanner(fileReader);
		while (read.hasNext()==true) {
			String data = read.nextLine();
			StringTokenizer token = new StringTokenizer(data,",");
			this.roomCollection.add(new Room(Integer.parseInt(token.nextToken()), token.nextToken(), Double.parseDouble(token.nextToken())));
		}
		}
	
}


