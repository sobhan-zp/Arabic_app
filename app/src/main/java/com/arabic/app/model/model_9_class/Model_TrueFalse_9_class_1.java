package com.arabic.app.model.model_9_class;

/**
 * Created by Maziar on 12/15/2017.
 */

public class Model_TrueFalse_9_class_1 {

    private int id;
    private String title;
    private String rb_char1;
    private String rb_char2;

    private int id_correct;

    public Model_TrueFalse_9_class_1(int i, String quiz) {
    }

    public Model_TrueFalse_9_class_1(int id, String title, String rb_char1, String rb_char2, int id_correct) {
        this.id = id;
        this.title = title;
        this.rb_char1 = rb_char1;
        this.rb_char2 = rb_char2;
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

    public String getRb_char1() {
        return rb_char1;
    }

    public void setRb_char1(String rb_char1) {
        this.rb_char1 = rb_char1;
    }

    public String getRb_char2() {
        return rb_char2;
    }

    public void setRb_char2(String rb_char2) {
        this.rb_char2 = rb_char2;
    }

    public int getId_correct() {
        return id_correct;
    }

    public void setId_correct(int id_correct) {
        this.id_correct = id_correct;
    }
}
