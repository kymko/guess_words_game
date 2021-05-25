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


public class ThirdFragment extends BaseFragment implements IOnBackPressed {

    private ImageView third_image1;
    private ImageView third_image2;
    private ImageView third_image3;
    private ImageView third_image4;
    private Button btnChek;
    private EditText edText;
    private String key3 = "кран";

    public ThirdFragment() {
    }

    @Override
    protected void showToast(String message) {
        super.showToast(message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_third, container, false);

        initViews(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnChek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edText.getText().toString().equals(key3)) {
                    Fragment fragment = new MainFragment();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, fragment, "third_fragment");
                    transaction.addToBackStack("second_fragment");
                    transaction.isAddToBackStackAllowed();
                    transaction.commit();
                    showToast("Вы угадали третье слово!ПОЗДРАВЛЯЕМ!!!");
                    btnChek.setBackgroundColor(Color.GREEN);
                } else {
                    showToast("Вы не угадали, попоробуйте снова!");
                }
            }
        });
    }

    private void initViews(View view) {
        third_image1 = view.findViewById(R.id.third_imageView1);
        third_image2 = view.findViewById(R.id.third_imageView2);
        third_image3 = view.findViewById(R.id.third_imageView3);
        third_image4 = view.findViewById(R.id.third_imageView4);
        edText = view.findViewById(R.id.third_edit_text);
        btnChek = view.findViewById(R.id.third_btn_check);
    }

    @Override
    public boolean onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
        return true;
    }
}