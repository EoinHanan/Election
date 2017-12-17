package Database;

import Objects.Constituency;
import Objects.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by EoinH on 17/10/2017.
 */
public class DBReader {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public DBReader(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Election2016","root","");

            statement = connection.createStatement();
        }catch(Exception ex){
            System.out.println("Error:" + ex);
        }
    }

    public void readConstituency(String constituencyName){
        Model model;

        try{
            String query;

            query = "SELECT * from constituencies where name = '" + constituencyName +  "'";

            resultSet = statement.executeQuery(query);

            resultSet.next();
            int conID = resultSet.getInt("ConID");
            int turnout = resultSet.getInt("Turnout");
            String name = resultSet.getString("Name");
            int seats = resultSet.getInt("Seats");
            int population = resultSet.getInt("Population");
            int spoiled = resultSet.getInt("Spoiled");

            System.out.println("Constituency ID: " + conID +  " turnout: " + turnout + " name: " + name +
                    " seats: " + seats + " population " + population + " spoiled: " + spoiled);

            query = "SELECT * FROM candidates where ConID = (SELECT ConID from constituencies where name = '" + constituencyName +  "')";

            resultSet = statement.executeQuery(query);

            System.out.println("Candidates data");

            while (resultSet.next()){
                int canID = resultSet.getInt("CanID");
                name = resultSet.getString("Name");
                int pid = resultSet.getInt("PID");
                conID = resultSet.getInt("ConID");
                String gender = resultSet.getString("Gender");
                int votes = resultSet.getInt("Votes");

                System.out.println("Candidate ID: " + canID + " name: " + name + " pid: " + pid + " conID: " + conID + " gender " + gender + " votes: " + votes);

            }


            query = "SELECT * FROM rounds where CanID = (SELECT CanID from candidates where name = '" + constituencyName +  "')";

            resultSet = statement.executeQuery(query);

            System.out.println("Candidates data");

            while (resultSet.next()){
                int canID = resultSet.getInt("CanID");
                name = resultSet.getString("Name");
                int pid = resultSet.getInt("PID");
                conID = resultSet.getInt("ConID");
                String gender = resultSet.getString("Gender");
                int votes = resultSet.getInt("Votes");

                System.out.println("Candidate ID: " + canID + " name: " + name + " pid: " + pid + " conID: " + conID + " gender " + gender + " votes: " + votes);

            }

        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}