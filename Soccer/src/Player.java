//Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW3-Soccer
// Resources used: none


// Player Class, store values of each player.
public class Player {

    String name;
    String position;
    int minutes_played;
    int goals;
    int assists;
    double sog_percentage;


    // default constructor
    public Player() {

        this.name = "";
        this.position = "";
        this.minutes_played = 0;
        this.goals = 0;
        this.assists = 0;
        this.sog_percentage = 0.0;
    }

    // constructor, set values as inputs.
    public Player(String name, String position, int minutes_played,
                  int goals, int assists, double sog_percentage) {
        this.name = name;
        this.position = position;
        this.minutes_played = minutes_played;
        this.goals = goals;
        this.assists = assists;
        this.sog_percentage = sog_percentage;

    }

    // set the name value.
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    // set the position value.
    public void setPosition(String position) {
        position = position.toLowerCase();
        if (position.equals("defense") || position.equals("midfield") || position.equals("forward") || position.equals("goalie")) {
            this.position = position;
        }
    }

    // get the position value.
    public String getPosition() {
        return position;

    }

    // set the minutes played value.
    public void setMinutes_played(int minutes_played) {
        if (minutes_played > 0) {
            this.minutes_played = minutes_played;
        }
    }
    // set the goals value.
    public void setGoals(int goals) {
        if (goals > 0) {
            this.goals = goals;
        }
    }
    // set the assists value.
    public void setAssists(int assists) {
        if (assists > 0) {
            this.assists = assists;
        }
    }
    // set the shot on goal percentage value.
    public void setSOG(double sog_percentage) {
        if (sog_percentage > 0) {
            this.sog_percentage = sog_percentage;
        }
    }

    // output all player info into a line
    public String toString() {
        return "Name: " + name +
                ", Position: " + position +
                ", Minutes Played: " + minutes_played +
                ", Goals: " + goals +
                ", Assists: " + assists +
                ", Shots on Goal Percentage: " + sog_percentage
                + "    ";

    }

    // check whether another player is same as this or not
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }

        if (o instanceof Player) {

            Player otherPlayer = (Player) o;

            if (this.getName().equals(otherPlayer.getName())
                    && this.getPosition().equals(otherPlayer.getPosition())) {

                return true;


            }

        }
        return false;


    }


}
