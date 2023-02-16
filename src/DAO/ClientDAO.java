package DAO;

import Model.Client;
import Model.PermissionLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Connection.ConnectionFactory.getConnection;

public class ClientDAO {
    public ArrayList<Client> clienti;
    static Connection connection =  null;
    static PreparedStatement ptmt = null;
    static ResultSet resultSet = null;
    public static Client getLogIn(String email, String pass)
    {

        try {
            String queryString = "SELECT * FROM client where email ='" + email + "' and parola = '" + pass + "'" ;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            Client client = null;
            //resultSet.
            if (resultSet.next()) {
                client = (new Client(resultSet.getInt("idClient"), resultSet.getString("nume"),
                        resultSet.getString("adresa"), resultSet.getString("email"),null,
                        null,null));
                switch(resultSet.getString("permisiune"))
                {
                    case "CLIENT":
                        client.setPermissionLevel(PermissionLevel.CLIENT);
                        break;
                    case "ANGAJAT":
                        client.setPermissionLevel(PermissionLevel.ANGAJAT);
                        break;
                    case "ADMINISTRATOR":
                        client.setPermissionLevel(PermissionLevel.ADMINISTRATOR);
                        break;
                    default:
                }
            }
            return client;
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
    public static boolean registerNewClient(String user, String pass, String email, String address, PermissionLevel permissionLevel)
    {
        try {
            String queryString = "insert into client (nume, adresa, email, parola, permisiune) values " +
                    "('" + user + "','" + address + "','" + email + "','" + pass + "','" + permissionLevel.toString() + "');";
            System.out.println(queryString);
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
