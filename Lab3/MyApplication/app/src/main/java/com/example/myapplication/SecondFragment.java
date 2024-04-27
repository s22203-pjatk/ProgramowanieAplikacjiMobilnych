package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.TextUtils;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText ageEditText, massEditText, heightEditText;
    private Switch genderSwitch;
    private Button calculateButton;
    private TextView resultTextView;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        ageEditText = view.findViewById(R.id.ageNumberBMR);
        massEditText = view.findViewById(R.id.massNumberBMR);
        heightEditText = view.findViewById(R.id.heightNumberBMR);
        genderSwitch = view.findViewById(R.id.switchMaleFemale);
        calculateButton = view.findViewById(R.id.buttonBMR);
        resultTextView = view.findViewById(R.id.BMRresult);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMR();
            }
        });

        return view;
    }

    private void calculateBMR() {
        String ageStr = ageEditText.getText().toString().trim();
        String massStr = massEditText.getText().toString().trim();
        String heightStr = heightEditText.getText().toString().trim();

        if (TextUtils.isEmpty(ageStr) || TextUtils.isEmpty(massStr) || TextUtils.isEmpty(heightStr)) {
            resultTextView.setText("Error");
            return;
        }

        int age = Integer.parseInt(ageStr);
        double mass = Double.parseDouble(massStr);
        double height = Double.parseDouble(heightStr);

        double bmr;
        if (genderSwitch.isChecked()) {
            bmr = 655 + (9.6 * mass) + (1.8 * height) - (4.7 * age); // Female
        } else {
            bmr = 66 + (13.7 * mass) + (5 * height) - (6.8 * age); // Male
        }

        resultTextView.setText(String.format("%.2f", bmr));
    }
}