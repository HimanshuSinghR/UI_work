package com.example.polloptions.Model;

import android.widget.ProgressBar;
import android.widget.TextView;

public class progressBar_Class {


    public TextView percentbox;
    public ProgressBar progressBar;
    public int id;
    public int bar_count;
    public TextView getPercentbox() {
        return percentbox;
    }

    public void setPercentbox(TextView percentbox) {
        this.percentbox = percentbox;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBar_count() {
        return bar_count;
    }

    public void setBar_count(int bar_count) {
        this.bar_count = bar_count;
    }

    public progressBar_Class(int id, int bar_count) {
        this.id = id;
        this.bar_count = bar_count;
    }

    public progressBar_Class() {
    }
    public progressBar_Class(ProgressBar progressBar, int id, int bar_count) {
        this.progressBar = progressBar;
        this.id = id;
        this.bar_count = bar_count;
    }

}
