package com.arabic.app.model.model_azmoon_9;

/**
 * Created by Maziar on 12/15/2017.
 */

public class Model_Azmoon_9_6 {

    private int id;
    private String title;

    private String rb_char2;
    private String rb_char3;
    private int id_correct;

    public Model_Azmoon_9_6(int i, String quiz) {
    }

    public Model_Azmoon_9_6(int id, String title, String rb_char2, String rb_char3, int id_correct) {
        this.id = id;
        this.title = title;
        this.rb_char2 = rb_char2;
        this.rb_char3 = rb_char3;
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



    public String getRb_char2() {
        return rb_char2;
    }

    public void setRb_char2(String rb_char2) {
        this.rb_char2 = rb_char2;
    }

    public String getRb_char3() {
        return rb_char3;
    }

    public void setRb_char3(String rb_char3) {
        this.rb_char3 = rb_char3;
    }

    public int getId_correct() {
        return id_correct;
    }

    public void setId_correct(int id_correct) {
        this.id_correct = id_correct;
    }
}
