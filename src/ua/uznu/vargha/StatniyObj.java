/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.uznu.vargha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static ua.uznu.vargha.ConnectDB.getConnection;

/**
 * @author Sabee
 */
public class StatniyObj {

    private static double tmpOklad;
    private static double tmpRang;
    private static double tmpVisluha;

    public static List<String> nazvPosadList = new ArrayList<>();
    public static List<Double> okladList = new ArrayList<>();
    public static List<Double> posOkladList = new ArrayList<>();
    public static List<String> rangList = new ArrayList<>();
    public static List<Double> rangHRNLIst = new ArrayList<>();
    public static List<Double> visluhaList = new ArrayList<>();
    public static List<Double> vislHRNLIst = new ArrayList<>();
    public static List<Double> fondZPList = new ArrayList<>();

    /**
     * Додає ряд
     *
     * @param posada посада
     * @param oklad оклад
     * @param rang ранг
     * @param visluha вислуга
     */
    public static void addObj(String posada, double oklad, String rang, String visluha) {
        nazvPosadList.add(posada);
        okladList.add(oklad);
        addPosOklad(posada, oklad);
        rangList.add(rang);
        addRangHRN(rang);
        addVisluha(visluha);
        addFondZP();
    }

    /**
     * Порахує і додає посадового окладу
     *
     * @param nazv назва посад
     * @param oklad ставка
     */
    private static void addPosOklad(String nazv, double oklad) {
        tmpOklad = oklad * getDoubleData("posada", "oklad", "nazva", nazv);
        posOkladList.add(setFloatPoint(tmpOklad));
    }

    /**
     * Повертає ранг грн
     *
     * @param rang ранг грн
     */
    private static void addRangHRN(String rang) {
        tmpRang = getDoubleData("rang", "rang_hrn", "rang", rang);
        rangHRNLIst.add(setFloatPoint(tmpRang));
    }

    /**
     * Повертає вислугу грн
     *
     * @param visluha вислуга грн
     */
    private static void addVisluha(String visluha) {
        double vidsotki = getDoubleData("visluha", "vidsotki", "rik", visluha);
        visluhaList.add(vidsotki);
        tmpVisluha = vidsotki * (tmpOklad + tmpRang) / 100;
        vislHRNLIst.add(setFloatPoint(tmpVisluha));
    }

    /**
     * Додає місячний фонд зарплати
     */
    private static void addFondZP() {
        fondZPList.add(setFloatPoint(tmpOklad + tmpRang + tmpVisluha));
    }

    /**
     * Сумквання елементів масиву
     *
     * @param list масив
     * @return сума
     */
    public static double getVsoho(List<Double> list) {
        double sum = 0;
        for (Double d : list) {
            sum += d;
        }
        return setFloatPoint(sum);
    }

    /**
     * Видалення всіх елементів
     */
    public static void clear() {
        nazvPosadList.clear();
        okladList.clear();
        posOkladList.clear();
        rangList.clear();
        rangHRNLIst.clear();
        visluhaList.clear();
        vislHRNLIst.clear();
        fondZPList.clear();
    }

    /**
     * Видалення і-ой елемента
     *
     * @param index індекс
     */
    public static void remove(int index) {
        nazvPosadList.remove(index);
        okladList.remove(index);
        posOkladList.remove(index);
        rangList.remove(index);
        rangHRNLIst.remove(index);
        visluhaList.remove(index);
        vislHRNLIst.remove(index);
        fondZPList.remove(index);
    }

    /**
     * Точність після коми 0.00
     *
     * @param number число
     * @return число 0.00
     */
    public static double setFloatPoint(double number) {
        double num = Math.round(number * 100);
        return num / 100;
    }

    /**
     * Повертає число з БД
     *
     * @param table таблиця
     * @param column колонка
     * @param whereCol де
     * @param id індекс
     * @return число
     */
    private static double getDoubleData(String table, String column, String whereCol, String id) {
        PreparedStatement preparedStatement = null;
        Connection conn = getConnection();
        String query = "SELECT " + column + " FROM " + table + " WHERE " + whereCol + " = ?";

        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }
}
