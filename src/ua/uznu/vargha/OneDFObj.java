/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.uznu.vargha;

import java.util.ArrayList;
import java.util.List;
import static ua.uznu.vargha.StatniyObj.setFloatPoint;

/**
 * @author Sabee
 */
public class OneDFObj {

    private static double podatok = 18;

    public static List<Long> idenList = new ArrayList<>();
    public static List<Double> sumhDohodList = new ArrayList<>();
    public static List<Double> sumUtrymane = new ArrayList<>();
    public static List<Integer> oznakaList = new ArrayList<>();

    /**
     * Додає ряд
     *
     * @param iden ідентифікаційний код
     * @param narah нарахування
     * @param oznaka ознака доходу
     */
    public static void addObj(long iden, double narah, int oznaka) {
        idenList.add(iden);
        sumhDohodList.add(setFloatPoint(narah));
        sumUtrymane.add(setFloatPoint(getPodatok(narah)));
        oznakaList.add(oznaka);
    }

    /**
     *
     * @param narahovano нараховано грн
     * @return податок грн
     */
    private static double getPodatok(double narahovano) {
        return narahovano * podatok / 100;
    }
}
