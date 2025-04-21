
/*******************************************************************************************************************************
 * File Name:        CSVWriter.java
 * Author:           Naveen Fernando (CURTIN ID:21765018)
 * Date:             8th October 2023
 * 
 * Description:      The CSVWriter class is part of the FIFA Women's World Cup Data Management System. This class is responsible 
 *                   for writing team data to a CSV file. It takes the team data stored in the teamsArray and exports it to a CSV 
 *                   file. This file can then be used for data analysis or sharing.
 * 
 * Purpose:          The main purpose of this class is to provide a convenient way to export team data in a CSV format. Users can 
 *                   specify the name of the CSV file they want to create. The class handles file creation, header writing, and 
 *                   data export.
 * 
 * Important Notes:  - This class requires an array of Team objects (teamsArray) to function. It should be instantiated with a 
 *                     valid teamsArray.
 *                   - The class allows users to specify the name of the CSV file, and it checks for file name conflicts to avoid 
 *                     overwriting existing files.
 * REQUIRES:          This class makes use of the Team class from the Objects package.
 * 
 * Information on the file: This class is stored in the Managers package.
 * 
 *                   
 *******************************************************************************************************************************/

package Managers;

import Objects.Team;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVWriter 
{
    // Define an array to store Team objects
    Team[] teamsArray;
    // Create a Scanner object for user input
    Scanner input = new Scanner(System.in);

    // Constructor: CSVWriter
    // Purpose: Initializes an instance of the CSVWriter class with a Team array.
    // Imports: Team[] teamsArray (array of Team objects)
    // Exports: None
    // Assertions:
    //     Pre: None
    //     Post: A CSVWriter instance is created and associated with the provided Team array.
    // Remarks: The constructor allows the CSVWriter class to work with a specific array of Team objects for writing data to CSV files.
    public CSVWriter(Team[] teamsArray)
    {
        this.teamsArray = teamsArray;
    }
    

    // Method: writeInToCSVFile
    // Purpose: Writes the team data to a CSV file based on user input.
    // Imports: None
    // Exports: None
    // Assertions:
    //     Pre: None
    //     Post: Team data is written to a CSV file. Handles file name validation.
    // Remarks: Prompts the user for a file name, writes team data to a CSV file, and handles file name validation. 
    public void writeInToCSVFile() 
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw = null;

        while (true) 
        {
            System.out.println("");
            System.out.print("What would you like to name your csv file? (e.g., sample): ");

            String fileNameFromInput = input.nextLine();
            
            // Check if the user input already contains the .csv extension
            if (!fileNameFromInput.toLowerCase().endsWith(".csv")) 
            {
                fileNameFromInput += ".csv"; // Add the .csv extension
            }
            try 
            {
                // Check if the file already exists
                File file = new File(fileNameFromInput);
                if (file.exists()) 
                {
                    System.out.println("File '" + fileNameFromInput + "' already exists. Please choose a different name.");
                    continue; // Continue the loop to prompt for a new file name
                }
                // Create a FileOutputStream to write data to a CSV file
                fileStrm = new FileOutputStream(fileNameFromInput, true);

                // Create a PrintWriter to write formatted text to the FileOutputStream
                pw = new PrintWriter(fileStrm);

                // Print CSV headers
                pw.println("Team Name, Team Code, Goals For, Goals Against, Group");

                // Iterate through teams and print data
                for (Team team : teamsArray) 
                {
                    if (team != null) 
                    {
                        pw.println(team.getTeamName() + "," + team.getTeamCode() + "," +
                                team.getScoresFor() + "," + team.getScoresAgainst() + "," + team.getGroup());
                    }
                }  
                System.out.println("");
                System.out.println("Data has been successfully written to " + fileNameFromInput);
                System.out.println("");
                System.out.println("Thank you and have a great day.");
                break; // Exit the loop if the file is successfully created

            } 
            catch (Exception e) // Try block to catch exceptions that may occur while writing to the file
            {
                System.out.println("Error in writing to file: " + e.getMessage());
                break; // Exit the loop in case of an error
            } 
            // Finally block ensures that the file stream and print writer are closed, whether or not an exception occurs
            finally 
            {
                try 
                {
                    if (pw != null) 
                    {
                        pw.close();
                    } 
                    if (fileStrm != null) 
                    {
                        fileStrm.close();
                    }
                } 
                catch (Exception e) 
                {
                    System.out.println("Error in closing file: " + e.getMessage());
                }
            }
        }
    }
}
