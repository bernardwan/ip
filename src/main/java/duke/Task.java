package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Task class that includes Todos, Events and Deadline.
 */
public class Task {
    protected String description;
    protected boolean status;

    /**
     * Constructs generic Task object
     * @param description Description of task
     * @param status Completion status of Task
     */
    private Task(String description, boolean status) {
        this.description = description;
        this.status = status;
    }

    /**
     * Returns the corresponding status icon
     * @return Corresponding status icon
     */
    public String getStatusIcon() {
        return (status ? "[X]" : "[ ]");
    }

    public String getTaskType() {
        return "[ ]";
    }

    public String getDescription() {
        return this.description;
    }

    public void setStatus(boolean status) {
        this.status= status;
    }

    public static class Todo extends Task{

        /**
         * Constructs Todo task
         * @param description Description for the task
         * @param status Completion status of task
         */
        public Todo(String description, boolean status) {
            super(description, status);
        }

        @Override
        public String getTaskType() {
            return "[T]";
        }

        /**
         * Formats task information into String format to be saved onto storage
         * @return String containing task info
         */
        @Override
        public String toString() {
            return "todo" + " | " + (this.status ? "1" : "0") + " | " + this.description;
        }

    }

    public static class Deadline extends Task{
        private LocalDate by;


        /**
         * Constructs Todo task
         * @param description Description for the task
         * @param status Completion status of task
         * @param by Deadline of task in YYYY-MM-DD format
         */
        public Deadline(String description, boolean status, String by) {
            super(description, status);
            this.by = LocalDate.parse(by, DateTimeFormatter.ISO_LOCAL_DATE);
        }

        @Override
        public String getTaskType() {
            return "[D]";
        }

        /**
         * Returns description of task including deadline
         * @return Description of task including deadline
         */
        @Override
        public String getDescription() {
            return super.getDescription() + "(by: " +
                    this.by.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)) + ")";
        }

        /**
         * Formats task information into String format to be saved onto storage
         * @return String containing task info
         */
        @Override
        public String toString() {
            return "deadline" + " | " + (this.status ? "1" : "0") + " | " + this.description + " | " + this.by;
        }

    }

    public static class Event extends Task{
        private LocalDate at;

        /**
         * Constructs Todo task
         * @param description Description for the task
         * @param status Completion status of task
         * @param at Deadline of task in YYYY-MM-DD format
         */
        public Event(String description, boolean status, String at) {
            super(description, status);
            this.at = LocalDate.parse(at, DateTimeFormatter.ISO_LOCAL_DATE);
        }

        @Override
        public String getTaskType() {
            return "[E]";
        }

        /**
         * Returns description of task including date
         * @return Description of task including date
         */
        @Override
        public String getDescription() {
            return super.getDescription() + "(at: " +
                    this.at.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)) + ")";
        }

        /**
         * Formats task information into String format to be saved onto storage
         * @return String containing task info
         */
        @Override
        public String toString() {
            return "event" + " | " + (this.status ? "1" : "0") + " | " + this.description + " | " + this.at;
        }

    }
}