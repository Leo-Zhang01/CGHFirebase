package sg.edu.rp.c346.cghfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowListView extends AppCompatActivity {
    DatabaseReference databaseReferenceNotification;
    ArrayList<Notification> notificationArrayList;
    ListView listView;
    NotificationAdapter notificationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_view);
        listView = findViewById(R.id.listView);
        notificationArrayList = new ArrayList<>();
        notificationAdapter = new NotificationAdapter(this, R.layout.row_for_notification, notificationArrayList);

        databaseReferenceNotification = FirebaseDatabase.getInstance().getReference("cghversion01").child("notification");
        databaseReferenceNotification.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //check for each one
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Log.i("Menu page", "Finding...");
                    Notification current = child.getValue(Notification.class);
                    notificationArrayList.add(current);
                }
                notificationAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        listView.setAdapter(notificationAdapter);
    }
}
