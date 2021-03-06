package Task;

/***
 * Represents a task with deadline in the task list.
 */

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    @Override
    public String getTime() {
        return by;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}