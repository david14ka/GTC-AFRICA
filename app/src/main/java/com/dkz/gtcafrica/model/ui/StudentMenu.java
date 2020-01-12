package com.dkz.gtcafrica.model.ui;

import java.util.List;

public class StudentMenu {

    private String title;
    private String subTile;
    private List<String> studentButtons;
    private boolean isException = false;

    public StudentMenu(String title) {
        this.title = title;
    }

    public StudentMenu(String title, List<String> studentButtons) {
        this.title = title;
        this.studentButtons = studentButtons;
    }

    public StudentMenu(String title, List<String> studentButtons, boolean isException) {
        this.title = title;
        this.studentButtons = studentButtons;
        this.isException = isException;
    }

    public StudentMenu(String title, String subTile, List<String> studentButtons) {
        this.title = title;
        this.subTile = subTile;
        this.studentButtons = studentButtons;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<String> getStudentButtons() {
        return studentButtons;
    }

    public void setStudentButtons(List<String> studentButtons) {
        this.studentButtons = studentButtons;
    }

    public boolean isException() {
        return isException;
    }

    public void setException(boolean exception) {
        isException = exception;
    }

    public String getSubTile() {
        return subTile;
    }

    public void setSubTile(String subTile) {
        this.subTile = subTile;
    }
}
