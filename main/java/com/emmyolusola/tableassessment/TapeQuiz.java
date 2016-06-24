package com.emmyolusola.tableassessment;

/**
 * Created by Emmyolusola on 4/25/2016.
 */
public class TapeQuiz {

    private String tapeTitle;
    private String tapeNumber;

    public String getTapeTitle() {
        return tapeTitle;
    }

    public void setTapeTitle(String tapeTitle) {
        this.tapeTitle = tapeTitle;
    }

    public String getTapeNumber() {
        return tapeNumber;
    }

    public void setTapeNumber(String tapeNumber) {
        this.tapeNumber = tapeNumber;
    }

    public TapeQuiz(String tapeTitle, String tapeNumber){

        this.tapeNumber = tapeNumber;
        this.tapeTitle = tapeTitle;

    }
}
