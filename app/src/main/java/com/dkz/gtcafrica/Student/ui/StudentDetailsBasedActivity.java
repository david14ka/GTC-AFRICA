package com.dkz.gtcafrica.Student.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dkz.gtcafrica.MainActivity;
import com.dkz.gtcafrica.R;
import com.dkz.gtcafrica.model.ui.StudentBasedData;
import com.dkz.gtcafrica.model.ui.StudentMenu;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.List;

public class StudentDetailsBasedActivity extends AppCompatActivity {

    public static StudentMenu studentMenu;
    private RecyclerView recyclerView;
    private TextView textViewTitle;
    private TextView textViewSubTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_activity_details_based);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewTitle = findViewById(R.id.eTitle);
        textViewSubTitle = findViewById(R.id.eSubTitle);
        textViewTitle.setText(studentMenu.getTitle());
        textViewSubTitle.setText(studentMenu.getSubTile());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ButtonAdapter(studentMenu.getStudentButtons()));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_logout) {

            Prefs.clear();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.MyViewHolder> {
        private List<String> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView textView;
            public MyViewHolder(TextView v) {
                super(v);
                textView = v;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public ButtonAdapter(List<String> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
            // create a new view
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.content_based_button, parent, false);

            if (studentMenu.isException()) v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.content_based_button_help, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.textView.setText(mDataset.get(position));

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }
}
