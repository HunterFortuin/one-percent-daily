package hunterfortuin.com.onepercentdaily;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hunterfortuin on 11/11/15.
 */
public class TaskListAdapter extends ArrayAdapter<Task> {
    private Context context;

    public TaskListAdapter(Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Set View If Necessary
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        // Define Task for Each Position
        Task task = getItem(position);

        // Get String Value from Task
        String taskName = task.getName();

        // Get UI Component
        TextView taskTextView = (TextView) convertView.findViewById(R.id.taskTextView);

        // Set Values of UI Components
        taskTextView.setText(taskName);
        
        return convertView;
    }
}
