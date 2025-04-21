/******************************************************************************************************************
 * File Name: Analyzer.java
 * Author: Naveen Fernando (CURTIN ID: 21765018)
 * Date: 9th October 2023
 * 
 * Description: Analyzer provides methods to perform overall and group analysis of FIFA Women's World Cup teams.
 * 
 * Purpose: - Analyze team data to determine the best-performing teams.
 * 
 * Important Notes: None.
 * 
 * REQUIRES: This class makes use of the Team class from the objects package.
 * 
 * Information on the file: This class is stored in the Managers package.
 ****************************************************************************************************************/


package Managers;

import Objects.Team;
import java.util.Arrays;
import java.util.Scanner;




public class Analyzer 
{
    
    // Method: performOverallAnalysis
    // Purpose: Perform overall analysis of FIFA Women's World Cup teams.
    // Imports: teamsArray - an array of Team objects representing the teams' data
    // Exports: None (void)
    // Assertions:
    //   Pre: The teamsArray must be a valid array with at least one Team object.
    //   Post: None
    // Remarks: This method calculates and displays various statistics about the teams.
    public static void performOverallAnalysis(Team[] teamsArray) 
    {
       
        System.out.println("Overall Analysis:");
        System.out.println("\n");

         // Calculate Net Goals for Each Team
        for (Team team : teamsArray) 
        {
            team.getNetGoals(); // Call the get method for each team
        }

        // Sort teams by net goals in descending order using Selection Sort
        selectionSortByNetGoals(teamsArray);

        // Display sorted teams
        System.out.println("Teams Sorted by Net Goals (in descending order):");
        System.out.println("");

        for (Team team : teamsArray)
        {
            System.out.println(team.getTeamName()+" ("+team.getTeamCode()+"):"+team.getNetGoals());
        }
        System.out.println("\n");

        // Sort teams by total goals scored against them in descending order
        selectionSortByGoalsAgainst(teamsArray);

        // Display sorted teams
        System.out.println("Teams Sorted by Total Goals Scored Against them (in descending order):");
        System.out.println("");
        for (Team team : teamsArray) 
        {
            System.out.println(team.getTeamName()+" ("+team.getTeamCode()+"):"+team.getScoresAgainst());
        }
        System.out.println("\n");
        // Sort teams by total goals scored
        selectionSortByGoalsFor(teamsArray);

        // Display sorted teams
        System.out.println("Teams Sorted by Total Goals Scored (in descending order):");
        System.out.println("");
        for (Team team : teamsArray) 
        {
            System.out.println(team.getTeamName()+" ("+team.getTeamCode()+"):"+team.getScoresFor());
        }
        System.out.println("\n");

       
        // Find the highest net goals
        int highestNetGoals = teamsArray[0].getNetGoals();
        if (teamsArray.length > 0)
        {   // Display the team/teams with the highest net goals as the "best performing team/teams."
            System.out.println("Best Performing Team/Teams:");
            System.out.println("");
        
            for (int i = 0; i < teamsArray.length; i++) 
            {
                Team team = teamsArray[i];
                if (team.getNetGoals() == highestNetGoals) 
                {
                    // Display sorted teams
                    System.out.println("Team Name: " + team.getTeamName() + " (" + team.getTeamCode() + ") with the highest goal difference (Net Goals) of: " + team.getNetGoals());
                } 
                else 
                {
                    // Exit the loop when net goals are not equal
                    break;
                }
            }
            System.out.println("\n");


        }   

    }

   

    // Method: performGroupAnalysis
    // Purpose: Perform group analysis of FIFA Women's World Cup teams.
    // Imports: teamsArray - an array of Team objects representing the teams' data
    //           scanner - a Scanner object for user input
    // Exports: None (void)
    // Assertions:
    //   Pre: The teamsArray must be a valid array with at least one Team object.
    //   Post: None
    // Remarks: This method allows the user to select a group and then displays statistics for teams in that group.
    public static void performGroupAnalysis(Team[] teamsArray, Scanner scanner) 
    {
        System.out.println("Group Analysis:");
        System.out.println("");
    
        String group;
        boolean isValidGroup;
    
        do 
        {
            System.out.print("Enter the group for analysis (e.g., A, B, C, D): ");
            group = scanner.nextLine().toUpperCase(); // Convert input to uppercase
            isValidGroup = group.matches("(A|B|C|D)"); // Check if input is one of A, B, C, D
            if (!isValidGroup) 
            {
            System.out.println("Invalid group. Please enter one of A, B, C, D.");
            }
        } while (!isValidGroup);

        System.out.println("");
        
        System.out.println("Group Analysis of Group "+ group +"\n");

        // Filter teams by group
        Team[] groupTeams = filterTeamsByGroup(teamsArray, group);

        // Sort filtered teams by net goals
        selectionSortByNetGoals(groupTeams);

         
        System.out.println("Teams Sorted by Net Goals in Group " + group + " (in descending order):");
        System.out.println("");
        
        for (Team team : groupTeams) 
        {
            System.out.println(team.getTeamName()+" ("+team.getTeamCode()+"):"+team.getNetGoals());
        }
        System.out.println("");// add a blank line

        // Sort filtered teams by total goals scored against them
         selectionSortByGoalsAgainst(groupTeams);
        System.out.println("Teams Sorted by Total Goals Scored Against them in Group " + group + " (in descending order):");
        System.out.println("");

        for (Team team : groupTeams) 
        {
            System.out.println(team.getTeamName()+" ("+team.getTeamCode()+"):"+team.getScoresAgainst());// Display sorted teams
        }
        System.out.println("");// add a blank line


        // Sort filtered teams by total goals scored
        selectionSortByGoalsFor(groupTeams);

        // Display sorted teams
        System.out.println("Teams Sorted by Total Goals Scored in Group " + group + " (in descending order):");
        System.out.println("");// add a blank line
        
        for (Team team : groupTeams) 
        {
            System.out.println(team.getTeamName()+" ("+team.getTeamCode()+"):"+team.getScoresFor());// Display sorted teams
        }
        System.out.println("");// add a blank line



        System.out.println("");
        int highestNetGoals = groupTeams[0].getNetGoals();
        if (groupTeams.length > 0) 
        
        {
            System.out.println("Best Performing Team/Teams in Group " + group + ":\n");
            for (int i = 0; i < groupTeams.length; i++) 
            {
                Team team = groupTeams[i];
                if (team.getNetGoals() == highestNetGoals) 
                {
                    System.out.println( team.getTeamName() + " (" + team.getTeamCode() + ") with the highest goal difference (Net Goals) of: " + team.getNetGoals());
                } 
                else 
                {
                    // Exit the loop when net goals are not equal
                    break;
                }
            }
            System.out.println("");
             
        }   

        
    }

    

