import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.*;

public class Database {

    static final String DATABASE_URL = "jdbc:ucanacces://C:/Users/joey/Documents/IST311.accdb";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement insertNewSpeaker = null;

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

    public int addSpeaker(String fName, String lName, String add, String cityAddress, String emailAddress, String speechDate, String invited) {
        int result = 0;

        try {
            insertNewSpeaker = connection.prepareStatement("INSERT INTO PERSON (firstName, lastName, Title, Address, Email, City, SpeechDate, Invitee) values (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertNewSpeaker.setString(1, fName);
            insertNewSpeaker.setString(2, lName);
            insertNewSpeaker.setString(3, add);
            insertNewSpeaker.setString(4, cityAddress);
            insertNewSpeaker.setString(5, emailAddress);
            insertNewSpeaker.setString(6, speechDate);
            insertNewSpeaker.setString(7, invited);

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
