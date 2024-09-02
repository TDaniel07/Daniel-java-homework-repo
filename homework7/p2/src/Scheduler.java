import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//for this class I would have used a hashmap to store the event objects as value and their names as keys in order to greatly reduce the complexity of looking up event names and removing events
public class Scheduler {
    private List<Event> events;

    Scheduler(){
        events = new ArrayList<>();
    }

    public void addEvent(Event e){
        if(eventExists(e)){
            System.out.println("event names must be unique");
            return;
        }
        events.add(e);
    }


    //Here i could have added another attribute to Event which would determine whether or not the event is active instead of deleting the element from the list (which is a costly operation) but that would have caused a memory leak as the array size would constantly get bigger
    //Alternatively I could have also created another array which contained all of the indexes of these "dead" events and when it got to a certain size I could have actually removed them from memory but at that point I might as well have used a hashmap instead of a list in the first place.
    public void removeEvent(String eventName){
        for(int i = 0; i < events.size(); i++){
            if(events.get(i).eventName.equals(eventName)){
                events.remove(i);
                return;
            }
        }
    }

    public List<Event> getUpcomingEvents(int n){
        List<Event> upcomingEvents = new ArrayList<>();
        int addedEvents = 0;
        LocalDateTime currentDate = LocalDateTime.now();

        for(Event event : events){
            if(addedEvents > n - 1)
                break;

            if(event.getEventDateTime().isAfter(currentDate)){
                upcomingEvents.add(event);
                addedEvents++;
            }
        }

        return upcomingEvents;
    }

    public List<Event> getEventsOn(LocalDate date){
        List<Event> eventsOn = new ArrayList<>();

        for(Event event : events){
            if(event.getEventDateTime().toLocalDate().isEqual(date)){
                eventsOn.add(event);
            }
        }

        return eventsOn;
    }

    public List<Event> getPendingReminders(){
        List<Event> pendingReminders = new ArrayList<>();

        for(Event event : events){
            if(event.getTimeUntilReminder().totalHours <= 24){
                pendingReminders.add(event);
            }
        }

        return pendingReminders;
    }



    private boolean eventExists(Event event){
        for(Event i : events){
            if(i.eventName.equals(event.eventName))
                return true;
        }
        return false;
    }
}
