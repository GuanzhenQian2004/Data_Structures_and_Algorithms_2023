// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW8-Recursion
// Resources used: https://www.w3schools.com/java/java_ref_string.asp  Used for string methods

import java.util.Objects;
import java.util.Random;

public class Password {

    // Current and new passwords
    private String curPassword;
    private String newPassword;

    // Constructor to set the current password
    public Password(String password) {
        curPassword = "";
        // Call mutator to set the password
        setPassword(password);
        newPassword = "";
    }

    // Default constructor
    public Password() {
        curPassword = "";
        newPassword = "";
    }

    // Helper method to check if a password contains at least one digit
    private boolean containsDigit(String password) {
        if (password.isEmpty()) {
            return false;
        } else if (Character.isDigit(password.charAt(0))) {
            return true;
        } else {
            return containsDigit(password.substring(1));
        }
    }

    // Helper method to check if two passwords are the same
    private boolean samePassword(String password1, String password2) {
        if (password1.length() != password2.length()) {
            return false;
        }
        if (password1.isEmpty()) {
            return true;
        }
        if (password1.charAt(0) != password2.charAt(0)) {
            return false;
        } else {
            return samePassword(password1.substring(1), password2.substring(1));
        }
    }

    // Helper method to count the number of differences between two passwords
    private int countDifferences(String password1, String password2) {
        int count;

        if (password1.isEmpty() || password2.isEmpty()) {
            if (password1.length() >= password2.length()) {
                return password1.length();
            } else {
                return password2.length();
            }
        }

        if (password1.charAt(0) == password2.charAt(0)) {
            count = 0;
        } else {
            count = 1;
        }

        return count + countDifferences(password1.substring(1), password2.substring(1));
    }

    // Helper method to check if the difference between two passwords is sufficient
    private boolean sufficientDifferent(String password1, String password2, int minimum) {
        int difference = countDifferences(password1, password2);
        return difference >= minimum;
    }

    // Override toString method to represent the password as asterisks
    public String toString() {
        int randNum = new Random().nextInt(20) + 1;
        String asterisks = "*".repeat(randNum);
        return curPassword.charAt(0) + asterisks + curPassword.charAt(curPassword.length() - 1);
    }

    // Override equals method to compare two Password objects
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o instanceof Password) {
            Password oPassword = (Password) o;
            // Check if current and new passwords are equal
            if (this.curPassword.equals(oPassword.curPassword) &&
                    this.newPassword.equals(oPassword.newPassword)) {
                return true;
            }
        }
        return false;
    }

    // Getter method to retrieve the current password
    public String getPassword() {
        return curPassword;
    }

    // Mutator method to set the password if it meets certain criteria
    public boolean setPassword(String password) {
        // Check if the password contains a digit, is different from the current password,
        // and has sufficient differences with the current password
        if (containsDigit(password) &&
                !samePassword(password, curPassword) &&
                sufficientDifferent(password, curPassword, curPassword.length() / 2)) {
            curPassword = password;
            newPassword = "";
            return true;
        }
        newPassword = "";
        return false;
    }
}

