// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW12-PriorityQueue
// Resources used: None

/**
 * Task represents a task with a name and priority, used for prioritization in a priority queue.
 */
public class Task implements Comparable<Task> {
    private String taskName;
    private int priority;

    /**
     * Constructs a task with the given name and default priority (0).
     *
     * @param taskName the name of the task
     */
    public Task(String taskName) {
        this.taskName = taskName;
        this.priority = 0;
    }

    /**
     * Constructs a task with the given name and priority.
     *
     * @param taskName the name of the task
     * @param priority the priority of the task
     */
    public Task(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    /**
     * Gets the name of the task.
     *
     * @return the name of the task
     */
    public String getTask() {
        return taskName;
    }

    /**
     * Sets the name of the task.
     *
     * @param taskName the new name of the task
     */
    public void setTask(String taskName) {
        if (taskName == null) {
            return;
        }
        this.taskName = taskName;
    }

    /**
     * Gets the priority of the task.
     *
     * @return the priority of the task
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the priority of the task.
     *
     * @param priority the new priority of the task
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Compares this task to another task based on their priorities.
     *
     * @param other the task to compare to
     * @return a negative integer, zero, or a positive integer as this task has a lower priority, equal priority,
     *         or higher priority than the specified task
     */
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    /**
     * Returns a string representation of the task, including its name and priority.
     *
     * @return a string representation of the task
     */
    @Override
    public String toString() {
        return "[ " + taskName + ", " + priority + " ]";
    }

    /**
     * Checks if this task is equal to another object. Two tasks are considered equal if they have the same name.
     *
     * @param obj the object to compare to
     * @return true if the tasks are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Task)) {
            return false;
        }

        Task other = (Task) obj;

        return taskName.equals(other.getTask());
    }
}