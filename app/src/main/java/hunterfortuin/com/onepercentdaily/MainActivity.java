package hunterfortuin.com.onepercentdaily;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TaskCollection mTaskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storageLookup();
        configureView();
    }

    private void storageLookup() {
        // Set up Date (Beginning of Today)
        Calendar date = new GregorianCalendar();
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        Date formattedDate = date.getTime();
        long millis = formattedDate.getTime();

        // Set Up Storage Connection
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();

        // Pull Stored Date
        long storedDate = sharedPref.getLong("date", 0);

        // If the Date Isn't Stored or the Date Doesn't Match Today
        if (storedDate == 0 || storedDate != millis) {
            configureTasks();

            String json = gson.toJson(mTaskList);
            editor.putLong("date", millis);
            editor.putString("mTaskList", json);
            editor.commit();
        } else { // Else, everything needed is in local storage
            String json = sharedPref.getString("mTaskList", "");
            mTaskList = gson.fromJson(json, TaskCollection.class);
        }
    }

    private void configureTasks() {
        String[] tasks = {"Do 20 pushups", "High five a friend", "Write for 5 minutes"};
        Collections.shuffle(Arrays.asList(tasks));

        mTaskList = new TaskCollection(tasks);
    }

    private void configureView() {
        ListView taskListView = (ListView) findViewById(R.id.taskListView);
        TaskListAdapter adapter = new TaskListAdapter(getApplicationContext(), R.layout.list_item, mTaskList.getTasks());
        taskListView.setAdapter(adapter);
    }
}