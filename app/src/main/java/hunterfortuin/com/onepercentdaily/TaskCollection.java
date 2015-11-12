package hunterfortuin.com.onepercentdaily;

import java.util.ArrayList;

/**
 * Created by hunterfortuin on 11/11/15.
 */
public class TaskCollection {
    private ArrayList<Task> mTasks = new ArrayList<>();;

    public TaskCollection(String[] taskList) {
        int arraySize = taskList.length;

        for (int i = 0; i < arraySize; i++) {
            Task task = new Task(taskList[i]);
            mTasks.add(task);
        }
    }

    public ArrayList<Task> getTasks() {
        return mTasks;
    }

    public void addTask(Task task) {
        mTasks.add(task);
    }
}