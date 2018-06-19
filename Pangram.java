import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class pangram {



public static void pangram(String input, String output){
	// TODO Auto-generated method stub
	String line = null;
	 try {
         FileReader fileReader =  new FileReader(input);
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(output);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

         try {
        	 while((line = bufferedReader.readLine()) != null) {
        		 int[] pangram = new int[26];
        		 int count = 0;
        		 for(int i=0; i<line.length(); i++){
        		 	if(line.charAt(i)>=65 && line.charAt(i)<=90){
        		 		if(pangram[line.charAt(i)-65]==0)
        		 			count++;
        		 		pangram[line.charAt(i)-65]++;
        		 	}
        		 	else if(line.charAt(i)>=97 && line.charAt(i)<=122){
        		 		if(pangram[line.charAt(i)-97]==0)
        		 			count++;
        		 		pangram[line.charAt(i)-97]++;
        		 	}
        		 }
        		 if(count==26)
        			 bufferedWriter.write("true"+"\r\n");
        		 else
        			 bufferedWriter.write("false"+"\r\n");
        		 }
        	 bufferedWriter.close();
        	 
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

         // Always close files.
         try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         
     }
     catch(FileNotFoundException ex) {
         System.out.println(
             "Unable to open file '" + 
             input + "'");                

 }
}

	
}
	
