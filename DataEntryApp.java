/*******************************************************************************************************************************
 * File Name:        DataEntryApp.java
 * Author:           Naveen Fernando (CURTIN ID:21765018)
 * Date:             8th October 2023
 * 
 * Description:      The DataEntryApp class serves as the entry point for the FIFA Women's World Cup team management program. This class coordinates the
 *                   flow of the program and interacts with the UserManager and Team classes.
 * 
 * Purpose:          The primary purpose of this class is to offer users a seamless experience for managing and analyzing
 *                   team data. It directs user interactions, making the program user-friendly and intuitive. It also allows users to continue adding more data, display the current team 
 *                   data, and write the data to a CSV file.
 * 
 * Important Notes: None
 * REQUIRES: This class makes use of the UserManager class and CSVWriter class from the Managers package and Team class from Objects package.
 * 
 *******************************************************************************************************************************/

import java.util.Scanner;

import Managers.CSVWriter;
import Managers.UserManager;
import Objects.Team;

public class DataEntryApp 
{
    
  // Method: main
  // Purpose: The main entry point of the program. Manages user interactions for adding and exporting team data.
  // Imports: String[] args (command line arguments)
  // Exports: None
  // Assertions:
  //     Pre: None
  //     Post: The program runs, manages team data input and export, and handles user interactions.
  // Remarks: None
  public static void main(String[] args) 
  {

    Scanner input = new Scanner(System.in);
    UserManager userManager = new UserManager();  // Create an instance of the UserManager class to manage teams.
    
    System.out.println("");
    System.out.println("Welcome to the FIFA WWC Data Entry Program \n");

  
    // Getting user input for teams.
    userManager.addTeamsFromUserInput(input);
    
    
    boolean state = true;
    String continueInput;
    while (state) 
    {    
      // Asking the user whether to continue adding more teams.
      
      System.out.print("Would you like to enter more data (Y or N)?");
      continueInput = input.nextLine().toUpperCase();

      switch(continueInput)
      {

        case "Y":
          userManager.addNewTeams(input);
          state = true;
          break;

        case "N":
          state = false;
          break;

        default:
          System.out.println("Invalid input. Please enter 'Y' or 'N'.");
          break;

      }
      
    }

    // Retrieve the team array from the user manager.
    Team[] teamArray = userManager.getTeamArray();

    // Create a CSVWriter instance to write data from the 'teamArray'.
    CSVWriter fileWriter = new CSVWriter(teamArray);

    // Displaying the current team data.
    userManager.displayTeams();
    
    // writing to the CSV file.
    fileWriter.writeInToCSVFile();


    // Close the Scanner
    input.close();
  }
}

