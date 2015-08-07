import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TernantCollection  {
	List<Ternant> ternantCollection = new ArrayList<Ternant>();

	public TernantCollection(){
		this.ReadFile();
	}
	
	//read file and split it with Tokenizer 
		public void ReadFile(){
			File fileToRead = new File("ternants.txt");
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
				this.ternantCollection.add(new Ternant(Integer.parseInt(token.nextToken()),token.nextToken(),token.nextToken(), 
						token.nextToken(),token.nextToken()));
			}
			}
	
}
