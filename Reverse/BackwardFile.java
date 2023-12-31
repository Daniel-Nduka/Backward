// A code to reverse the characters of a txt file
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.io.BufferedWriter;
import java.util.Scanner;

public class BackwardFile {
    public static void main(String[] args) {
    	
    	System.out.println("Choose a txt file from the down menu");
    	Scanner s = new Scanner (System.in);
    	//Create an array of 1000 
        char[] charArray = new char[1000];
        int wordCount = 0;
        
        boolean useJFileChooser = true;
        
        try {
        	FileReader fr = null;
        	if(useJFileChooser) {
        		JFileChooser fileChooser = new JFileChooser();
        		int returnVal = fileChooser.showOpenDialog(new JFrame());
        		fr = new FileReader(fileChooser.getSelectedFile());
        	}
        	else {
        		System.out.println("Alternatively, copy and past the location of your file here ");
        		String txt = s.nextLine();
        		fr = new FileReader(txt);
        	}
            int character;

            
            //use an loop to read every character 
            while (true) {
                character = fr.read();
                //End loop when the you reach the end of the file
                if (character == -1) {
                    break;
                }
                //convert the int to char and store them in an array
                charArray[wordCount] = (char) character;
                wordCount++;
            }
            //close file
            //close
            fr.close();
            //print out out an error if the file couldnt be found or closed.
        } catch (IOException e) {
            System.out.println("Couldn't find file or close file");
        }

        //Create a new Array use a loop to reverse the characters in the array
        char[] newArray = new char[wordCount];
        for (int i = wordCount - 1, j = 0; i >= 0; i--, j++) {
            newArray[j] = charArray[i];
        }

        try {
        	//Write into a new file
            FileWriter fw = new FileWriter("/Users/ndukaofoeyeno/Downloads/forward.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < newArray.length; i++) {
                bw.write(newArray[i]); // Write each character individually
            }

            //close writers
            bw.close();
            fw.close();
            
            //catch error and print a stack if the file couldn't be written
        } catch (IOException e) {
        	System.out.println("Couldn't write or close file writer");
            e.printStackTrace();
        }
    }
}
