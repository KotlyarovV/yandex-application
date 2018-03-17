package com.example.vitaly.yandexapplication;

import android.graphics.Color;

import java.util.Date;

/**
 * Created by Vitaly on 17.03.2018.
 */

public class ListNote {

    private Color color;
    private String caption;
    private String description;
    private Date creationDate;

    public ListNote(Color color, String caption, String description, Date creationDate) {
        this.color = color;
        this.caption = caption;
        this.description = description;
        this.creationDate = creationDate;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
