/*****************************************************************************************************************************************
 * Author:             Naveen Fernando (CURTIN ID:21765018)
 * Date:               9th October 2023
 *
 * Description:        The Team class represents a FIFA Women's World Cup team and stores various attributes
 *                     such as team name, team code, scores for and against, group, and net goals. It also
 *                     provides getter methods to access these attributes and a method to display the team's
 *                     attributes in a formatted manner.
 *                     This class is used to represent FIFA Women's World Cup teams in the analysis program.
 *
 * Purpose:            Encapsulate team data for FIFA Women's World Cup analysis.
 *                     Provide methods to access and display team attributes.
 *
 * Important Notes:    The net goals are calculated as the difference between goals scored and goals scored
 *                     against the team during object creation.
 * Information on the file: This class is stored in the Objects package.                  
 ****************************************************************************************************************************************/
package Objects;

public class Team 
{
    // Private fields to store team attributes
    private String teamName;
    private String teamCode;
    private int scoresFor;
    private int scoresAgainst;
    private String group;
    private int netGoals; 

    // Constructor to initialize team attributes
    public Team(String pTeamName, String pTeamCode, int pScoresFor, int pScoresAgainst, String pGroup) 
    {
        this.teamName = pTeamName;
        this.teamCode = pTeamCode;
        this.scoresFor = pScoresFor;
        this.scoresAgainst = pScoresAgainst;
        this.group = pGroup;
        // Calculate and set the net goals during object creation
        this.netGoals = pScoresFor - pScoresAgainst;
    }

    // Getter methods for accessing private fields
    public String getTeamName() 
    {
        return teamName;
    }

    public String getTeamCode() 
    {
        return teamCode;
    }

    public int getScoresFor() 
    {
        return scoresFor;
    }

    public int getScoresAgainst() 
    {
        return scoresAgainst;
    }

    public String getGroup() 
    {
        return group;
    }

    public int getNetGoals() 
    {
        return netGoals;
    }

}
