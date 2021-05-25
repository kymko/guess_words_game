package kg.geektech.guesswords.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import kg.geektech.guesswords.base.BaseFragment;
import kg.geektech.guesswords.onBackePressed.IOnBackPressed;
import kg.geektech.guesswords.R;

public class SecondFragment extends BaseFragment implements IOnBackPressed {

    private ImageView second_image1;
    private ImageView second_image2;
    private ImageView second_image3;
    private ImageView second_image4;
    private Button btnChek;
    private EditText edText;
    private String key2 = "яд";


    public SecondFragment() {
    }


    @Override
    protected void showToast(String message) {
        super.showToast(message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        initViews(view);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnChek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edText.getText().toString().equals(key2)) {
                    showToast("Вы угадали второе слово!");
                    btnChek.setBackgroundColor(Color.MAGENTA);
                    Fragment fragment = new ThirdFragment();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("second_fragment"));
                    transaction.addToBackStack("first_fragment");
                    transaction.isAddToBackStackAllowed();
                    transaction.replace(R.id.fragment_container, fragment, "second_fragment");
                    transaction.commit();
                } else {
                    showToast("Вы не угадали слово, попробуйте снова!");
                }
            }
        });
    }

    private void initViews(View view) {
        second_image1 = view.findViewById(R.id.second_imageView1);
        second_image2 = view.findViewById(R.id.second_imageView2);
        second_image3 = view.findViewById(R.id.second_imageView3);
        second_image4 = view.findViewById(R.id.second_imageView4);
        btnChek = view.findViewById(R.id.second_btn_check);
        edText = view.findViewById(R.id.second_edit_text);
    }

    @Override
    public boolean onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
        return true;
    }
}
