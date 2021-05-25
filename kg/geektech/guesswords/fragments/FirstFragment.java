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

import kg.geektech.guesswords.onBackePressed.IOnBackPressed;
import kg.geektech.guesswords.R;
import kg.geektech.guesswords.base.BaseFragment;

public class FirstFragment extends BaseFragment implements IOnBackPressed {

    private EditText editText;
    private Button btnCheck;
    private String key = "зима";
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;

    public FirstFragment() {
    }

    @Override
    protected void showToast(String s) {
        super.showToast(s);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        initViews(view);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals(key)) {
                    showToast("Вы угадали первое слово!");
                    btnCheck.setBackgroundColor(Color.MAGENTA);

                    Fragment fragment = new SecondFragment();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("first_fragment"));
                    transaction.replace(R.id.fragment_container, fragment, "second_fragment");
                    transaction.addToBackStack("first_fragment");
                    transaction.isAddToBackStackAllowed();
                    transaction.commit();

                } else {
                    showToast("Вы не угадали, попробуйте снова!");
                }
            }
        });
    }

    private void initViews(View view) {
        image1 = view.findViewById(R.id.second_imageView1);
        image2 = view.findViewById(R.id.second_imageView2);
        image3 = view.findViewById(R.id.imageView3);
        image4 = view.findViewById(R.id.imageView4);
        editText = view.findViewById(R.id.edit_text);
        btnCheck = view.findViewById(R.id.btn_check);
    }

    @Override
    public boolean onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
        return true;
    }
}