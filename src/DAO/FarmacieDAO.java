package DAO;

import Model.Farmacie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Connection.ConnectionFactory.getConnection;

public class FarmacieDAO {
    static Connection connection = null;
    static PreparedStatement ptmt = null;
    static ResultSet resultSet = null;
    private static ArrayList<Farmacie> farmacies;
    public static ArrayList<Farmacie> getFarmacii()
    {
        try {
            farmacies = new ArrayList<Farmacie>();
            String queryString = "SELECT * FROM farmacie;";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                farmacies.add(new Farmacie(resultSet.getInt("idFarmacie"), resultSet.getString("oras"),
                        resultSet.getString("strada"), resultSet.getInt("numar"), null, resultSet.getString("program"),
                        null));


            }
            return farmacies;
            //System.out.println(medicamente.get(0).getDenumire());
        } catch (SQLException e) {
            e.printStackTrace();
            return farmacies;
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    private static Farmacie farmacie;
    public static Farmacie getFarmacieById(int id)
    {
        try {

            String queryString = "SELECT * FROM farmacie where idFarmacie = ?;";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1,id);
            resultSet = ptmt.executeQuery();
            if (resultSet.next()) {
                farmacie = new Farmacie(resultSet.getInt("idFarmacie"), resultSet.getString("oras"),
                        resultSet.getString("strada"), resultSet.getInt("numar"), null, resultSet.getString("program"),
                        null);


            }
            return farmacie;
            //System.out.println(medicamente.get(0).getDenumire());
        } catch (SQLException e) {
            e.printStackTrace();
            return farmacie;
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void adaugaFarmacie(String oras, String strada, int numar, String program)
    {
        try {
            String queryString = "insert into farmacie (oras, strada, numar, program) values  (?,?,?,?);";
            System.out.println(queryString);
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, oras);
            ptmt.setString(2, strada);
            ptmt.setInt(3, numar);
            ptmt.setString(4, program);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public static void modificaFarmacie(int idFarmacie, String oras,  int numar, String strada,String program)
    {
        try {
            String queryString = "update farmacie set oras = ?, numar = ?, strada = ?, program = ? where idFarmacie= ?";

            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, oras);
            ptmt.setInt(2, numar);
            ptmt.setString(3, strada);
            ptmt.setString(4, program);
            ptmt.setInt(5, idFarmacie);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
