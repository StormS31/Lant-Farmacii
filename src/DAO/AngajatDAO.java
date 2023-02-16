package DAO;

import Model.Angajat;
import Model.Client;
import Model.Farmacie;
import Model.PermissionLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Connection.ConnectionFactory.getConnection;

public class AngajatDAO {
    private static ArrayList<Angajat> angajati;
    static Connection connection =  null;
    static PreparedStatement ptmt = null;
    static ResultSet resultSet = null;

    public static ArrayList<Angajat> getAngajati()
    {
        try {
            angajati = new ArrayList<Angajat>();
            String queryString = "SELECT * FROM angajat;";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Angajat angajat = new Angajat(resultSet.getInt("idAngajat"), resultSet.getString("nume"),
                        resultSet.getString("cnp"), resultSet.getInt("idFarmacie"), PermissionLevel.ANGAJAT,
                        resultSet.getString("email"));
                angajati.add(angajat);
            }
            return angajati;
            //System.out.println(medicamente.get(0).getDenumire());
        } catch (SQLException e) {
            e.printStackTrace();
            return angajati;
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
    public static Angajat getAngajatById(int id)
    {
        try {
            String queryString = "SELECT * FROM angajat where idAngajat = ?;" ;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, id);
            resultSet = ptmt.executeQuery();
            Angajat angajat = null;
            //resultSet.
            if (resultSet.next()) {
                angajat = new Angajat(resultSet.getInt("idAngajat"), resultSet.getString("nume"),
                        resultSet.getString("cnp"), resultSet.getInt("idFarmacie"), PermissionLevel.ANGAJAT,
                        resultSet.getString("email"));
            }
            return angajat;
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
        return null;
    }
    public static void modificaAngajat(String nume, int idFarmacie, String cnp, String email, int id)
    {
        try {
            String queryString = "update angajat set nume = ?, idFarmacie = ?, cnp = ?, email = ? where idAngajat = ?";

            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, nume);
            ptmt.setInt(2, idFarmacie);
            ptmt.setString(3, cnp);
            ptmt.setString(4, email);
            ptmt.setInt(5, id);
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
    public static void adaugaAngajat(String nume, int idFarmacie, String cnp, String email, String parola)
    {
        try {
            String queryString = "insert into angajat (nume, idFarmacie, cnp, email, parola, permisiune ) values  (?,?,?,?,?, ?);";
            System.out.println(queryString);
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1,nume);
            ptmt.setInt(2, idFarmacie);
            ptmt.setString(3, cnp);
            ptmt.setString(4, email);
            ptmt.setString(5, parola);
            ptmt.setString(6, "angajat");
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
    public static void stergeAngajat(int id)
    {
        try {
            String queryString = "delete from angajat where idAngajat = ?;";
            System.out.println(queryString);
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1,id);
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
    public static Angajat getLogIn(String email, String password)
    {
        Angajat angajat = null;
        try {
            String queryString = "SELECT * FROM angajat where email ='" + email + "' and parola = '" + password + "'" ;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            if (resultSet.next()) {
                angajat = new Angajat(resultSet.getInt("idAngajat"), resultSet.getString("nume"), resultSet.getString("cnp"),
                        resultSet.getInt("idFarmacie"), null, resultSet.getString("email"));
                switch(resultSet.getString("permisiune").toLowerCase())
                {
                    case "client":
                        angajat.setPermissionLevel(PermissionLevel.CLIENT);
                        break;
                    case "angajat":
                        angajat.setPermissionLevel(PermissionLevel.ANGAJAT);
                        break;
                    case "administrator":
                        angajat.setPermissionLevel(PermissionLevel.ADMINISTRATOR);
                        break;
                    default:
                }
            }
            return angajat;
        } catch (SQLException e) {
            e.printStackTrace();
            return angajat;
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
