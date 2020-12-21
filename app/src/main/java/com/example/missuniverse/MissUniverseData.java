package com.example.missuniverse;

import java.util.ArrayList;

public class MissUniverseData {
    public static String[][] data = new String[][]{
            {"Ximena Navarrete", "Miss Universe 2010", "https://upload.wikimedia.org/wikipedia/commons/0/06/Ximena_Navarrete_-_Miss_Universe_2010.jpg"},
            {"Leila Lopes", "Miss Universe 2011", "https://upload.wikimedia.org/wikipedia/commons/d/d6/Miss-universe-2011-leila-lopes.jpg"},
            {"Olivia Culpo", "Miss Universe 2012", "https://upload.wikimedia.org/wikipedia/commons/b/b7/Olivia_Culpo_2012.jpg"},
            {"Gabriela Isler", "Miss Universe 2013", "https://upload.wikimedia.org/wikipedia/commons/7/7f/Mar%C3%ADa_Gabriela_Isler_cropped.jpg"},
            {"Paulina Vega", "Miss Universe 2014", "https://upload.wikimedia.org/wikipedia/commons/6/6e/Paulina_Vega_Colombia_Moda_white.jpg"},
            {"Pia Wurtzbach ", "Miss Universe 2015", "https://upload.wikimedia.org/wikipedia/commons/2/23/Miss_Universe_2015_Pia_Wurtzbach_waves_to_the_Malacanang_Press_%28cropped%29.jpg"},
            {"Iris Mittanaere", "Miss Universe 2016", "https://upload.wikimedia.org/wikipedia/commons/1/12/Iris_Mittenaere_2016.jpg"}
    };

    public static ArrayList<MissUniverse> getListData(){
        MissUniverse missUniverse = null;
        ArrayList<MissUniverse> list = new ArrayList<>();
        for (String[] aData : data) {
            missUniverse = new MissUniverse();
            missUniverse.setName(aData[0]);
            missUniverse.setRemarks(aData[1]);
            missUniverse.setPhoto(aData[2]);

            list.add(missUniverse);
        }

        return list;
    }

    public static ArrayList<MissUniverse> searchListData(int message){
        MissUniverse missUniverse = null;
        ArrayList<MissUniverse> list = new ArrayList<>();

        missUniverse = new MissUniverse();
        missUniverse.setName(data[0][0]);

        list.add(missUniverse);

        return  list;
    }
}
