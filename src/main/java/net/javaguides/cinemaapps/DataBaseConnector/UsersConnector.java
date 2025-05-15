package net.javaguides.cinemaapps.DataBaseConnector;

import javafx.scene.control.Label;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersConnector extends Connect {
    private static final String DATA_LINK_USER = "jdbc:sqlite:DataBase/Users.db";
    private static final String USERNAME_SEARCH = "SELECT * FROM Akun WHERE username = ? AND password = ?";
    private static final String SIGN_UP_DATA = "INSERT INTO Akun (username, email, password) VALUES (?, ?, ?)";
    private static final String QUERY_USERNAME_CHECK = "SELECT COUNT(*) FROM Akun WHERE username = ?";

    @Override
    public void ConnectData() {
        try (Connection conn = DriverManager.getConnection(DATA_LINK_USER)) {
            Statement stmt = conn.createStatement();
            //stmt.execute("PRAGMA journal_mode=WAL;");  // Mengaktifkan WAL mode untuk SQLite
           // System.out.println("Database Terhubung dan WAL mode diaktifkan");
            System.out.println("DataBase Terhubung");
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Database User Tidak Ditemukan!!!", e);
        }
    }

    public boolean LoginCheck(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DATA_LINK_USER)) {
            PreparedStatement statement = conn.prepareStatement(USERNAME_SEARCH);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Login Gagal!!");
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void SignUpData() {

    }
    public void SignUpData(String username, String password, String email, Label label) {
        if (UsernameExist(username)) {
            label.setText("Username Sudah Ada");
            label.setStyle("-fx-text-fill : red;");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DATA_LINK_USER)) {
            PreparedStatement statement = conn.prepareStatement(SIGN_UP_DATA);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("User Data Successfully Updated");
            } else {
                System.out.println("User Data Not Updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean UsernameExist(String username) {
        try (Connection conn = DriverManager.getConnection(DATA_LINK_USER)) {
            PreparedStatement statement = conn.prepareStatement(QUERY_USERNAME_CHECK);
            statement.setString(1, username);

            ResultSet result = statement.executeQuery();
            return result.next() && result.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
