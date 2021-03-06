import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.*;

public class Database {

    //Establishes database location and creates corresponding variables
    static final String DATABASE_URL = "jdbc:ucanaccess://C://Users//joeyr//Documents//IST311.accdb";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement insertNewSpeaker = null;

    //Connects to the database and prints out success/fail messages
    public Database() {
        try {

            System.out.println("Starting Database Connection");

            connection = DriverManager.getConnection(DATABASE_URL);

            System.out.println("Connected");

            statement = connection.createStatement();
            System.out.println("Established Statement");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    //Adds the speaker to the database
    public int addSpeaker(String fName, String lName, String title, String inPersonAddress, String emailAddress, String city, String speechDate, String invitedBy, String org, String sem, String gft, String parkPass, String inPer) {
        int result = 0;

        try {
            insertNewSpeaker = connection.prepareStatement("INSERT INTO SPEAKERS (firstName, lastName, Title, Address, Email, City, SpeechDate, Invitee, Organization, Semester, Gift, ParkingPass, inPerson) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertNewSpeaker.setString(1, fName);
            insertNewSpeaker.setString(2, lName);
            insertNewSpeaker.setString(3, title);
            insertNewSpeaker.setString(4, inPersonAddress);
            insertNewSpeaker.setString(5, emailAddress);
            insertNewSpeaker.setString(6, city);
            insertNewSpeaker.setString(7, speechDate);
            insertNewSpeaker.setString(8, invitedBy);
            insertNewSpeaker.setString(9, org);
            insertNewSpeaker.setString(10, sem);
            insertNewSpeaker.setString(11, gft);
            insertNewSpeaker.setString(12, parkPass);
            insertNewSpeaker.setString(13, inPer);

            result = insertNewSpeaker.executeUpdate();

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Record Insert Completed", lName, JOptionPane.INFORMATION_MESSAGE);
            }
            else if (result == 0) {
                JOptionPane.showMessageDialog(null, "Record Insert Failed", lName, JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Insert Failed", JOptionPane.ERROR_MESSAGE);
            result = 0;
        }
        finally
        {
            try {
                statement.close();
                connection.close();
            } catch (SQLException sqlException) {
                JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Close Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
        return result;
    }
}
