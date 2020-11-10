package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostUpdate extends AppCompatActivity {

    Button btnSave, btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_update);

        btnSave = (Button)findViewById(R.id.post_update_btn_save);
        btnDelete = (Button)findViewById(R.id.post_update_btn_delete);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent host_entrance1 = new Intent(PostUpdate.this, HostEntrance.class);
                startActivity(host_entrance1);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent host_entrance2 = new Intent(PostUpdate.this, HostEntrance.class);
                startActivity(host_entrance2);
            }
        });
    }
}