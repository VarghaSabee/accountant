/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.uznu.vargha;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sabee
 */
public class DBSettingsObj {

    private static List<Integer> col1 = new ArrayList<>();

    private static List<String> col2 = new ArrayList<>();

    private static List<Double> col3 = new ArrayList<>();

    private String rang;
    private double rang_hrn;

    /**
     *
     * @param rang ранг
     * @param rang_hrn ранг грн
     */
    public DBSettingsObj(String rang, double rang_hrn) {
        this.rang = rang;
        this.rang_hrn = rang_hrn;
    }

    /**
     * Повертає ранг
     *
     * @return ранг
     */
    public String getRang() {
        return rang;
    }

    /**
     * Повертає ранг грн
     *
     * @return ранг грн
     */
    public double getRang_hrn() {
        return rang_hrn;
    }

    /**
     * Повертає і-ой елемента
     *
     * @param i індекс
     * @return і-ой елемент
     */
    public static int getCol1(int i) {
        return col1.get(i);
    }

    /**
     * Повертає і-ой елемента
     *
     * @param i індекс
     * @return і-ой елемент
     */
    public static String getCol2(int i) {
        return col2.get(i);
    }

    /**
     * Повертає і-ой елемента
     *
     * @param i індекс
     * @return і-ой елемент
     */
    public static double getCol3(int i) {
        return col3.get(i);
    }

    /**
     * Додає елемент
     *
     * @param id індекс
     * @param data1
     * @param data2
     */
    public static void addObj(int id, String data1, double data2) {
        col1.add(id);
        col2.add(data1);
        col3.add(data2);
    }

    /**
     * Видаляє і-ой елемента
     *
     * @param i індекс
     */
    public static void removeObj(int i) {
        col1.remove(i);
        col2.remove(i);
        col3.remove(i);
    }

    /**
     * Видаляє всіх елементів
     */
    public static void clearObj() {
        col1.clear();
        col2.clear();
        col3.clear();
    }

    /**
     * Повертає к-ть елементів
     *
     * @return к-ть елементів
     */
    public static int getSize() {
        return col1.size();
    }
}
