package com.arabic.app.model.Tain_Sath;

/**
 * Created by Maziar on 12/15/2017.
 */

public class Dark_Matlab {

    private int id;
    private String title;
    private String rb_char1_dm;
    private String rb_char2_dm;
    private int id_correct;

    public Dark_Matlab(int i, String quiz) {
    }


    public Dark_Matlab(int id, String title, String rb_char1_dm, String rb_char2_dm, int id_correct) {
        this.id = id;
        this.title = title;
        this.rb_char1_dm = rb_char1_dm;
        this.rb_char2_dm = rb_char2_dm;
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

    public String getRb_char1_dm() {
        return rb_char1_dm;
    }

    public void setRb_char1_dm(String rb_char1_dm) {
        this.rb_char1_dm = rb_char1_dm;
    }

    public String getRb_char2_dm() {
        return rb_char2_dm;
    }

    public void setRb_char2_dm(String rb_char2_dm) {
        this.rb_char2_dm = rb_char2_dm;
    }

    public int getId_correct() {
        return id_correct;
    }

    public void setId_correct(int id_correct) {
        this.id_correct = id_correct;
    }
}
