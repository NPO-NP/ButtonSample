package com.example.buttonsample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn1 = (Button)this.findViewById(R.id.button);
        Button btn2 = (Button)this.findViewById(R.id.button2);
        Button btn4 = (Button)this.findViewById(R.id.button4);

        btn1.setOnClickListener(new btn1Handler()); // need to define btn1Handler class below

        btn2.setOnClickListener(new View.OnClickListener() { // anonymous inner class
            public void onClick(View v) {
                Log.d("MAD", "Button 2 clicked");
            }
        });

        btn4.setOnClickListener(v -> { // Using Lambda
            Log.d("MAD", "Button 2 clicked");
            Toast.makeText(getBaseContext(), "Button 4 clicked", Toast.LENGTH_SHORT).show();
        });

    }

    public void btn3Handler(View v) { // See XML definitions for button3 in activity_main.xml for its handler method
            Log.d("MAD", "Button 3 clicked");
    }

    class btn1Handler implements Button.OnClickListener  // inner class
    {
        public void onClick(View v) {
            Log.d("MAD", "Button 1 clicked");
            Toast.makeText(getBaseContext(), "Button 1 clicked", Toast.LENGTH_SHORT).show();
        }
    } // btnFollowHandler
}