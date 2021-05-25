package kg.geektech.guesswords.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import kg.geektech.guesswords.R;

public class FirstLevel extends AppCompatActivity {

    private EditText editText;
    private Button btnCheck;
    private String key = "зима";
    private String key2 = "яд";
    private String key3 = "";

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_level);

        initViews();
        setOnclick(key);

    }


    private void setOnclick(String key) {

        btnCheck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals(key)) {

                    image1.setImageResource(R.drawable.snake);
                    image2.setImageResource(R.drawable.yad);
                    image3.setImageResource(R.drawable.griby);
                    image4.setImageResource(R.drawable.skorpion);

                    Toast.makeText(FirstLevel.this, "Вы угадали", Toast.LENGTH_SHORT).show();

                    btnCheck.setBackgroundColor(Color.GREEN);
                    editText.setText("");

                } else if (editText.getText().toString().equals(key2)) {

                    Toast.makeText(FirstLevel.this, "Вы угадали второе слово!", Toast.LENGTH_SHORT).show();
                    btnCheck.setBackgroundColor(Color.MAGENTA);
                    Intent intent = new Intent(FirstLevel.this, SecondActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(FirstLevel.this, "Вы не угадали, попробуйте снова!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void initViews() {
        editText = findViewById(R.id.edit_text);
        btnCheck = findViewById(R.id.btn_check);
        image1 = findViewById(R.id.second_imageView1);
        image2 = findViewById(R.id.second_imageView2);
        image3 = findViewById(R.id.imageView3);
        image4 = findViewById(R.id.imageView4);
    }
}