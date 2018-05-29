package sg.edu.rp.c346.cghfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PushNotifivation extends AppCompatActivity {
    Button pushBtn, nextBtn;
    TextView textView;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notifivation);
        pushBtn = findViewById(R.id.pushBtn);
        textView = findViewById(R.id.message);
        databaseReference = FirebaseDatabase.getInstance().getReference("cghversion01").child("notification");
        final String idFBN = databaseReference.push().getKey();

        pushBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notification = new Notification(idFBN,"doctorCode","Patient name","Patient fin","Emergence level","25/05/2018 15:13:12",false,false);
                databaseReference.child(idFBN).setValue(notification);
                textView.setText("Push successful");
            }
        });
        nextBtn = findViewById(R.id.next);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), ShowListView.class);
                startActivity(i);
            }
        });
    }
}
