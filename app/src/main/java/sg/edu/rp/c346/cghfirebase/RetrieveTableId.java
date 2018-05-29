package sg.edu.rp.c346.cghfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RetrieveTableId extends AppCompatActivity {
    Button retrieveBtn, nextPage;
    TextView result;
    DatabaseReference databaseReferenceTable;
    ArrayList<SurgicalTable> tableArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_table_id);
        nextPage = findViewById(R.id.next);
        retrieveBtn = findViewById(R.id.retrieveBtn);
        result = findViewById(R.id.result);
        tableArrayList = new ArrayList<>();
        databaseReferenceTable = FirebaseDatabase.getInstance().getReference("cghversion01").child("surgicaltable ");
        databaseReferenceTable.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //check for each one
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Log.i("Menu page", "Finding...");
                    SurgicalTable current = child.getValue(SurgicalTable.class);
                    tableArrayList.add(current);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        retrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultString = "";
                for (int i = 0 ; i<tableArrayList.size() ; i++){
                    resultString += "\n"+tableArrayList.get(i).getTableCode();
                }
                result.setText(resultString);
            }
        });
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), PushNotifivation.class);
                startActivity(i);
            }
        });
    }
}
