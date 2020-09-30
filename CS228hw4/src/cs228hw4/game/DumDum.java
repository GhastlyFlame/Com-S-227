package cs228hw4.game;

import edu.iastate.cs228.game.Agent;
import edu.iastate.cs228.game.GalaxyState;
import edu.iastate.cs228.game.SystemState;

import java.awt.*;
import java.io.File;

public class DumDum implements Agent {

    private Color myColour;
    private Color yourColour;
    private int currEnergy = -1;

    /**
     * This method must return your first name.
     *
     * @return student's first name
     */
    @Override
    public String getFirstName() {
        return "Haadi";
    }

    /**
     * This method must return your last name.
     *
     * @return student's last name
     */
    @Override
    public String getLastName() {
        return "Majeed";
    }

    /**
     * This method must return your student ID.
     *
     * @return the student's ISU ID
     */
    @Override
    public String getStuID() {
        return "957539608";
    }

    /**
     * This method must return your username.
     *
     * @return the students ISU username
     */
    @Override
    public String getUsername() {
        return "hmajeed";
    }

    /**
     * This method must return your agent's name (of your choosing).
     *
     * @return the agent's name
     */
    @Override
    public String getAgentName() {
        return "Nate";
    }

    /**
     * Function to retrieve your image file (assuming it is present at the base
     * level of your project).
     *
     * @return the agent's image file (if you wish to make a 128x128 icon for your
     * agent) or null (to use the default image)
     */
    @Override
    public File getAgentImage() {
        return null;
    }

    /**
     * Whether your agent is a candidate for the tournament. Return true if this
     * agent is submitted for the tournament, false otherwise.
     *
     * @return true iff you wish to enter this agent in the tournament
     */
    @Override
    public boolean inTournament() {
        return false;
    }

    /**
     * Function used to generate command turns from your agent.  Use the passed
     * GalaxyState to decide 3 actions for your agent.  This version
     * will only be used if this agent is run during a tournament.
     *
     * @param g           a scan of the current state of the system
     * @param energyLevel energy level corresponding to the amount of energy the agent has
     * @return an array of 3 AgentActions that indicates the agent's next 3
     * actions if in a tournament situation. If fewer than 3 actions are
     * specified or there are null actions, these agent moves are lost.
     */
    @Override
    public AgentAction[] getCommandTurnTournament(GalaxyState g, int energyLevel) {

        currEnergy = energyLevel;
        SystemState current = g.getCurrentSystemFor(myColour);
        int cmdNum = 0;
        AgentAction[] commands = {new NoAction(), new NoAction(), new NoAction()};

        return commands;
    }

    /**
     * Function used to generate command turns from your agent.  Use the passed
     * GalaxyState to decide 3 actions for your agent.  This version
     * will only be used if this agent is run during grading.
     *
     * @param g           a scan of the current state of the system
     * @param energyLevel energy level corresponding to the amount of energy the agent has
     * @return An array of 3 AgentActions that indicates the agent�s next 3
     * actions if in an exhibition/grading situation. If fewer than 3
     * actions are specified or there are null actions, these agent moves
     * are lost.
     */
    @Override
    public AgentAction[] getCommandTurnGrading(GalaxyState g, int energyLevel) {

        return getCommandTurnTournament(g, energyLevel);
    }

    /**
     * Allow the simulation to set the color of your agent. It's up to you to
     * save this information somehow.  This method is called only once, at the
     * start of each simulation.
     *
     * @param c color your agent will appear as
     */
    @Override
    public void setColor(Color c) {
        myColour = new Color(c.getRGB());
    }

    /**
     * Allow the simulation to set the color of your agent's opponent. It's up to you to
     * save this information if you need it.  This method is called only once, at the
     * start of each simulation.
     *
     * @param c color of your agent's opponent
     */
    @Override
    public void setOpponentColor(Color c) {
        yourColour = new Color(c.getRGB());
    }

}
