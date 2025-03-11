package com.example.clock;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Time;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextClock clock = findViewById(R.id.textClock);
        Button button = findViewById(R.id.button);
        EditText timeText = findViewById(R.id.editTextTime);
        TextView text = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IsIt1448((Time) timeText.getText());
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean IsIt1448(Time alarm)
    {
        Instant currenTime;
        Clock clock;
        do{
            currenTime = clock.instant();
        }while(!currenTime.equals(alarm));
        return true;
    }
}