package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LineChart lineChartBMI;

    public FirstFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonBMI = view.findViewById(R.id.buttonBMI);
        final EditText massNumber = view.findViewById(R.id.massNumber);
        final EditText heightNumber = view.findViewById(R.id.heightNumber);
        final TextView BMIresult = view.findViewById(R.id.BMIresult);
        lineChartBMI = view.findViewById(R.id.lineChartBMI);

        buttonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String massStr = massNumber.getText().toString();
                String heightStr = heightNumber.getText().toString();

                if (!massStr.isEmpty() && !heightStr.isEmpty()) {
                    String bmi = BmiCalculator.calculateBMI(massStr, heightStr);
                    BMIresult.setText(bmi);
                    addSampleDataToChart(Float.parseFloat(bmi));
                } else {
                    BMIresult.setText("Error");
                }
            }
        });
    }

    private void addSampleDataToChart(float bmiValue) {
        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(0, 20));
        entries.add(new Entry(1, bmiValue));

        LineDataSet dataSet = new LineDataSet(entries, "BMI in time");
        LineData lineData = new LineData(dataSet);
        lineChartBMI.setData(lineData);

        Description description = new Description();
        lineChartBMI.setDescription(description);
        lineChartBMI.invalidate();
    }
}