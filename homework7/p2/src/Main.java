import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    static void printEvents(List<Event> events){
        for(Event event : events){
            System.out.println("Event name: " + event.eventName);
            System.out.println("Event description " + event.eventDescription);
            System.out.println("Event date " + event.getEventDateTime());
            System.out.println("Event reminder date " + event.getReminderDateTime());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LocalDateTime eventDate1 = LocalDateTime.of(2024, 9, 5, 10, 12);
        LocalDateTime reminderDate1 = LocalDateTime.of(2024, 9, 3, 9, 0);

        LocalDateTime eventDate2 = LocalDateTime.of(2024, 9, 7, 10, 12);
        LocalDateTime reminderDate2 = LocalDateTime.of(2024, 9, 3, 9, 0);


        LocalDateTime eventDate3 = LocalDateTime.of(2024, 9, 9, 10, 12);
        LocalDateTime reminderDate3 = LocalDateTime.of(2024, 9, 7, 9, 0);

        LocalDateTime eventDate4 = LocalDateTime.of(2024, 9, 11, 10, 12);
        LocalDateTime reminderDate4 = LocalDateTime.of(2024, 9, 10, 9, 0);

        LocalDateTime eventDate5 = LocalDateTime.of(2024, 10, 5, 10, 12);
        LocalDateTime reminderDate5 = LocalDateTime.of(2024, 10, 1, 9, 0);


        Event event1 = new Event("event 1", "description for event 1", eventDate1, reminderDate1);
        Event event2 = new Event("event 2", "description for event 2", eventDate2, reminderDate2);
        Event event3 = new Event("event 3", "description for event 3", eventDate3, reminderDate3);
        Event event4 = new Event("event 4", "description for event 4", eventDate4, reminderDate4);
        Event event5 = new Event("event 5", "description for event 5", eventDate5, reminderDate5);

        Scheduler schedule = new Scheduler();

        schedule.addEvent(event1);
        schedule.addEvent(event2);
        schedule.addEvent(event3);
        schedule.addEvent(event4);
        schedule.addEvent(event5);

        System.out.println();
        System.out.println("== upcoming events ==");
        System.out.println();

        List<Event> events = schedule.getUpcomingEvents(3);

        printEvents(events);

        System.out.println();
        System.out.println("== events after one is removed ==");
        System.out.println();

        schedule.removeEvent("event 2");

        events = schedule.getUpcomingEvents(3);

        printEvents(events);

        System.out.println();
        System.out.println("== events on a certain date ==");
        System.out.println();

        events = schedule.getEventsOn(eventDate3.toLocalDate());

        printEvents(events);

        System.out.println();
        System.out.println("== pending reminders ==");
        System.out.println();

        events = schedule.getPendingReminders();

        printEvents(events);

    }
}