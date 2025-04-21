/*******************************************************************************************************************************
 * File Name:        UserManager.java
 * Author:           Naveen Fernando (CURTIN ID:21765018)
 * Date:             8th October 2023
 * 
 * 
 * Description:      The UserManager class is part of the FIFA Women's World Cup Data Management System, which allows users 
 *                   to input, validate, and store data for football teams participating in the FIFA Women's World Cup. 
 *                   It provides functionalities to add new teams and display entered team data.
 * 
 * Purpose:          The purpose of this class is to manage the input and data storage of football teams participating in the 
 *                   FIFA Women's World Cup. It ensures that user inputs are valid, handles potential errors, and offers options
 *                   to manage and analyze team data.
 * 
 * Important Notes:  - This class collaborates with the Team class to create, manage, and display team data.
 *                   - It handles the input of team data, checking for duplicates.
 *                   - Error handling is implemented to maintain data integrity.
 * 
 * REQUIRES:          This class makes use of the Team class from the Objects package.
 * 
 * Information on the file: This class is stored in the Managers package.
 *******************************************************************************************************************************/



package Managers;


import java.util.Arrays;
import java.util.Scanner;
import Objects.Team;

public class UserManager 
{
    private Team[] teamsArray; // Array to store information about football teams


    // Method: addTeamsFromUserInput
    // Purpose: Collects and validates user input to add teams to the teamsArray.
    // Imports: Scanner Input (user input)
    // Exports: None
    // Assertions:
    //     Pre: None
    //     Post: The teamsArray is updated with valid team data, avoiding duplicates.
    // Remarks: Uses user input to determine the number of teams to add, then collects data for each team and checks for duplicates.
    public void addTeamsFromUserInput(Scanner input) 
    {
        int teamCount; // Local variable for this method
        
        while (true) 
        {
            // Prompt the user for the number of teams they want to enter
            System.out.print("How many teams do you want to enter? :");

            if (input.hasNextInt()) 
            {
                teamCount = input.nextInt();

                if (teamCount > 0) 
                {
                    input.nextLine(); // Consume the newline character
                    break; // Input is a positive integer, exit the loop
                } 
                else 
                {
                    System.out.println("Invalid input. Please enter a positive integer. ");
                    input.nextLine(); // Consume the invalid input
                }
            } 
            else 
            {
                System.out.println("Invalid input. Please enter a positive integer. ");
                input.nextLine(); // Consume the invalid input
            }
        }

        // Create an array to store team objects
        teamsArray = new Team[teamCount];

        // Loop to collect data for each team
        for (int i = 0; i < teamCount; i++) 
        {

            // Get valid inputs for a team using the getValidInputs method
            Object[] teamDataFromMethod = getValidInputs(input);
            String teamName = (String) teamDataFromMethod[0];
            String teamCode = (String) teamDataFromMethod[1];
            int scoresFor = (int) teamDataFromMethod[2];
            int scoresAgainst = (int) teamDataFromMethod[3];
            String group = (String) teamDataFromMethod[4];

            // Create a new Team object with the collected data
            Team newTeam = new Team(teamName, teamCode, scoresFor, scoresAgainst, group);

            // Check for duplicate team names or codes
            boolean isDuplicate = false;
            for (Team existingTeam : teamsArray) 
            {
                if (existingTeam != null && (existingTeam.getTeamName().equals(newTeam.getTeamName()) || existingTeam.getTeamCode().equals(newTeam.getTeamCode())))
                {
                    // Checks for duplicates based on both teamName (using .getTeamName()) and teamCode (using .getTeamCode()).
                    // If either the teamName or teamCode matches an existing team, it is considered as a duplicate.
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) 
            {
                System.out.println("Team name or code you entered already exists. Please try entering a different name or code.");
                i--; // Decrement i to re-enter the data for the current team.
            } 
            else 
            {
                teamsArray[i] = newTeam;
                System.out.println("Team data added successfully.");
            }
            System.out.println("");
        }
    }






    // Method: addNewTeams
    // Purpose: Allows the user to add new teams to the teamsArray.
    // Imports: Scanner Input (user input)
    // Exports: None
    // Assertions:
    //     Pre: None
    //     Post: The teamsArray is expanded to include the new teams, avoiding duplicates.
    // Remarks: Similar to addTeamsFromUserInput, but appends new teams to the existing teamsArray.
    public void addNewTeams(Scanner input) 
    {
        System.out.println("");
        int teamCount;
        while (true) 
        {
            // Prompt the user for the number of teams they want to enter
            System.out.print("How many teams do you want to enter? :");

            if (input.hasNextInt()) 
            {
                 teamCount = input.nextInt();

                if (teamCount > 0) 
                {
                    input.nextLine(); // Consume the newline character
                    break; // Input is a positive integer, exit the loop
                } 
                else 
                {
                    System.out.println("Invalid input. Please enter a positive integer. ");
                    input.nextLine(); // Consume the invalid input
                }
            }
             else 
            {
                System.out.println("Invalid input. Please enter a positive integer. ");
                input.nextLine(); // Consume the invalid input
            }
        }

        int currentLength = teamsArray.length;
        Team[] newArray = Arrays.copyOf(teamsArray, currentLength + teamCount);
        // Loop to collect data for each team
        for (int i = 0; i < teamCount; i++) 
        {
            // Get valid inputs for a team using the getValidInputs method
            Object[] teamDataFromMethod = getValidInputs(input);
            String teamName = (String) teamDataFromMethod[0];
            String teamCode = (String) teamDataFromMethod[1];
            int scoresFor = (int) teamDataFromMethod[2];
            int scoresAgainst = (int) teamDataFromMethod[3];
            String group = (String) teamDataFromMethod[4];

            // Create a new Team object with the collected data
            Team newTeam = new Team(teamName, teamCode, scoresFor, scoresAgainst, group);

            // Check for duplicate team names or codes
            boolean isDuplicate = false;
            for (Team existingTeam : teamsArray) 
            {
    
                if (existingTeam != null && (existingTeam.getTeamName().equals(newTeam.getTeamName()) || existingTeam.getTeamCode().equals(newTeam.getTeamCode()))) {
                    // Checks for duplicates based on both teamName (using .getTeamName()) and teamCode (using .getTeamCode()).
                    // If either the teamName or teamCode matches an existing team, it is considered as a duplicate.
                    isDuplicate = true;
                    break;
                }
    
            }
    
            if (isDuplicate) 
            {
                System.out.println("Team name or code you entered already exists. Please try entering a different name or code.");
                i--; // Decrement i to re-enter the data for the current team.
            } 
            else 
            {
                newArray[currentLength + i] = newTeam;
                System.out.println("Team data added successfully.");
            }
            System.out.println("");

        }
        teamsArray = newArray;

    }





    // Method: displayTeams
    // Purpose: Displays the existing team data stored in the teamsArray.
    // Imports: None
    // Exports: None
    // Assertions:
    //     Pre: None
    //     Post: Team data is displayed on the console.
    // Remarks: Loops through the teamsArray and prints team details for each existing team.
    public void displayTeams() 
    {
        System.out.println("");
        System.out.println("The current data looks like this:");
        System.out.println("");

        for (Team team : teamsArray) 
        {

            if (team != null) 
            {
                System.out.println("Team Name: " + team.getTeamName());
                System.out.println("Team Code: " + team.getTeamCode());
                System.out.println("Goals scored by the Team: " + team.getScoresFor());
                System.out.println("Goals Scored Against the Team: " + team.getScoresAgainst());
                System.out.println("Group: " + team.getGroup());
                System.out.println("");
            }

        }

    }




    // Method: getValidInputs
    // Purpose: Collects and validates user input for team data.
    // Imports: Scanner Input (user input)
    // Exports: Object[] containing team data (name, code, scoresFor, scoresAgainst, group)
    // Assertions:
    //     Pre: None
    //     Post: Validated team data is returned.
    // Remarks: Gathers team information such as name, code, scores, and group, validating each input along the way.
    public Object[] getValidInputs (Scanner input)
    {
        System.out.println("");
        String teamName;

        do 
        {
            // Prompt the user to enter the team name in uppercase
            System.out.print("Team Name: ");
            teamName = input.nextLine().toUpperCase(); // Convert to uppercase.

            // Check if the teamName is empty or contains digits
            if (teamName.isEmpty()) 
            {
                System.out.println("Team Name cannot be empty. Please enter a valid Team Name (e.g., ENGLAND).") ;                           
            }
            else if(teamName.matches(".*\\d.*")) // Check if the teamName contains a digit
            {
                //check if contains digits
                System.out.println("Team Name should not contain digits. Please enter a valid Team Name (e.g., ENGLAND).");
            }
            
        } while (teamName.isEmpty() || teamName.matches(".*\\d.*")); // Continue looping as long as the teamName is empty or contains digits.


        String teamCode;
        do 
        {

            System.out.print("Team Code: ");
            teamCode = input.nextLine().toUpperCase();


            // Check if the teamCode is empty or includes numbers or includes more  or lessthan 3 characters
            if (teamCode.isEmpty()) 
            {
                System.out.println("Team Code cannot be empty. Please enter a valid Team Code(e.g., ENG).");
            }
            else if (!teamCode.matches("[A-Z]{3}"))
            {
                // Check if the teamCode does not match the pattern of three uppercase letters
                System.out.println("Invalid Team Code. Please enter a valid Team Code(e.g., ENG).");
            }

        } while (teamCode.isEmpty()|| !teamCode.matches("[A-Z]{3}"));


        int scoresFor;
        while (true) 
        {

            System.out.print("Scores For: ");
            if (input.hasNextInt() )// Check if the input is an integer
            {
                scoresFor = input.nextInt();
                if (scoresFor >= 0 ) 
                {
                    break; // Input is an integer and non-negative, exit the loop
                } 
                else 
                {
                    System.out.println("Scores For must be a non-negative integer. Please enter a valid value.");
                }
            }
            else 
            {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                input.nextLine(); // Consume the invalid input
            }

        }


        int scoresAgainst;
        while (true) 
        {

            System.out.print("Scores Against: ");
            if (input.hasNextInt()) 
            {
                scoresAgainst = input.nextInt();
                
                if (scoresAgainst >= 0)
                {
                    input.nextLine();
                    break; // input is an integer and non-negative, exit the loop
                } 
                else 
                {
                    System.out.println("Scores Against must be a non-negative integer. Please enter a valid value.");
                }
            } 
            else 
            {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                input.nextLine(); // Consume the invalid input
            }

        }


        String group;
        boolean validGroup = false;
        do 
        {

            System.out.print("Group: ");
            group = input.nextLine().toUpperCase();
            switch (group) 
            {

                case "A": case "B": case "C": case "D":
                    validGroup = true;
                    break;
                default:
                    System.out.println("Invalid group. Group must be one of: A, B, C, D");
                    break;
            }

        } while (!validGroup);
        // Return an array of validated inputs
        Object[] teamData = {teamName,teamCode,scoresFor,scoresAgainst,group};
        return teamData;

    }
    
    // Method: getTeamArray
    // Purpose: Returns the teamsArray.
    // Imports: None
    // Exports: Team[] (array of Team objects)
    // Assertions:
    //     Pre: None
    //     Post: The teamsArray is returned.
    // Remarks: Provides access to the teamsArray for other classes.
    public Team[] getTeamArray()
    {
        return teamsArray;
    }
}

                
