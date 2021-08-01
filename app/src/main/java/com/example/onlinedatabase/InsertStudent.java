package com.example.onlinedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class InsertStudent extends AppCompatActivity {
    private EditText grade;
    private EditText name;
    private EditText age;
    private Button submit;
    private String Class;
    private TextView text;
    private void Init(){
        grade = findViewById(R.id.Grade);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        submit = findViewById(R.id.submit);
        Class= "6th";
        text = findViewById(R.id.text);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_student);
        Init();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://20.106.192.35:3000/insertStudent";

        submit.setOnClickListener(v->{
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    text.setText(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    text.setText(error.getMessage());
                }
            }){
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<>();
                    String stu_name = name.getText().toString();
                    String stu_age = age.getText().toString();
                    String stu_class = grade.getText().toString();
                    params.put("name",stu_name);
                    params.put("age",stu_age);
                    params.put("class",stu_class);
                    return params;
                }
            };
            queue.add(request);
        });
    }
}