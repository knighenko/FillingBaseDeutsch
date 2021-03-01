package com.knyghenko.fillingbasedeutsch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.knyghenko.fillingbasedeutsch.model.ConnectServer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendTask(View view) {
        String rusString;
        String deutschString;
        int lesson;
        rusString=((EditText)findViewById(R.id.editRus)).getText().toString();
        deutschString=((EditText)findViewById(R.id.editDeutsch)).getText().toString();
        lesson=Integer.parseInt(((EditText)findViewById(R.id.editLesson)).getText().toString());
        String response = ConnectServer.connectToServerSearch("4:" + rusString + ":" + deutschString+":"+lesson);

        if (response.equals("false")) {
            Toast toast = Toast.makeText(this, "Ошибка!!! Данные не внесены", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Данные успешно внесены!!!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
}