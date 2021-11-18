package com.example.enigmassiette;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enigmassiette.sampledata.Note;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;


public class NoteActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        EditText restaurantName = findViewById(R.id.editTextRestauName);
        EditText date = findViewById(R.id.editTextDate);
        EditText time = findViewById(R.id.editTextTime);
        EditText noteDeco = findViewById(R.id.editTextDeco);
        EditText noteFood = findViewById(R.id.editTextFood);
        EditText noteServ = findViewById(R.id.editTextServ);
        EditText critique = findViewById(R.id.editCritique);
        Button submitButton = findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInputFilled = restaurantName.getText() != null && date.getText() != null && time.getText() != null && noteDeco.getText() != null && noteFood.getText() != null && noteServ.getText() != null && critique.getText() != null;
                if(isInputFilled){
                    String restauName = restaurantName.getText().toString();
                    String dateString = date.getText().toString();
                    String timeString = time.getText().toString();
                    String decoNote =  noteDeco.getText().toString();
                    String foodNote = noteFood.getText().toString();
                    String servNote = noteServ.getText().toString();
                    String desc = critique.getText().toString();
                    Note note = new Note(restauName, dateString, timeString, decoNote, foodNote, servNote, desc);

                    mDatabase.child("note").child(Math.random()+"").setValue(note);
                } else {
                    Toast.makeText(NoteActivity.this, "Fill all the inputs", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
