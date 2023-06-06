package sg.edu.rp.c346.id22020860.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvColour;

    ArrayList<String> alColours;

    ArrayAdapter<String> aaColours;

    EditText etIndexElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("ArrayList");

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextText2);

        alColours = new ArrayList<String>();
        alColours.add("Orange");
        alColours.add("Red");

        aaColours = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);


    lvColour.setAdapter(aaColours);

    btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              String colour = etElement.getText().toString();
//          alColours.add
             int pos = Integer.parseInt(etIndexElement.getText().toString());
             alColours.add(pos,colour);
             aaColours.notifyDataSetChanged();
           }
       });

    lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            String colour = alColours.get(position);
            Toast.makeText(getApplicationContext(),colour,Toast.LENGTH_SHORT).show();
        }
    });


    }
}