    // Method: filterTeamsByGroup
    // Purpose: Filter teams by group from the given array.
    // Imports: teamsArray - an array of Team objects representing the teams' data
    //          group - a String representing the group to filter by
    // Exports: An array of Team objects from the specified group
    // Assertions:
    //    Pre: The teamsArray must be a valid array with at least one Team object.
    //         The group must be a valid group code (e.g., A, B, C, D).
    //    Post: None
    // Remarks: This method filters the teamsArray by the specified group and returns the filtered teams.
    public static Team[] filterTeamsByGroup(Team[] teamsArray, String group) 
    {
        Team[] filteredTeams = new Team[0];// Create a new array to store filtered teams
        // Iterate through teamsArray and add teams with matching group to filteredTeams
        for (Team team : teamsArray) 
        {
            if (team.getGroup().equalsIgnoreCase(group)) 
            {
                // Resize the filteredTeams array to accommodate the new team
                filteredTeams = Arrays.copyOf(filteredTeams, filteredTeams.length + 1);
                filteredTeams[filteredTeams.length - 1] = team;
            }
        }

        return filteredTeams;
    }

    // Method: selectionSortByNetGoals
    // Purpose: Sort an array of Team objects by net goals in descending order using selection sort.
    //  Imports: teamsArray - an array of Team objects to be sorted
    //  Exports: None (void)
    //  Assertions:
    //     Pre: The teamsArray must be a valid array with at least one Team object.
    //     Post: The teamsArray will be sorted in descending order based on net goals.
    // Remarks: This method performs an in-place selection sort on the teamsArray.
   public static void selectionSortByNetGoals(Team[] teamsArray) 
    {
        int n = teamsArray.length;

        for (int i = 0; i < n - 1; i++) 
        {
            int maxIndex = i;
            // Find the index of the team with the maximum net goals in the unsorted portion
            for (int j = i + 1; j < n; j++) 
            { 
                if (teamsArray[j].getNetGoals() > teamsArray[maxIndex].getNetGoals()) 
                {
                    maxIndex = j;
                }
            }

            // Swap teamsArray[i] and teamsArray[maxIndex]
            Team temp = teamsArray[i];
            teamsArray[i] = teamsArray[maxIndex];
            teamsArray[maxIndex] = temp;
        }
    }


    // Method: selectionSortByGoalsAgainst
    // Purpose: Sort an array of Team objects by the total goals scored against them in descending order using selection sort.
    // Imports: teamsArray - an array of Team objects to be sorted
    // Exports: None (void)
    // Assertions:
    //    Pre: The teamsArray must be a valid array with at least one Team object.
    //    Post: The teamsArray will be sorted in descending order based on total goals scored against them.
    // Remarks: This method performs an in-place selection sort on the teamsArray based on goals scored against the teams.
    public static void selectionSortByGoalsAgainst(Team[] teamsArray) 
    {
        int n = teamsArray.length;

        for (int i = 0; i < n - 1; i++) 
        {
            int maxIndex = i;
            // Find the index of the team with the maximum total goals scored against them
            for (int j = i + 1; j < n; j++) 
            {
                if (teamsArray[j].getScoresAgainst() > teamsArray[maxIndex].getScoresAgainst()) 
                {
                    maxIndex = j;
                }
            }

            // Swap teamsArray[i] and teamsArray[maxIndex]
            Team temp = teamsArray[i];
            teamsArray[i] = teamsArray[maxIndex];
            teamsArray[maxIndex] = temp;
        }
    }

    // Method: selectionSortByGoalsFor
    // Purpose: Sort an array of Team objects by the total goals they scored in descending order using selection sort.
    // Imports: teamsArray - an array of Team objects to be sorted
    // Exports: None (void)
    // Assertions:
    //   Pre: The teamsArray must be a valid array with at least one Team object.
    //   Post: The teamsArray will be sorted in descending order based on total goals scored by the teams.
    // Remarks: This method performs an in-place selection sort on the teamsArray based on goals scored by the teams.
    public static void selectionSortByGoalsFor(Team[] teamsArray)
    {
        int n = teamsArray.length;

        for (int i = 0; i < n - 1; i++) 
        {
            int maxIndex = i;
             // Find the index of the team with the maximum total goals scored by them
            for (int j = i + 1; j < n; j++) 
            {
                if (teamsArray[j].getScoresFor() > teamsArray[maxIndex].getScoresFor()) {
                    maxIndex = j;
                }
            }

            // Swap teamsArray[i] and teamsArray[maxIndex]
            Team temp = teamsArray[i];
            teamsArray[i] = teamsArray[maxIndex];
            teamsArray[maxIndex] = temp;
        }
    }   
}
