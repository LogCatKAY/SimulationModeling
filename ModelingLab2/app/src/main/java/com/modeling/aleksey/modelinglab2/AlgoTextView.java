package com.modeling.aleksey.modelinglab2;

/**
 * Created by korchagin on 30.03.18.
 */

public class AlgoTextView {

    private static final int MAX_ALGO_TEXT_VIEW_COUNT = 30;
    private static int sNumberOfTextView = 0;


    private int mDigitsCount;
    private int mCurrentNumber;

    AlgoTextView(int digitsCount) throws IllegalArgumentException{
        if(digitsCount <= 3 && digitsCount > 0){
            mDigitsCount = digitsCount;
            if(sNumberOfTextView < MAX_ALGO_TEXT_VIEW_COUNT){
                sNumberOfTextView++;
                setRerandomedCurrentNumber(digitsCount);
            } else {
                sNumberOfTextView = 0;
                sNumberOfTextView++;
                setRerandomedCurrentNumber(digitsCount);
            }
        } else {
            throw new IllegalArgumentException("must be between 1, 2 or 3");
        }
    }

    public int getCurrentNumber() {
        return mCurrentNumber;
    }

    public int getDigitsCount() {
        return mDigitsCount;
    }

    private void setRerandomedCurrentNumber(int digitsCount){
        int max = 0;
        int min = 0;
        int range = 0;
        switch (digitsCount){
            case 1:
                max = 9;
                min = 1;
                range = max - min + 1;
                mCurrentNumber = (int)(Math.random() * range) + min;
                break;
            case 2:
                max = 99;
                min = 10;
                range = max - min + 1;
                mCurrentNumber = (int)(Math.random() * range) + min;
                break;
            case 3:
                max = 999;
                min = 100;
                range = max - min + 1;
                mCurrentNumber = (int)(Math.random() * range) + min;
                break;
            default:
                break;
        }
        //return mCurrentNumber;
    }

}
