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
public class VidomistObj {

    private static String name;
    private static long idNomer;
    private static double narah;
    private static double podatok = 18;
    private static double vPodatok = 1.5;
    private static double profSpilka = 1;

    private static double tmpPodatok;
    private static double tmpVPodatok;
    private static double tmpProfSpilka;

    private static double vsoho;

    public static List<String> nameList = new ArrayList<>();
    public static List<Long> idList = new ArrayList<>();
    public static List<Double> narahList = new ArrayList<>();
    public static List<Double> podatokList = new ArrayList<>();
    public static List<Double> vPodatokList = new ArrayList<>();
    public static List<Double> profSpList = new ArrayList<>();
    public static List<Double> vsohoList = new ArrayList<>();

    /**
     * Налаштування податка %
     *
     * @param podatok податок %
     */
    public static void setPodatok(double podatok) {
        VidomistObj.podatok = podatok;
    }

    /**
     * Налаштування військового збору %
     *
     * @param vPodatok військовий збір %
     */
    public static void setvPodatok(double vPodatok) {
        VidomistObj.vPodatok = vPodatok;
    }

    /**
     * Налаштування профспілки %
     *
     * @param profSpilka профспілка %
     */
    public static void setProfSpilka(double profSpilka) {
        VidomistObj.profSpilka = profSpilka;
    }

    /**
     * Додає ряд
     *
     * @param name ім'я
     * @param idNomer ідентифікаційний код
     * @param narah нарахування
     */
    public static void addObj(String name, long idNomer, double narah) {
        VidomistObj.name = name;
        VidomistObj.idNomer = idNomer;
        VidomistObj.narah = setFloatPoint(narah);
        nameList.add(name);
        idList.add(idNomer);
        narahList.add(setFloatPoint(narah));
        podatokList.add(setFloatPoint(podatok()));
        vPodatokList.add(setFloatPoint(vpodatok()));
        profSpList.add(setFloatPoint(pSpilka()));
        vsohoList.add(setFloatPoint(vsoho()));
    }

    /**
     * Порахує податка
     *
     * @return податок грн
     */
    private static double podatok() {
        tmpPodatok = narah * podatok / 100;
        return tmpPodatok;
    }

    /**
     * Порахує військового збору
     *
     * @return військового збір грн
     */
    private static double vpodatok() {
        tmpVPodatok = narah * vPodatok / 100;
        return tmpVPodatok;
    }

    /**
     * Порахує профспілку
     *
     * @return профспілку грн
     */
    private static double pSpilka() {
        tmpProfSpilka = narah * profSpilka / 100;
        return tmpProfSpilka;
    }

    /**
     * Повертає податка
     *
     * @return податок
     */
    public static double getPodatok() {
        return podatok;
    }

    /**
     * Повертає військового збору
     *
     * @return військового збір
     */
    public static double getvPodatok() {
        return vPodatok;
    }

    /**
     * Повертає профспілку
     *
     * @return профспілка
     */
    public static double getProfSpilka() {
        return profSpilka;
    }

    /**
     * Порахує всього
     *
     * @return всього грн
     */
    private static double vsoho() {
        return tmpPodatok + tmpVPodatok + tmpProfSpilka;
    }
}
