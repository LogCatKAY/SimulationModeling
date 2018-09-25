package com.modeling.aleksey.modelinglab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mTableColumn_1p;
    private LinearLayout mTableColumn_2p;
    private LinearLayout mTableColumn_3p;
    private int mNumberFromTextViewTableOne[] = new int[10];
    private int mNumberFromTextViewTableTwo[] = new int[10];
    private int mNumberFromTextViewTableThree[] = new int[10];

    private LinearLayout mAlgoColumn_1p;
    private LinearLayout mAlgoColumn_2p;
    private LinearLayout mAlgoColumn_3p;
    private int mNumberFromTextViewAlgoOne[] = new int[10];
    private int mNumberFromTextViewAlgoTwo[] = new int[10];
    private int mNumberFromTextViewAlgoThree[] = new int[10];
    private int mSelfNumber[] = new int[10];
    //float textViewTextSize;

    private EditText mEditText_1;
    private EditText mEditText_2;
    private EditText mEditText_3;
    private EditText mEditText_4;
    private EditText mEditText_5;
    private EditText mEditText_6;
    private EditText mEditText_7;
    private EditText mEditText_8;
    private EditText mEditText_9;
    private EditText mEditText_10;

    private TextView mTextView_1;
    private TextView mTextView_2;
    private TextView mTextView_3;
    private TextView mTextView_4;
    private TextView mTextView_5;
    private TextView mTextView_6;
    private TextView mTextView_7;


    private void initTableColumns(LinearLayout tableColumn, int digitsCount){
        for(int i = 0; i <= 9; i++){

            TableTextView myTableTextView = new TableTextView(digitsCount);

            TextView textView = new TextView(MainActivity.this);
            LayoutParams textViewLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT);
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundResource(R.drawable.textview_table_style);
            textView.setLayoutParams(textViewLayoutParams);
            //textView.setMinHeight(47);
            textView.setText(String.valueOf(myTableTextView.getCurrentNumber()));
            tableColumn.addView(textView);
            //textViewTextSize = textView.getTextSize();

            switch (digitsCount){
                case 1:
                    mNumberFromTextViewTableOne[i] = myTableTextView.getCurrentNumber();
                    break;
                case 2:
                    mNumberFromTextViewTableTwo[i] = myTableTextView.getCurrentNumber();
                    break;
                case 3:
                    mNumberFromTextViewTableThree[i] = myTableTextView.getCurrentNumber();
                    break;
                default:
                    break;
            }

        }
    }

    private void initAlgoColumns(LinearLayout algoColumn, int digitsCount){
        for(int i = 0; i <= 9; i++){
            AlgoTextView myAlgoTextView = new AlgoTextView(digitsCount);

            TextView textView = new TextView(MainActivity.this);
            LayoutParams textViewLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT);
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundResource(R.drawable.textview_table_style);
            textView.setLayoutParams(textViewLayoutParams);
            //textView.setMinHeight(47);
            textView.setText(String.valueOf(myAlgoTextView.getCurrentNumber()));
            algoColumn.addView(textView);

            switch (digitsCount){
                case 1:
                    mNumberFromTextViewAlgoOne[i] = myAlgoTextView.getCurrentNumber();
                    break;
                case 2:
                    mNumberFromTextViewAlgoTwo[i] = myAlgoTextView.getCurrentNumber();
                    break;
                case 3:
                    mNumberFromTextViewAlgoThree[i] = myAlgoTextView.getCurrentNumber();
                    break;
                default:
                    break;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTableColumn_1p = (LinearLayout) findViewById(R.id.layout_tableColumn_1p);
        mTableColumn_2p = (LinearLayout) findViewById(R.id.layout_tableColumn_2p);
        mTableColumn_3p = (LinearLayout) findViewById(R.id.layout_tableColumn_3p);

        initTableColumns(mTableColumn_1p, 1);
        initTableColumns(mTableColumn_2p, 2);
        initTableColumns(mTableColumn_3p, 3);

        mAlgoColumn_1p = (LinearLayout) findViewById(R.id.layout_algoColumn_1p);
        mAlgoColumn_2p = (LinearLayout) findViewById(R.id.layout_algoColumn_2p);
        mAlgoColumn_3p = (LinearLayout) findViewById(R.id.layout_algoColumn_3p);

        initAlgoColumns(mAlgoColumn_1p, 1);
        initAlgoColumns(mAlgoColumn_2p, 2);
        initAlgoColumns(mAlgoColumn_3p, 3);

        mEditText_1 = (EditText) findViewById(R.id.et_1);
        mEditText_2 = (EditText) findViewById(R.id.et_2);
        mEditText_3 = (EditText) findViewById(R.id.et_3);
        mEditText_4 = (EditText) findViewById(R.id.et_4);
        mEditText_5 = (EditText) findViewById(R.id.et_5);
        mEditText_6 = (EditText) findViewById(R.id.et_6);
        mEditText_7 = (EditText) findViewById(R.id.et_7);
        mEditText_8 = (EditText) findViewById(R.id.et_8);
        mEditText_9 = (EditText) findViewById(R.id.et_9);
        mEditText_10 = (EditText) findViewById(R.id.et_10);

        mTextView_1 = (TextView) findViewById(R.id.tv_table_1p_criteria);
        mTextView_2 = (TextView) findViewById(R.id.tv_table_2p_criteria);
        mTextView_3 = (TextView) findViewById(R.id.tv_table_3p_criteria);
        mTextView_4 = (TextView) findViewById(R.id.tv_algo_1p_criteria);
        mTextView_5 = (TextView) findViewById(R.id.tv_algo_2p_criteria);
        mTextView_6 = (TextView) findViewById(R.id.tv_algo_3p_criteria);
        mTextView_7 = (TextView) findViewById(R.id.tv_self_criteria);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action:
                //Toast.makeText(this, String.valueOf(mNumberFromTextViewAlgoTwo[9]), Toast.LENGTH_SHORT).show();
                calculateCriteria(1);
                calculateCriteria(2);
                calculateCriteria(3);
                calculateCriteria(4);
                calculateCriteria(5);
                calculateCriteria(6);
                if(!TextUtils.isEmpty(mEditText_1.getText())) {
                    calculateCriteria(7);
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void calculateCriteria(int whichColumn){
        double criteria = 0;
        String str = "";



        if(whichColumn > 0 || whichColumn <= 6){
            switch (whichColumn){
                case 1:
//                    criteria = (Math.abs( (sum(1,9) / 9) -
//                            (double) (extractSumFromNumberArray(mNumberFromTextViewTableOne, 10) / 9))) /
//                            ( sum(1, 9) / 9 );


                    criteria = getCriteria(mNumberFromTextViewTableOne);

                    str = String.format("%.2f", criteria);
                    mTextView_1.setText(str);
                    break;
                case 2:
//                    criteria = (Math.abs( (sum(10, 99) / 90) -
//                            (double) (extractSumFromNumberArray(mNumberFromTextViewTableTwo, 10) / 90))) /
//                            ( sum(10, 99) / 90 );

                    criteria = getCriteria(mNumberFromTextViewTableTwo);

                    str = String.format("%.2f", criteria);
                    mTextView_2.setText(str);
                    break;
                case 3:
//                    criteria = (Math.abs( (sum(100, 999) / 900) -
//                            (double) (extractSumFromNumberArray(mNumberFromTextViewTableThree, 10) / 900))) /
//                            ( sum(100, 999) / 900 );

                    criteria = getCriteria(mNumberFromTextViewTableThree);

                    str = String.format("%.2f", criteria);
                    mTextView_3.setText(str);
                    break;
                case 4:
//                    criteria = (Math.abs( (sum(1,9) / 9) -
//                            (double) (extractSumFromNumberArray(mNumberFromTextViewAlgoOne, 10) / 9))) /
//                            ( sum(1, 9) / 9 );

                    criteria = getCriteria(mNumberFromTextViewAlgoOne);

                    str = String.format("%.2f", criteria);
                    mTextView_4.setText(str);
                    break;
                case 5:
//                    criteria = (Math.abs( (sum(10, 99) / 90) -
//                            (double) (extractSumFromNumberArray(mNumberFromTextViewAlgoTwo, 10) / 90))) /
//                            ( sum(10, 99) / 90 );

                    criteria = getCriteria(mNumberFromTextViewAlgoTwo);

                    str = String.format("%.2f", criteria);
                    mTextView_5.setText(str);
                    break;
                case 6:
//                    criteria = (Math.abs( (sum(100, 999) / 900) -
//                            (double) (extractSumFromNumberArray(mNumberFromTextViewAlgoThree, 10) / 900))) /
//                            ( sum(100, 999) / 900 );

                    criteria = getCriteria(mNumberFromTextViewAlgoThree);

                    str = String.format("%.2f", criteria);
                    mTextView_6.setText(str);
                    break;
                case 7:
                    mSelfNumber[0] = Integer.parseInt(mEditText_1.getText().toString());
                    mSelfNumber[1] = Integer.parseInt(mEditText_2.getText().toString());
                    mSelfNumber[2] = Integer.parseInt(mEditText_3.getText().toString());
                    mSelfNumber[3] = Integer.parseInt(mEditText_4.getText().toString());
                    mSelfNumber[4] = Integer.parseInt(mEditText_5.getText().toString());
                    mSelfNumber[5] = Integer.parseInt(mEditText_6.getText().toString());
                    mSelfNumber[6] = Integer.parseInt(mEditText_7.getText().toString());
                    mSelfNumber[7] = Integer.parseInt(mEditText_8.getText().toString());
                    mSelfNumber[8] = Integer.parseInt(mEditText_9.getText().toString());
                    mSelfNumber[9] = Integer.parseInt(mEditText_10.getText().toString());

                    criteria = getCriteria(mSelfNumber);
                    str = String.format("%.2f", criteria);
                    mTextView_7.setText(str);
                    break;
                default:
                    break;

            }

        }

    }

//    private int extractSumFromNumberArray(int array[], int size){
//        int sum = 0;
//        for(int i = 0; i < size; i++){
//            sum += array[i];
//        }
//        return sum;
//    }
//
//    private int sum(int min, int max){
//        int sum = 0;
//        for(int temp = min; temp <= max; temp++){
//            sum += temp;
//        }
//        return sum;
//    }

    private double getCriteria(int mNumberArray[]){

        int newArr[] = new int[9];

        for(int i = 0; i < 9; i ++){
            newArr[i] = Math.abs(mNumberArray[i] - mNumberArray[i+1]);
        }
        int temp;
        int counter;
        ArrayList allNumbers = new ArrayList();
        ArrayList newArrayListCounters = new ArrayList();
        for(int i = 0; i < 9; i++){
            counter = 0;
            temp = newArr[i];
            if(!allNumbers.contains(temp)){
                allNumbers.add(temp);
                for (int j = 0; j < 9; j++){
                    if(temp == newArr[j]){
                        counter++;
                    }
                }
//                            if (counter == 1){
//                                counter = 0;
//                            }
                if(!newArrayListCounters.contains(counter)){
                    newArrayListCounters.add(counter);
                }
            }

        }

        int max = 0;
        temp = 0;
        for(int i = 0; i < newArrayListCounters.size(); i++){
            temp = (int)newArrayListCounters.get(i);
            if (max < temp){
                max = temp;
            }
        }
        return (double) max / mNumberArray.length;
    }




}
