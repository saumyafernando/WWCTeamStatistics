/******************************************************************************************************************
 * File Name:      DataAnalysisApp.java
 * Author:         Naveen Fernando (CURTIN ID: 21765018)
 * Date:           9th October 2023
 * 
 * Description:    DataAnalysisApp is a Java program designed to analyse FIFA Women's World Cup data
 *                 from a CSV file. The program offers users the ability to perform both overall analysis
 *                 and group analysis of teams, providing insights based on various statistics, including
 *                 net goals, total goals scored against them, and total goals scored.
 * 
 * Purpose:        - Read team data from a CSV file.
 *                 - Allow users to choose between overall analysis and group analysis.
 *                 - Perform sorting and analysis on team data.
 *                 - Display relevant statistics and insights.
 * 
 * Important Notes: The CSV file must adhere to a specific format: Team Name, Team Code, Goals For,
 *                  Goals Against, and Group.
 * REQUIRES: This class makes use of the Analyzer class and CSVreader class from the Managers package and Team class from Objects package.
 ****************************************************************************************************************/




import java.util.Scanner;
import Managers.Analyzer;
import Managers.CSVReader;
import Objects.Team;
import java.io.FileNotFoundException;
import java.io.IOException;



public class DataAnalysisApp 
{
    // Method: main
    // Purpose: The main entry point of the program. Manages user interactions for analyzing FIFA Women's World Cup data.
    // Imports: String[] args (command line arguments)
    // Exports: None
    // Assertions:
    //     Pre: None
    //     Post: The program runs, analyzes team data, and handles user interactions.
    // Remarks: None
    public static void main(String[] args) 
    {
        Team[] teamsArray; // Array to store team data

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Welcome to the FIFA WWC Data Analysing Program\n "); 

        
        String fileNameFromInput;

        while (true) 
        {
            
            // Ask the user to enter the file name
            System.out.print("Enter the name of the file containing the data (e.g., sample.csv ): ");
            fileNameFromInput = scanner.nextLine();
            
            // Check if the user input already contains the .csv extension
            if (!fileNameFromInput.toLowerCase().endsWith(".csv"))
            {
                fileNameFromInput += ".csv"; // Add the .csv extension
            }
            
            String filePath = "/Users/saumyafernando/Desktop/Curtin/1st Sem Y1/PDI /PDIAssignment/WWCTeamStatistics/" + fileNameFromInput; // file path
            
            try 
            {
                // Attempt to read data from the CSV file using the CSVReader class
                teamsArray = CSVReader.readDataFromCSV(filePath);
                break;
            }

            catch (FileNotFoundException e) 
            {
                // Display an error message if the file is not found
                System.out.println("Error: The specified file was not found. Please enter a valid file name.");
            } 
            catch (IOException e) 
            {
                // Display an error message if an I/O error occurs during file reading
                System.out.println("Error: An I/O error occurred while reading the file. Please try again.");
            }
        }
        System.out.println("");//empty line
       
        do
        {

            int choice = 0;
            do 
            { 
                // Prompt the user for overall analysis or group analysis
                System.out.println("An overall analysis or a group analysis?");
                System.out.println("1. Overall Analysis");
                System.out.println("2. Group Analysis");
        
                try 
                {
                    choice = Integer.parseInt(scanner.nextLine());// Attempt to parse the user's input as an integer
                    System.out.println("");//empty line
                }
                catch (NumberFormatException e) 
                {
                    System.out.println("Invalid choice. Please enter 1 or 2.");/*If the input cannot be parsed as an integer,
                     this exception is caught Print an error message to inform the user that their input is invalid*/
                    continue; // Continue to the next iteration of the loop
                }
                switch (choice) 
                {
                    
                    case 1:
                        // Call the performOverallAnalysis method from the Analyzer class to perform overall analysis
                        Analyzer.performOverallAnalysis(teamsArray);
                        break;
                    case 2:
                        // Call the performGroupAnalysis method from the Analyzer class to perform group analysis
                        Analyzer.performGroupAnalysis(teamsArray, scanner);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } while (choice != 1 && choice != 2);// Continue looping as long as the user's choice is not 1 (for overall analysis) and not 2 (for group analysis).
         
            String exitChoice;
            do
            {  
                System.out.print("Would you like to exit? (Y/N): ");// Ask if the user wants to exit the program
                exitChoice = scanner.nextLine().toUpperCase(); // Convert input to uppercase
                System.out.println("");
        
                switch(exitChoice)
                {
                    case "Y":
                    // Exiting program
                    System.out.println("Exiting the program...\n\nThank you and have a great day\n");
                        scanner.close();  // Close the Scanner
                        return;

                    
                    case "N":
                        break;// Continue the program

                    default:
                        System.out.println("Invalid choice. Please enter 'Y' or 'N'.");
                        break;
                }

            } while (!exitChoice.equals("N")); // Continue the loop until a valid choice ('Y' or 'N') is made

        } while(true);
    }
}





















