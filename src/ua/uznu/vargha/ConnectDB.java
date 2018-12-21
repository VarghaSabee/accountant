/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.uznu.vargha;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sabee
 */
public class ConnectDB {

    static List<String> misyac;
    static List<String> kvartal;
    static List<String> rik;
    static List<Integer> id;
    static List<String> names;

    /**
     * З'єднання до БД
     *
     * @return з'єднання з БД
     */
    public static Connection getConnection() {
        try {
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/zviti?characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

    /**
     * Додавання
     *
     * @param nazva назва
     * @param category категорія
     * @param extension розширення
     * @param bytes байт
     * @return логічний
     */
    public static boolean insertToDB(String nazva, String category, String extension, byte[] bytes) {
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(
                    "insert into blanki (nazva,category,extension,bytes) values (?, ?, ?, ?)");

            pstmt.setString(1, nazva);
            pstmt.setString(2, category);
            pstmt.setString(3, extension);
            pstmt.setBytes(4, bytes);
            pstmt.executeUpdate();

            conn.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    /**
     * Вибірка з БД
     *
     * @param name Ім'я
     * @return файл
     */
    public static ByteFile selectFromDB(String name) {
        Connection conn = getConnection();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(
                    "SELECT extension, bytes FROM blanki WHERE nazva ='" + name + "'");
            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                return new ByteFile(rs.getString(1), rs.getBytes(2));
            }

            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    /**
     * Вибір всіх імен
     *
     * @throws SQLException
     */
    public static void selectNamesFromDB() throws SQLException {
        Connection conn = getConnection();
        PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(
                "SELECT nazva, category FROM blanki");
        // execute select SQL stetement
        ResultSet rs = preparedStatement.executeQuery();
        misyac = new ArrayList<String>();
        kvartal = new LinkedList<String>();
        rik = new LinkedList<String>();
        while (rs.next()) {
            switch (rs.getString(2)) {
                case "Місячний":
                    misyac.add(rs.getString(1));
                    break;
                case "Квартальний":
                    kvartal.add(rs.getString(1));
                    break;
                case "Річний":
                    rik.add(rs.getString(1));
                    break;
                default:
                    System.out.println("Error ");
            }
        }
        conn.close();
    }

    /**
     * Вибір даних з БД
     *
     * @throws SQLException
     */
    public static void selectForDelete() throws SQLException {
        Connection conn = getConnection();
        PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(
                "SELECT id, nazva FROM blanki");
        // execute select SQL stetement
        ResultSet rs = preparedStatement.executeQuery();
        id = new ArrayList<Integer>();
        names = new LinkedList<String>();
        while (rs.next()) {
            id.add(rs.getInt(1));
            names.add(rs.getString(2));
        }
        conn.close();
    }

    /**
     * Видалення з БД
     *
     * @param name ім'я
     * @return
     */
    public static boolean deleteFromDB(String name) {
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = null;
            String SQL = "DELETE FROM blanki WHERE nazva = ? ";
            pstmt = (PreparedStatement) conn.prepareStatement(SQL);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * Вибір даних з БД
     *
     * @param Query запит
     */
    public static void SelectFromDBSettings(String Query) {
        Connection conn = getConnection();
        try {
            DBSettingsObj.clearObj();
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(Query);
            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DBSettingsObj.addObj(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            }
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * Вибір даних з БД
     *
     * @param table ім'я таблиці
     * @param id ідентифікатор
     * @return об'єкт
     */
    public static DBSettingsObj SelectFromDBSettings(String table, int id) {
        Connection conn = getConnection();
        try {
            DBSettingsObj.clearObj();
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("SELECT * FROM " + table + " WHERE id = " + id);
            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                return new DBSettingsObj(rs.getString(2), rs.getDouble(3));
            }
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    /**
     * Оновлення даних
     *
     * @param Query запит
     */
    public static void UpdateSettings(String Query) {
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement updateEXP = (PreparedStatement) conn.prepareStatement(Query);
            updateEXP.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Додавання
     *
     * @param Query запит
     */
    public static void AddSettings(String Query) {
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(Query);
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
