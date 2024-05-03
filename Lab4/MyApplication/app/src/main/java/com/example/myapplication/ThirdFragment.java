package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView textRecipeTitle, textRecipeDescription;
    private Button buttonShowRecipe;
    private String[] recipeTitles = {
            "Spaghetti Carbonara",
            "Chicken Stir-Fry",
            "Caprese Salad",
            "Pumpkin Soup",
            "Grilled Salmon",
            "Mushroom Risotto"
    };

    private String[] recipeDescriptions = {
            "Delicious Italian pasta dish made with eggs, cheese, bacon, and black pepper.",
            "Healthy and flavorful chicken stir-fry with vegetables and soy sauce.",
            "Classic Italian salad made with fresh tomatoes, mozzarella cheese, basil, and olive oil.",
            "Creamy and comforting soup made with roasted pumpkin, onions, and spices.",
            "Juicy and flavorful salmon fillet grilled to perfection and served with lemon wedges.",
            "Creamy and savory Italian rice dish cooked with mushrooms, onions, and Parmesan cheese."
    };

    public ThirdFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
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
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        textRecipeTitle = view.findViewById(R.id.textRecipeTitle);
        textRecipeDescription = view.findViewById(R.id.textRecipeDescription);
        buttonShowRecipe = view.findViewById(R.id.buttonShowRecipe);

        buttonShowRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int index = random.nextInt(recipeTitles.length);

                textRecipeTitle.setText(recipeTitles[index]);
                textRecipeDescription.setText(recipeDescriptions[index]);
            }
        });

        return view;
    }

}