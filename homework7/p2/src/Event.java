import java.time.Duration;
import java.time.LocalDateTime;


//given that calculating the time until the event/reminder takes place is a bit costly and does not have to change unless the dates themselves change (which can be easily kept track of because I made them private) I have decided to make extra attributes and methods other than those required in the exercise which handle caching the data.
//Also given that we have not yet covered error handling in Java I have decided to just assume the function gets the correct input (reminder date before event date) except for a method which updates them and outputs to the console if the new values are not correct.
public class Event {
    public String eventName;
    public String eventDescription;
    private LocalDateTime eventDateTime;
    private LocalDateTime reminderDateTime;
    private Calendar timeUntilEvent = new Calendar();
    private Calendar timeUntilReminder = new Calendar();

    Event(String eventName, String eventDescription, LocalDateTime eventDateTime, LocalDateTime reminderDateTime) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDateTime = eventDateTime;
        this.reminderDateTime = reminderDateTime;

        updateTime(eventDateTime, timeUntilEvent);
        updateTime(reminderDateTime, timeUntilReminder);
    }

    public LocalDateTime getEventDateTime(){
        return this.eventDateTime;
    }

    public LocalDateTime getReminderDateTime(){
        return this.reminderDateTime;
    }

    public Calendar getTimeUntilEvent(){
        return timeUntilEvent;
    }

    public Calendar getTimeUntilReminder(){
        return timeUntilReminder;
    }

    public void updateEventDateTime(LocalDateTime newEventDateTime, LocalDateTime newReminderDateTime){
        if(newEventDateTime.isAfter(newReminderDateTime)){
            eventDateTime = newEventDateTime;
            reminderDateTime = newReminderDateTime;
        }
        else
            System.out.println("Error: the reminder date is set after the event date");
    }

    public void updateTime(LocalDateTime date, Calendar timeUntilDate){
        LocalDateTime currentDateTime = LocalDateTime.now();

        Duration duration = Duration.between(currentDateTime, date);

        timeUntilDate.days = duration.toDaysPart();
        timeUntilDate.hours = duration.toHoursPart();
        timeUntilDate.minutes = duration.toMinutesPart();
        timeUntilDate.totalHours = duration.toHours();
    }
}
