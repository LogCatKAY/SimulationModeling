package com.modeling.aleksey.modelinglab1;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UniformDistributionFragment extends Fragment {


    public UniformDistributionFragment() {
        // Required empty public constructor
    }

    private EditText etMinX;
    private EditText etMaxX;
    private EditText etA;
    private EditText etB;
    private Button btnBuildGraph;
    private double minX;
    private double maxX;
    private double a;
    private double b;

    private View.OnClickListener btnBuildGraphOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(
                    !etMinX.getText().toString().isEmpty() &&
                            !etMaxX.getText().toString().isEmpty() &&
                            !etA.getText().toString().isEmpty() &&
                            !etB.getText().toString().isEmpty()
                    ) {
                minX = Double.parseDouble(etMinX.getText().toString());
                maxX = Double.parseDouble(etMaxX.getText().toString());
                a = Double.parseDouble(etA.getText().toString());
                b = Double.parseDouble(etB.getText().toString());

                Intent intent = new Intent(
                        getActivity(),
                        GraphicsActivity.class);
                intent.putExtra("minX",minX);
                intent.putExtra("maxX",maxX);
                intent.putExtra("a",a);
                intent.putExtra("b",b);

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
        View view = inflater.inflate(R.layout.fragment_uniform_distribution, container, false);

        etMinX = (EditText) view.findViewById(R.id.etMinX);
        etMaxX = (EditText) view.findViewById(R.id.etMaxX);
        etA = (EditText) view.findViewById(R.id.etA);
        etB = (EditText) view.findViewById(R.id.etB);
        btnBuildGraph = (Button) view.findViewById(R.id.btnBuildGraph);

        btnBuildGraph.setOnClickListener(btnBuildGraphOnClickListener);

        return view;
    }

}
