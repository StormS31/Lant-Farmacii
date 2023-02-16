package DAO;

import Model.Comanda;
import Model.ComenziPageModel;

import java.sql.*;
import java.util.ArrayList;

import static Connection.ConnectionFactory.getConnection;

public class ComandaDAO {
    public static ArrayList<Comanda> comenzi = new ArrayList<>();
    static Connection connection =  null;
    static PreparedStatement ptmt = null;
    static ResultSet resultSet = null;
    static int insertedId;
    public static boolean insertIntoComanda(int idClient, float pretTotal)
    {
        try {
            String queryString = "insert into comanda (idClient, pretTotal) values " +
                    "(" + idClient + "," + pretTotal + ");";
            System.out.println(queryString);
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
            ptmt.executeUpdate();
            ResultSet rs = ptmt.getGeneratedKeys();
                if (rs.next()) {
                    insertedId = rs.getInt(1);
                }
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

    public static boolean insertIntoComprod(int idMedicament, int idComanda, float cantitate)
    {
        try {
            String queryString = "insert into comprod (idMedicament, idComanda, cantitate)values " +
                    "(" + idMedicament + "," + idComanda + ", " + cantitate + ");";
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
    public static int getInsertedId()
    {
        return insertedId;
    }
    public static ArrayList<Comanda> getComenziById(int id)
    {
        try {

            String queryString = "SELECT * FROM comanda where idClient = ?;";
            comenzi.clear();
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1,id);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                comenzi.add(new Comanda(resultSet.getInt("idComanda"),
                                        id,
                                        resultSet.getTimestamp("data"),
                                        resultSet.getFloat("pretTotal")));


            }
            return comenzi;
        } catch (SQLException e) {
            e.printStackTrace();
            return comenzi;
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
    public static Comanda getComandaById(int id)
    {
        Comanda comanda = null;
        try {
            String queryString = "SELECT * FROM comanda where idComanda = ?;";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1,id);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                comanda = new Comanda(resultSet.getInt("idComanda"),
                        resultSet.getInt("idClient"),
                        resultSet.getTimestamp("data"),
                        resultSet.getFloat("pretTotal"));


            }
            return comanda;
        } catch (SQLException e) {
            e.printStackTrace();
            return comanda;
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
    public static ArrayList<ComenziPageModel> getMedicamenteFromComanda(int id)
    {
        ArrayList<ComenziPageModel> objects = new ArrayList<>();
        try {
            String queryString = "select * from comanda left join comprod on comanda.idComanda = comprod.idComanda left join medicament on medicament.idMedicament = comprod.idMedicament where comanda.idComanda = ?;";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1,id);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                objects.add(new ComenziPageModel(resultSet.getFloat("pretTotal"), resultSet.getInt("idMedicament"),
                        resultSet.getString("denumire"), resultSet.getInt("cantitate"), resultSet.getFloat("pret")));
            }
            return objects;
        } catch (SQLException e) {
            e.printStackTrace();
            return objects;
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
    public static ArrayList<Comanda> getComenzi()
    {
        ArrayList<Comanda> objects = new ArrayList<>();
        try {
            String queryString = "select * from comanda;";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                objects.add(new Comanda(resultSet.getInt("idComanda"), resultSet.getInt("idClient"),
                        resultSet.getTimestamp("data"), resultSet.getFloat("pretTotal")));
            }
            return objects;
        } catch (SQLException e) {
            e.printStackTrace();
            return objects;
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
