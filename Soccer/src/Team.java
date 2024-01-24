//Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW3-Soccer
// Resources used: none




// Team Class, store values of array of players.
public class Team {
    Player[] team;



    // constructor, set team array data
    public Team(Player[] players) {
        this.team = new Player[players.length];
        setTeam(players);


    }
    // get the entire team info
    public Player[] getTeam() {

        Player[] teamCopy = new Player[this.team.length];

        for (int i = 0; i < this.team.length; i++) {
            teamCopy[i] = this.team[i];
        }
        return teamCopy;
    }

    // set the team array values
    public void setTeam(Player[] players) {

        for (int i = 0; i < players.length; i++) {
            team[i] = players[i];

        }
    }

    // output entire team info into a line
    public String toString() {

        String str = "";


        for (int i = 0; i < this.team.length; i++) {
            str += team[i].toString();
        }


        return str;


    }

    // check whether another team is same as this or not
    public boolean equals(Object other) {

        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }

        if (other instanceof Team) {

            Player[] otherTeam = (Player[]) other;
            for (int i = 0; i < this.team.length; i++) {
                if (!this.team[i].equals(otherTeam[i])) {
                    return false;


                }

                return true;
            }

        }
        return false;
    }




    // calculate average shot on goal percentage for a team
    public double SOGAverage() {
        double average = 0.0;

        for (int i = 0; i < this.team.length; i++) {
            average += team[i].sog_percentage;
            average = average / team.length;
        }
        return average;


    }

    // count how many position of a kind there is on a team
    public int positionCount(String pos) {


        int count = 0;

        for (int i = 0; i < this.team.length; i++) {

            if (team[i].getPosition().toLowerCase().equals(pos.toLowerCase())) {
                count += 1;
            }
        }

        return count;
    }

    // sort the team in descending order using the minutes_played as the sorting key
    public Player[] sort() {

        Player temp;
        Player[] teamNew = new Player[team.length];

        for (int i = 0; i < teamNew.length; i++) {
            for (int j = 0; j < teamNew.length; j++) {
                if (teamNew[i].minutes_played > teamNew[j].minutes_played) {
                    temp = teamNew[i];
                    teamNew[i] = teamNew[j];
                    teamNew[j] = temp;
                }
            }
        }
        return teamNew;

    }

    // check whether a name is on the team
    public boolean onTeam(String name) {


        for (int i = 0; i < this.team.length; i++) {
            if (this.team[i].getName().equals(name)) {
                return true;
            }
        }
        return false;


    }

    // find the player with most goals on the team
    public Player mostGoals() {

        double best_point = -1.0;
        Player best_Player = team[0];
        // memorize the biggest and return it.
        for (int i = 0; i < team.length; i++) {
            if (team[i].goals > best_point) {
                best_point = team[i].goals;
                best_Player = team[i];
            }
        }
        return best_Player;
    }


}



