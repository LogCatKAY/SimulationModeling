package com.modeling.aleksey.modelinglab1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.text.TextUtilsCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NormalDistributionFragment extends Fragment {


    public NormalDistributionFragment() {
        // Required empty public constructor
    }

    private EditText etNormMinX;
    private EditText etNormMaxX;
    private EditText etU;
    private EditText etQ;
    private Button btnBuildNormGraph;
    private double minX;
    private double maxX;
    private double u;
    private double q;

    private View.OnClickListener btnBuildNormGraphOnClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(
                            !TextUtils.isEmpty(etNormMinX.getText()) &&
                                    !TextUtils.isEmpty(etNormMaxX.getText()) &&
                                    !TextUtils.isEmpty(etU.getText()) &&
                                    !TextUtils.isEmpty(etQ.getText())
                            ) {
                        minX = Double.parseDouble(etNormMinX.getText().toString());
                        maxX = Double.parseDouble(etNormMaxX.getText().toString());
                        u = Double.parseDouble(etU.getText().toString());
                        q = Double.parseDouble(etQ.getText().toString());

                        Intent intent = new Intent(
                                getActivity(),
                                Graphics2Activity.class);
                        intent.putExtra(Graphics2Activity.MIN_X,minX);
                        intent.putExtra(Graphics2Activity.MAX_X,maxX);
                        intent.putExtra(Graphics2Activity.U,u);
                        intent.putExtra(Graphics2Activity.Q,q);

                        startActivity(intent);

                    } else {

                        Toast.makeText(
                                getActivity(),
                                "Повторите ввод",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_normal_distribution, container, false);

        etNormMinX = (EditText) view.findViewById(R.id.etNormMinX);
        etNormMaxX = (EditText) view.findViewById(R.id.etNormMaxX);
        etU = (EditText) view.findViewById(R.id.etU);
        etQ = (EditText) view.findViewById(R.id.etQ);
        btnBuildNormGraph = (Button) view.findViewById(R.id.btnBuildNormGraph);

        btnBuildNormGraph.setOnClickListener(btnBuildNormGraphOnClickListener);

        return view;
    }

}
