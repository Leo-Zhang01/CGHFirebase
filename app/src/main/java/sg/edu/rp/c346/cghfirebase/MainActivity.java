package sg.edu.rp.c346.cghfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReferenceChit, databaseReferenceNotification, databaseReferenceDoc, databaseReferenceTable ;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        //Link to database
//        databaseReferenceChit = FirebaseDatabase.getInstance().getReference("cghversion01").child("chit");
//        databaseReferenceDoc = FirebaseDatabase.getInstance().getReference("cghversion01").child("doctor");
//        databaseReferenceTable = FirebaseDatabase.getInstance().getReference("cghversion01").child("surgicaltable");
//        databaseReferenceNotification = FirebaseDatabase.getInstance().getReference("cghversion01").child("notification");
//
//
//        AdmissionDetail admissionDetail;
//        Chit chit;
//        Consent consent;
//        Doctor doctor;
//        Investigations investigations;
//        Issues issues;
//        Patient patient;
//        SurgeryDetails surgeryDetails;
//        SurgicalTable surgicalTable;
//        admissionDetail = new AdmissionDetail("03/02/2018","20","1300","1300");
//        consent = new Consent("a","b","c");
//        doctor = new Doctor("Bob","G1234567A","08/08/2000","123465678","12345678","5","Nice doc","woodlands",true,false);
//        investigations = new Investigations("1.0","1","1","2","3","4");
//        issues = new Issues("ok","nice","idk");
//        patient = new Patient("Lily","A1234657A","08/08/1999","13","male","chinese","English","idk","abc","12344567","no");
//        surgeryDetails = new SurgeryDetails("a","b","c","1234","d","true","no","1","asd","es","q","d","c","a","123");
//        surgicalTable = new SurgicalTable("c123","for patient",false);
//
//        //get the key of the column
//        String idFBC = databaseReferenceChit.push().getKey();
//        String idFBD = databaseReferenceDoc.push().getKey();
//        String idFBT = databaseReferenceTable.push().getKey();
//        databaseReferenceDoc.child(idFBD).setValue(doctor);
//
//        chit = new Chit(idFBC,patient,issues,admissionDetail,investigations,consent, idFBD,surgeryDetails,idFBT,false);
//        //add data.
//        databaseReferenceChit.child(idFBC).setValue(chit);
//        databaseReferenceTable.child(idFBT).setValue(surgicalTable);
//        String idFBN = databaseReferenceNotification.push().getKey();
//        Notification notification = new Notification(idFBN,"0","This is a test", "2018/01/02");
//        databaseReferenceNotification.child(idFBN).setValue(notification);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), FilterNotification.class);
                startActivity(i);
            }
        });
    }
}
