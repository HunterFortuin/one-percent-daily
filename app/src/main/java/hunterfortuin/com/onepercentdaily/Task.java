package hunterfortuin.com.onepercentdaily;

/**
 * Created by hunterfortuin on 11/11/15.
 */
public class Task {
    private String mName;
    private boolean mComplete;

    public Task(String name) {
        mName = name;
        mComplete = false;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public boolean isComplete() {
        return mComplete;
    }

    public void setComplete(boolean complete) {
        mComplete = complete;
    }
}
