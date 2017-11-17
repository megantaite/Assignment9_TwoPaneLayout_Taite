package com.example.megan.assignment9_twopanelayout_taite;

import java.util.ArrayList;

/**
 * Created by Megan on 11/2/17.
 */

public class ArchSet {
    private static ArchSet archSet;
    private ArrayList<Arch> arch;

    private ArchSet(){
        arch = new ArrayList<Arch>();

        //expects String style, String pieceName, String descr, String timePeriod, int picId
        arch.add(new Arch("Romanesque","La Catedral de Zamora","Rooted in Roman architectural elements, this style swept across medieval Europe.\nSemi-circular arches and simple geometric shapes were the main elements featured in Romanesque structures.","800 to 1200 AD","Your comments: ",R.drawable.rcallig,R.drawable.lacatedraldezamora));
        arch.add(new Arch("Gothic","Burgos Cathedral","Gothic architecture - named after a tribe, the goths, in Europe, was an intricate style.\nBold risks in architecure were a direct result of the peace and prosperity of the time, which left more time for cultural pursuits. The pointed arch is the crown jewel of Gothic style.","1100 to 1450 AD","Your comments: ",R.drawable.gcallig,R.drawable.burgos));
        arch.add(new Arch("Art Nouveau","La Sagrada Familia","Ornate and exquisite are words used to descibe Art Nouveau, meaning New Art in French.\nThis architectural style came as a push-back to industrialization, choosing instead to emphasize craftsmanship.","1890 to 1914 AD","Your comments: ",R.drawable.acallig,R.drawable.sagradafamilia));
    }

    public static ArchSet getArchSet() {
        if(archSet == null){
            archSet = new ArchSet();
        }
        return archSet;
    }

    public ArrayList<Arch> getPeople() {
        return arch;
    }

    public Arch getArch(int id) {
        if(id < 0 || id >= arch.size()) return null;
        return arch.get(id);
    }

}
