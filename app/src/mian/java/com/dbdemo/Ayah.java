package com.example.dbdemo;

public class Ayah {
    private String ayah;
    private String urduTranslation;

    public Ayah(String ayah, String urduTranslation, String englishTranslation) {
        this.ayah = ayah;
        this.urduTranslation = urduTranslation;
        this.englishTranslation = englishTranslation;
    }

    public String getAyah() {
        return ayah;
    }

    public void setAyah(String ayah) {
        this.ayah = ayah;
    }

    public String getUrduTranslation() {
        return urduTranslation;
    }

    public void setUrduTranslation(String urduTranslation) {
        this.urduTranslation = urduTranslation;
    }

    public String getEnglishTranslation() {
        return englishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        this.englishTranslation = englishTranslation;
    }

    private String englishTranslation;
}
