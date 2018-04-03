package com.arabic.app.model.Tain_Sath;

/**
 * Created by Maziar on 12/15/2017.
 */

public class Motazad {

    private int id;
    private String title;
    private String rb_motazad;
    private String rb_motradef;
    private int correct;

    public Motazad() {
    }

    public Motazad(int id, String title, String rb_motazad, String rb_motradef, int correct) {
        this.id = id;
        this.title = title;
        this.rb_motazad = rb_motazad;
        this.rb_motradef = rb_motradef;
        this.correct = correct;
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

    public String getRb_motazad() {
        return rb_motazad;
    }

    public void setRb_motazad(String rb_motazad) {
        this.rb_motazad = rb_motazad;
    }

    public String getRb_motradef() {
        return rb_motradef;
    }

    public void setRb_motradef(String rb_motradef) {
        this.rb_motradef = rb_motradef;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
}
