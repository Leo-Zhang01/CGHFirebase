package sg.edu.rp.c346.cghfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FilterNotification extends AppCompatActivity {
    Button oneHourBtn, moreBtn, next;
    DatabaseReference databaseReferenceChit;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_notification);
        oneHourBtn = findViewById(R.id.oneHourBtn);
        moreBtn = findViewById(R.id.moreBtn);
        next = findViewById(R.id.next);
        final ArrayList<Chit> allList = new ArrayList<>();
        textView = findViewById(R.id.textView);
        databaseReferenceChit = FirebaseDatabase.getInstance().getReference("cghversion01").child("chit");
        databaseReferenceChit.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //check for each one
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Log.i("Menu page", "Finding...");
                    Chit current = child.getValue(Chit.class);
                    allList.add(current);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        oneHourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Chit> oneAL = new ArrayList<>();
                for(int i = 0 ; i<allList.size(); i++){
                    if(allList.get(i).getLifeThreatening() == true){
                        oneAL.add(allList.get(i));
                    }
                }
                String result = "";
                for(int i = 0 ; i<oneAL.size(); i++){
                    result += "\n"+oneAL.get(i).getDoctor();
                }
                textView.setText(result);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), RetrieveTableId.class);
                startActivity(i);
            }
        });
    }
}
