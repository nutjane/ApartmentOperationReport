import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ContractCollection {
	
	List<Contract> contractCollection = new ArrayList<Contract>();
	
	public ContractCollection(){
		this.ReadFile();
		
	}

	//read file and split it with Tokenizer 
	public void ReadFile(){
	 
				File fileToRead = new File("contracts.txt");
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
					this.contractCollection.add(new Contract(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()),token.nextToken(),token.nextToken(),
							token.nextToken(),token.nextToken(),token.nextToken()));
				}
				}
	}
