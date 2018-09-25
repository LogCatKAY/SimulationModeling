package com.modeling.aleksey.modelinglab2;

import java.util.Random;

/**
 * Created by korchagin on 29.03.18.
 */

public class TableTextView {

    private static final int MAX_TABLE_TEXT_VIEW_COUNT = 30;
    private static int sNumberOfTextView = 0;

    private final Random mRandom = new Random();

    private int mDigitsCount;
    private int mCurrentNumber;

    private int mTableOne[] = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9,
            1, 2, 3, 4, 5, 6, 7, 8, 9,
            1, 2, 3, 4, 5, 6, 7, 8, 9,
            1, 2, 3
    };

    private int mTableTwo[] = new int[]{
            95, 81, 80, 70, 56, 71, 84, 94, 77, 16,
            84, 12, 98, 63, 67, 19, 26, 61, 88, 53,
            61, 64, 36, 60, 34, 13, 56, 90, 89, 99
    };

    private int mTableThree[] = new int[]{
            769, 434, 896, 837, 712, 580, 718, 628, 528, 662,
            930, 849, 341, 665, 275, 442, 114, 615, 241, 142,
            608, 190, 569, 818, 875, 527, 994, 996, 242, 595
    };

    TableTextView(int digitsCount) throws IllegalArgumentException{
        if(digitsCount <= 3 && digitsCount > 0){
            mDigitsCount = digitsCount;
            if(sNumberOfTextView < MAX_TABLE_TEXT_VIEW_COUNT){
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

    public void setRerandomedCurrentNumber(int digitsCount){

        int counter = mRandom.nextInt(30);

        switch (digitsCount){
            case 1:
                mCurrentNumber = mTableOne[counter];
                break;
            case 2:
                mCurrentNumber = mTableTwo[counter];
                break;
            case 3:
                mCurrentNumber = mTableThree[counter];
                break;
        }
        //return mCurrentNumber;
    }

    public int getNumberOfTextView() {
        return sNumberOfTextView;
    }

    public int getDigitsCount() {
        return mDigitsCount;
    }

    public int getCurrentNumber() {
        return mCurrentNumber;
    }
}
