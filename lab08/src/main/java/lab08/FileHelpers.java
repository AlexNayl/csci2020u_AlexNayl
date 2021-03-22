package lab08;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A collection of load and save functions for arrays of student records
 */
public class FileHelpers {

	/**
	 * saves a student record list to disk as a csv file
	 * @param file target file to be created or overwritten
	 * @param data list of student records to be saved
	 * @return True if write successful, false otherwise
	 */
	public static boolean save( File file, List<StudentRecord> data){
		try{
			PrintWriter output = new PrintWriter( file );
			for ( StudentRecord student :data ) {
				String line = student.getStudentID() + ",";
				line += student.getAssignments() + ",";
				line += student.getMidterm() + ",";
				line += student.getFinalExam();

				output.println(line);
			}
			output.close();
			return true;
		}catch ( Exception e ){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * opens a student record list from disk in csv format
	 * @param file target file to be read
	 * @return list of student records, null if read fails
	 */
	public static List<StudentRecord> open(File file){
		try{

			List<StudentRecord> results = new ArrayList<>();
			Scanner scanner = new Scanner( file );
			scanner.useDelimiter( "\n" );

			while(scanner.hasNext()){
				//For each line of the file
				String line = scanner.next();
				String[] lineItems = line.split( "," );
				if(lineItems.length >= 4){
					//Prevents empty lines from messing it up
					StudentRecord student = new StudentRecord( lineItems[0], Double.parseDouble( lineItems[1] ),
							Double.parseDouble( lineItems[2]), Double.parseDouble( lineItems[3] ) );
					results.add(student);
				}
			}

			return results;

		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
