package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

//    ArrayList<Integer> dp = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

//        for (int i = 1; i < 10; i++) {
//            for (int j = 1; j < 10; j++) {
//                Double p = Math.random() * 9;
//                Integer temp = Integer.parseInt(p.toString().split("\\.")[0]);
//
//                if (!dp.contains(temp)) {
//                    dp.add(temp);
//                }
//            }
//        }

//        Log.d("==", "onCreate: " + dp);
//        Toast.makeText(this, "===" + dp, Toast.LENGTH_SHORT).show();


        setbtn(binding.one);
        setbtn(binding.two);
        setbtn(binding.three);
        setbtn(binding.four);
        setbtn(binding.five);
        setbtn(binding.six);
        setbtn(binding.seven);
        setbtn(binding.eight);
        setbtn(binding.nine);
        setbtn(binding.restart);

        binding.restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> dp = new ArrayList<String>();

                binding.txt.setText("");

                while (dp.size() < 9) {
                    int a = (int) (Math.random() * 9);

                    if (!dp.contains(String.valueOf(a))) {
                        dp.add(String.valueOf(a));

                    }
                }
                Log.d("+-+-", "onClick: sfdf"+dp);

                for (int i = 0; i < dp.size(); i++)
                {
                    if(dp.get(i).equals("0"))
                    {
                        dp.set(i,"");
                    }
                }


                binding.one.setText(dp.get(0));
                binding.two.setText(dp.get(1));
                binding.three.setText(dp.get(2));
                binding.four.setText(dp.get(3));
                binding.five.setText(dp.get(4));
                binding.six.setText(dp.get(5));
                binding.seven.setText(dp.get(6));
                binding.eight.setText(dp.get(7));
                binding.nine.setText(dp.get(8));
                dp.clear();


            }
        });
    }

    private void setbtn(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.txt.getText().toString().isEmpty()) {
                    if (btn == binding.one) {
                        check(binding.one, binding.two);
                        check(binding.one, binding.four);
                    } else if (btn == binding.two) {
                        check(binding.two, binding.one);
                        check(binding.two, binding.three);
                        check(binding.two, binding.five);
                    } else if (btn == binding.three) {
                        check(binding.three, binding.two);
                        check(binding.three, binding.six);
                    } else if (btn == binding.four) {
                        check(binding.four, binding.one);
                        check(binding.four, binding.five);
                        check(binding.four, binding.seven);
                    } else if (btn == binding.five) {
                        check(binding.five, binding.two);
                        check(binding.five, binding.four);
                        check(binding.five, binding.six);
                        check(binding.five, binding.eight);
                    } else if (btn == binding.six) {
                        check(binding.six, binding.three);
                        check(binding.six, binding.five);
                        check(binding.six, binding.nine);
                    } else if (btn == binding.seven) {
                        check(binding.seven, binding.four);
                        check(binding.seven, binding.eight);
                    } else if (btn == binding.eight) {
                        check(binding.eight, binding.five);
                        check(binding.eight, binding.seven);
                        check(binding.eight, binding.nine);
                    } else if (btn == binding.nine) {
                        check(binding.nine, binding.six);
                        check(binding.nine, binding.eight);
                    }
                    win();

                }
            }
        });
    }


    void win() {
        if (binding.one.getText().toString().equals("1") && binding.two.getText().toString().equals("2") && binding.three.getText().toString().equals("3") && binding.four.getText().toString().equals("4") && binding.five.getText().toString().equals("5") && binding.six.getText().toString().equals("6") && binding.seven.getText().toString().equals("7") && binding.eight.getText().toString().equals("8")) {
            binding.txt.setText("WIN");
        }
    }

    private void check(Button first, Button second) {
        if (second.getText().toString().isEmpty()) {
            second.setText(first.getText());
            first.setText("");
        }
    }
}