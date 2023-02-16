package DAO;

import Controller.ControllerPharmacy;
import Model.Medicament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Connection.ConnectionFactory.getConnection;

public class MedicamentDAO {
    static Connection connection = null;
    static PreparedStatement ptmt = null;
    static ResultSet resultSet = null;
    private static ArrayList<Medicament> medicamente;
    public MedicamentDAO()
    {
        medicamente = new ArrayList<Medicament>();
    }

    public static ArrayList<Medicament> getMedicamenteFarmacieId(int idFarmacie) {

        try {
            medicamente = new ArrayList<Medicament>();
            String queryString = "select * from medfarm left join medicament on medfarm.idMedicament = medicament.idMedicament where idFarmacie = ?;";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idFarmacie);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                medicamente.add(new Medicament(resultSet.getInt("idMedicament"), resultSet.getString("denumire"),
                        resultSet.getString("descriere"), resultSet.getString("categorie"),
                        resultSet.getString("furnizor"), resultSet.getFloat("pret"), resultSet.getInt("stoc")));

            }
            return medicamente;
        } catch (SQLException e) {
            e.printStackTrace();
            return medicamente;
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

    public static void adaugaMedicamentLaFarmacie(int idMedicamentDeModificat, int setStoc) {
        try {
            String queryString = "INSERT INTO medfarm (idMedicament, idFarmacie, stoc)" +
                    "VALUES (?, ?, ?)\n" +
                    "ON DUPLICATE KEY UPDATE stoc = stoc + VALUES(stoc);";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idMedicamentDeModificat);
            ptmt.setInt(3, setStoc);
            ptmt.setInt(2, ControllerPharmacy.getCurrentAngajat().getIdFarmacie());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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

    public static void adaugaMedicament(String denumire, int stoc, String categorie, String descriere, String furnizor, float pret) {
        try {
            String queryString = "INSERT INTO medicament(denumire, descriere, categorie, furnizor, stocOnline, pret) VALUES(?,?,?,?,?, ?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1,denumire);
            ptmt.setString(2, descriere);
            ptmt.setString(3, categorie);
            ptmt.setString(4,furnizor);
            ptmt.setInt(5, stoc);
            ptmt.setFloat(6, pret);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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

    public void add(Medicament med)
    {
        try {
            String queryString = "INSERT INTO medicament(denumire, descriere, categorie, furnizor) VALUES(?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1,med.getDenumire());
            ptmt.setString(2, med.getDescriere());
            ptmt.setString(3, med.getCategorie());
            ptmt.setString(4, med.getFurnizor());
            //ptmt.setInt(5, med.getStoc());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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

    public static List<Medicament> getMedicamente()
    {
        try {
            medicamente = new ArrayList<Medicament>();
            String queryString = "SELECT * FROM medicament;";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                medicamente.add(new Medicament(resultSet.getInt("idMedicament"), resultSet.getString("denumire"),
                        resultSet.getString("descriere"), resultSet.getString("categorie"),
                        resultSet.getString("furnizor"), resultSet.getFloat("pret"), resultSet.getInt("stocOnline")));

            }
            return medicamente;
            //System.out.println(medicamente.get(0).getDenumire());
        } catch (SQLException e) {
            e.printStackTrace();
            return medicamente;
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

    public static List<Medicament> getMedicamentByCategorie(String categorie)
    {
        try {
            String queryString = "SELECT * FROM medicament where categorie = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, categorie);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                medicamente.add(new Medicament(resultSet.getInt("idMedicament"), resultSet.getString("denumire"),
                        resultSet.getString("descriere"), resultSet.getString("categorie"),
                        resultSet.getString("furnizor"), resultSet.getFloat("pret"), resultSet.getInt("stocOnline")));
            }
            return medicamente;
        } catch (SQLException e) {
            e.printStackTrace();
            return medicamente;
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

    public static int computeStock(int id)
    {
        int stock = 0;
        try {
            String queryString = "SELECT * FROM medfarm where idMedicament = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, id);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                stock += resultSet.getInt("stoc");
            }
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

        return stock;
    }
    public static List<String> getFarmacie(int id){
        List<String> farmacies = new ArrayList<>();
        try {
            String queryString = "    SELECT * FROM medfarm" +
                    "    LEFT JOIN farmacie ON farmacie.idFarmacie = medfarm.idFarmacie where idMedicament = ?;";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, id);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                farmacies.add(resultSet.getString("oras") + ", str. " + resultSet.getString("strada") + ", nr. "
                        + resultSet.getString("numar") + ", stoc:" + resultSet.getInt("stoc"));
            }
            return farmacies;
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
    public static void modificaMedicament(int idMedicament, int stocNou)
    {
        try {
            String queryString = "update medfarm set stoc = ? where idMedicament = ? and idFarmacie = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, stocNou);
            ptmt.setInt(2, idMedicament);
            ptmt.setInt(3, ControllerPharmacy.getCurrentAngajat().getIdFarmacie());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
