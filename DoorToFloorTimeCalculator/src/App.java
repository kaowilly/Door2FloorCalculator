/*
 * Door to Floor Time Calculator
 * 
 * Created by Willy Kao on 2020-07-20.
 * Last modified: 2020-10-21.
 * Copyright © 2020 Willy Kao. All rights reserved.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import controller.Controller;
import model.Model;
import view.View;

public class App {
	public static void main(String[] args) {

		// Assemble all the pieces of the MVC
		Model m = new Model();
		View v = new View("Door to Floor Time Calculator for TJX Canada - Winners 257");
		Controller c = new Controller(m, v);
		c.initController();
		
		
		//This code works for creating a .txt file
		/*
		try {
			// Our example data
			List<List<String>> rows = Arrays.asList(
			    Arrays.asList("Jean", "author", "Java"),
			    Arrays.asList("David", "editor", "Python"),
			    Arrays.asList("Scott", "editor", "Node.js")
			);
			
			String userHomeFolder = System.getProperty("user.home");
			File textFile = new File(userHomeFolder + "\\Desktop\\", "myCreatedFile.txt");
			BufferedWriter csvWriter = new BufferedWriter(new FileWriter(textFile));
			csvWriter.append("Name");
			csvWriter.append(",");
			csvWriter.append("Role");
			csvWriter.append(",");
			csvWriter.append("Topic");
			csvWriter.append("\n");

			for (List<String> rowData : rows) {
			    csvWriter.append(String.join(",", rowData));
			    csvWriter.append("\n");
			}

			csvWriter.flush();
			csvWriter.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}
