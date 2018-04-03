package com.arabic.app.model.Tain_Sath;

/**
 * Created by Maziar on 12/15/2017.
 */

public class Truefalse {

    private int id;
    private String title;
    private String rb_true;
    private String rb_false;
    private int id_correct;

    public Truefalse(int i, String quiz) {
    }

    public Truefalse(int id, String title, String rb_true, String rb_false, int id_correct) {
        this.id = id;
        this.title = title;
        this.rb_true = rb_true;
        this.rb_false = rb_false;
        this.id_correct = id_correct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRb_true() {
        return rb_true;
    }

    public void setRb_true(String rb_true) {
        this.rb_true = rb_true;
    }

    public String getRb_false() {
        return rb_false;
    }

    public void setRb_false(String rb_false) {
        this.rb_false = rb_false;
    }

    public int getId_correct() {
        return id_correct;
    }

    public void setId_correct(int id_correct) {
        this.id_correct = id_correct;
    }
}
