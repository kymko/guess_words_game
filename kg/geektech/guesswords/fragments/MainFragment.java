package kg.geektech.guesswords.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kg.geektech.guesswords.R;
import kg.geektech.guesswords.activities.SecondActivity;

public class MainFragment extends Fragment {

    private Button btnLevel_1;
    private Button btnLevel_2;
    private Button btnLevel_3;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    SecondActivity secondActivity;

    public MainFragment() {

    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        btnLevel_1 = view.findViewById(R.id.btn_level_1);
        btnLevel_2 = view.findViewById(R.id.btn_level_2);
        btnLevel_3 = view.findViewById(R.id.btn_level_3);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnLevel_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FirstFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,fragment,"first_fragment");
                transaction.addToBackStack("first_fragment");
                transaction.isAddToBackStackAllowed();
                transaction.commit();
            }
        });

        btnLevel_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SecondFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,fragment,"second_fragment");
                transaction.addToBackStack("second_fragment");
                transaction.isAddToBackStackAllowed();
                transaction.commit();
            }
        });

        btnLevel_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ThirdFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,fragment,"third_fragment");
                transaction.addToBackStack("second_fragment");
                transaction.isAddToBackStackAllowed();
                transaction.commit();
            }
        });
    }
}