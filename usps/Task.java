package usps;

public class Task {
    private int taskTime;
    private String taskName;
    
    public Task(int tTime, String tName) {
        taskName = tName;

        if (taskName == "Passport")
        {
            taskTime = 20;
        }
        else if (taskName == "SendMail")
        {
            taskTime = 2;
        }
        else if (taskName == "Pickup")
        {
            taskTime = 5;
        }
        else
        {
            taskTime = 5;
        }

    }
    
    public int getTaskTime() {
        return taskTime;
    }
    
    public String getTaskName() {
        return taskName;
    }
    
}
