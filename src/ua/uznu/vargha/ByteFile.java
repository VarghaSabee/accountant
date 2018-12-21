/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.uznu.vargha;

/**
 * @author Sabee
 */
public class ByteFile {

    private String name;
    private String category;
    private final String extension;
    private final byte[] byteArr;

    /**
     *
     * @param extension розширення
     * @param byteArr масив байтів
     */
    public ByteFile(String extension, byte[] byteArr) {
        this.extension = extension;
        this.byteArr = byteArr;
    }

    /**
     *
     * @param name ім'я
     * @param category категорія
     * @param extension розширення
     * @param byteArr масив байтів
     */
    public ByteFile(String name, String category, String extension, byte[] byteArr) {
        this.name = name;
        this.category = category;
        this.extension = extension;
        this.byteArr = byteArr;
    }

    /**
     *
     * @return Ім'я
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return категорія
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @return розширення
     */
    public String getExtension() {
        return extension;
    }

    /**
     *
     * @return масив байтів
     */
    public byte[] getByteArr() {
        return byteArr;
    }

}
