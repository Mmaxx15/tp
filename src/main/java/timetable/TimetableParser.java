package timetable;

public class TimetableParser {

    public static void parseTimetable(String command) {
        String[] commandParts = command.substring(3).trim().split("/", 2);
        if (commandParts.length < 2) {
            System.out.println("Incomplete command!");
            return;
        }

        String action = commandParts[0].trim();
        String details = commandParts[1].trim();

        switch (action) {
        case "add":
            TimetableList.addClass(details, true);
            break;
        case "del":
            TimetableList.deleteClass(details);
            break;
        case "list":
            System.out.println("Timetable listed here");
            TimetableList.listTimetable();
            break;
        case "list -d":
            TimetableList.listByDay(details);
            break;
        default:
            System.out.println("Unknown command " + details);
            break;
        }
    }
}
