package com.example.megan.assignment9_twopanelayout_taite;

/**
 * Created by Megan on 11/2/17.
 */

public class Arch {

    String style;
    String timePeriod;
    String elementName;
    String descr;
    String comments;
    int typePicId;
    int elePicId;

    public Arch(String style, String elementName, String descr, String timePeriod, String comments, int typePicId, int elePicId) {
        this.style = style;
        this.elementName = elementName;
        this.descr = descr;
        this.timePeriod = timePeriod;
        this.comments = comments;
        this.typePicId = typePicId;
        this.elePicId = elePicId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getTypePicId() {
        return typePicId;
    }

    public void setTypePicId(int typePicId) {
        this.typePicId = typePicId;
    }

    public int getElePicId() {
        return elePicId;
    }

    public void setElePicId(int elePicId) {
        this.elePicId = elePicId;
    }
}
