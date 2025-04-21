

/******************************************************************************************************************
 * File Name:      CSVReader.java
 * Author:         Naveen Fernando (CURTIN ID: 21765018)
 * Date:           9th October 2023
 * 
 * Description:    CSVReader.java is a Java class responsible for reading team data from a CSV file.
 * 
 * Purpose:         - Read team data from a CSV file and convert it into an array of Team objects.
 * 
 * Important Notes: The CSV file must adhere to a specific format: Team Name, Team Code, Goals For,
 *                  Goals Against, and Group.
 * 
 * REQUIRES:       This class makes use of the Team class from the Objects package.
 * 
 * Information on the file: This class is stored in the Managers package.
 ****************************************************************************************************************/



package Managers;

import Objects.Team;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CSVReader 
{
    // Method: readDataFromCSV
    // Purpose: Reads team data from a CSV file, parses it, and returns an array of Team objects.
    // Imports: String fileName (the name of the CSV file to be read)
    // Exports: Team[] (an array of Team objects containing the parsed data)
    // Exceptions: IOException (thrown when there is an I/O error during file reading)
    // Assertions:
    //     Pre: The specified CSV file exists and adheres to the required format.
    //     Post: Team data is read and returned as an array of Team objects.
    // Remarks: None
 
    public static Team[] readDataFromCSV(String fileName) throws IOException 
    {
        BufferedReader reader = null;
        Team[] teamsArray = null;

        try 
        {
            // Create a BufferedReader to read the CSV file from the specified file name
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) 
            {
                if (lineCount == 0) 
                {
                    // Skip the header line
                    lineCount++;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length == 5) 
                {
                     // Extract and trim data from CSV columns
                    String teamName = values[0].trim();
                    String teamCode = values[1].trim();
                    int scoresFor = Integer.parseInt(values[2].trim());
                    int scoresAgainst = Integer.parseInt(values[3].trim());
                    String group = values[4].trim();

                    //Create a Team object with the extracted data
                    Team team = new Team(teamName, teamCode, scoresFor, scoresAgainst, group);

                    if (teamsArray == null) 
                    {
                        // If the teamsArray is empty, initialize it with the first Team
                        teamsArray = new Team[1];
                        teamsArray[0] = team;
                    } 
                    else 
                    {
                        // If the teamsArray already has data, resize it to accommodate the new Team
                        teamsArray = Arrays.copyOf(teamsArray, lineCount);
                        teamsArray[lineCount - 1] = team;
                    }

                    lineCount++;
                }
                 else 
                {
                    System.out.println("Invalid CSV line: " + line); //error messege for invalid csv lines
                }
            }
        }
         finally 
        {
            // Ensure that the reader is closed, even if an exception is thrown
            if (reader != null) 
            {
                reader.close();
            }
        }
        return teamsArray;
    }
}
