/* package com.example.missuniverse;

import java.util.ArrayList;
import java.util.Collection;

 public class BiodataData {
    public static String[][] data = new String[][]{
            {"Ximena Navarrete", "1.74 M", "https://upload.wikimedia.org/wikipedia/commons/0/06/Ximena_Navarrete_-_Miss_Universe_2010.jpg"},
            {"Leila Lopes", "1.74 M", "https://upload.wikimedia.org/wikipedia/commons/d/d6/Miss-universe-2011-leila-lopes.jpg"},
            {"Olivia Culpo", "1.74 M", "https://upload.wikimedia.org/wikipedia/commons/b/b7/Olivia_Culpo_2012.jpg"},
            {"Gabriela Isler", "1.74 M", "https://upload.wikimedia.org/wikipedia/commons/7/7f/Mar%C3%ADa_Gabriela_Isler_cropped.jpg"},
            {"Paulina Vega", "1.74 M", "https://upload.wikimedia.org/wikipedia/commons/6/6e/Paulina_Vega_Colombia_Moda_white.jpg"},
            {"Pia Wurtzbach ", "1.74 M", "https://upload.wikimedia.org/wikipedia/commons/2/23/Miss_Universe_2015_Pia_Wurtzbach_waves_to_the_Malacanang_Press_%28cropped%29.jpg"},
            {"Iris Mittanaere", "1.74 M", "https://upload.wikimedia.org/wikipedia/commons/1/12/Iris_Mittenaere_2016.jpg"}
    };

    public static Collection<? extends MissUniverse> getListBioData() {
        Biodata biodata = null;
        ArrayList<Biodata> list = new ArrayList<>();
        for (String[] aData : data) {
            biodata = new Biodata();
            biodata.setNama(aData[0]);
            biodata.setTinggi(aData[1]);
            biodata.setPhoto(aData[2]);

            list.add(biodata);
        }

        return null;
    } */