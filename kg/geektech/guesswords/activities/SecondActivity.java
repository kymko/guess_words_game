package kg.geektech.guesswords.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import kg.geektech.guesswords.onBackePressed.IOnBackPressed;
import kg.geektech.guesswords.R;
import kg.geektech.guesswords.fragments.MainFragment;

public class SecondActivity extends AppCompatActivity {

    private Button btnAddFragment;
    private boolean opened = false;
    private Button btnExit;

    public SecondActivity () {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitvity);

        initViews();
        btnAddFragmentClick();
        btnExitClick();

    }



    private void btnExitClick() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(SecondActivity.this).create();
                alertDialog.setTitle("Внимание!");
                alertDialog.setMessage("Вы действительно хотите выйти?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
    }

    private void btnAddFragmentClick() {
        btnAddFragment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container, MainFragment.newInstance("word 1 ", "word 2"));
                transaction.addToBackStack("first_fragment");
                transaction.isAddToBackStackAllowed();
                transaction.commit();
                btnAddFragment.setVisibility(View.INVISIBLE);
                btnExit.setVisibility(View.INVISIBLE);
                opened = true;
            }
        });
    }


    private void initViews() {
        btnAddFragment = findViewById(R.id.btn_add_fragment);
        btnExit = findViewById(R.id.btn_exit);

    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (!(fragment instanceof IOnBackPressed) || !((IOnBackPressed) fragment).onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void positiveToast(){
        Toast.makeText(SecondActivity.this,"Вы угадали",Toast.LENGTH_SHORT).show();

    }

    public void negativeToast(){
        Toast.makeText(SecondActivity.this,"Вы не угадали, попробуйте снова!",Toast.LENGTH_SHORT).show();

    }
}