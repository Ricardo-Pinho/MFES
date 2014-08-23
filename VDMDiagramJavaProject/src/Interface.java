import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Interface{
    public String[] mainInterface = {"1. Actor", "2. Object", "3. Message", "4. Gate", "5. Fragment"};
    public String[] secundaryInterface = {"1. New", "2. Edit", "3. Delete"};

    public void interfaceCycle(){
	while(true){
	    printMainInterface();
	    
	    System.out.print("Select your option: ");
	    String option = "";
	    InputStreamReader input = new InputStreamReader(System.in);
	    BufferedReader reader = new BufferedReader(input);
	    
	    try{
		option = reader.readLine();
	    }
	    catch(Exception e){
		
	    }
	    
//	    if()
	}
    }

    public void printMainInterface(){
	for(String option : mainInterface)
	    System.out.println(option);
    }

    public void printSecundaryInterface(){
	for(String option : secundaryInterface)
	    System.out.println(option);
    }
}