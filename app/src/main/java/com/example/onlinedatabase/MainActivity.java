package com.example.onlinedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button insertBtn;
    private Button updateBtn;
    private Button delBtn;
    private Button getBtn;
    private Button findBtn;
    private void Init(){
        insertBtn = this.findViewById(R.id.insert);
        updateBtn = this.findViewById(R.id.update);
        delBtn = this.findViewById(R.id.delete);
        getBtn = this.findViewById(R.id.get);
        findBtn = this.findViewById(R.id.find);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this.getApplicationContext(),InsertStudent.class);
        startActivity(intent);

    }
}