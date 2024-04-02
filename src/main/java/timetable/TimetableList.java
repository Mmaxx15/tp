package timetable;

import seedu.duke.InvalidInputFormatException;
import seedu.duke.UI;

public class TimetableList {
    public static int classCount;
    public static int[] classCountDay;
    public static final int NUM_DAYS = 5;
    public static final int HOURS_PER_DAY = 24;
    private static Days[][] timetable;
    private static final String DAY_KEYWORD = "day/";
    private static final String CODE_KEYWORD = " code/";
    private static final String TIME_KEYWORD = " time/";
    private static final String DURATION_KEYWORD = " duration/";
    private static final String LOCATION_KEYWORD = " location/";

    public TimetableList() {
        timetable = new Days[NUM_DAYS][HOURS_PER_DAY];
        classCountDay = new int[NUM_DAYS];
        classCount = 0;
    }

    public static Days[][] getTimetable() {
        return timetable;
    }

    public static void addClass(String schedule, Boolean userAdded) {
        try {
            String[] parts = schedule.split(DAY_KEYWORD, 2);
            if (parts.length < 2) {
                throw new InvalidInputFormatException("Invalid input format for class day.");
            }
            String classDayPart = parts[1].trim();

            parts = classDayPart.split(CODE_KEYWORD, 2);
            if (parts.length < 2) {
                throw new InvalidInputFormatException("Invalid input format for class code.");
            }
            int classDay = Integer.parseInt(parts[0].trim());
            String classCodePart = parts[1].trim();

            parts = classCodePart.split(TIME_KEYWORD, 2);
            if (parts.length < 2) {
                throw new InvalidInputFormatException("Invalid input format for class time.");
            }
            String classCode = parts[0].trim();
            String classTimePart = parts[1].trim();

            parts = classTimePart.split(DURATION_KEYWORD, 2);
            if (parts.length < 2) {
                throw new InvalidInputFormatException("Invalid input format for class duration.");
            }
            int classTime = Integer.parseInt(parts[0].trim());
            String classDurationPart = parts[1].trim();

            parts = classDurationPart.split(LOCATION_KEYWORD, 2);
            if (parts.length < 2) {
                throw new InvalidInputFormatException("Invalid input format for class location.");
            }
            int classDuration = Integer.parseInt(parts[0].trim());
            String classLocation = parts[1].trim();

            if (classDay < 1 || classDay > NUM_DAYS) {
                System.out.println("Day of the week does not exist");
                return;
            }
            if (classTime < 1 || classTime >= HOURS_PER_DAY) {
                System.out.println("Time of the day does not exist");
                return;
            }
            if (classDuration < 1 || classDuration > (HOURS_PER_DAY - classTime)) {
                System.out.println("Invalid class duration");
                return;
            }
            while(classDuration > 0) {
                timetable[classDay - 1][classTime - 1] = new Days(classCode, classTime, classDuration, classLocation);
                classCountDay[classDay - 1]++;
                classDuration--;
                classTime++;
                classCount++;
            }
            userAddedMessage(userAdded);
        } catch (InvalidInputFormatException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Must be an integer");
        }
    }

    private static void userAddedMessage(Boolean userAdded) {
        if (userAdded){
            System.out.println("Class added successfully.");
        }
    }

    public static void deleteClass(String details) {
        try {
            String[] parts = details.split(DAY_KEYWORD, 2);
            if (parts.length < 2) {
                throw new InvalidInputFormatException("Invalid input format for class day.");
            }
            String classDayPart = parts[1].trim();

            parts = classDayPart.split(TIME_KEYWORD, 2);
            if (parts.length < 2) {
                throw new InvalidInputFormatException("Invalid input format for class time.");
            }
            int classDay = Integer.parseInt(parts[0].trim());
            int classTime = Integer.parseInt(parts[1].trim());

            if (classDay < 1 || classDay > NUM_DAYS) {
                System.out.println("Day of the week does not exist");
                return;
            }
            if (classTime < 1 || classTime >= HOURS_PER_DAY) {
                System.out.println("Time of the day does not exist");
            }
            if (timetable[classDay - 1][classTime - 1] != null) {
                timetable[classDay - 1][classTime - 1] = null;
                classCountDay[classDay - 1]--;
                classCount--;
                System.out.println("Class removed successfully.");
            } else {
                System.out.println("Class not found.");
            }
        } catch (InvalidInputFormatException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Must be an integer");
        }
    }

    public static void listTimetable() {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        for (int i = 0; i < NUM_DAYS; i++) {
            System.out.println(daysOfWeek[i] + " Classes:");
            if (classCountDay[i] == 0) {
                System.out.println("No classes scheduled.");
            } else {
                UI.printTimetableByDay(timetable[i]);
            }
            System.out.println(); // Add a newline for better readability
        }
    }

    public static void listByDay(String day) {
        try {
            int classDay = Integer.parseInt(day);
            if (classDay < 1 || classDay > NUM_DAYS) {
                System.out.println("Day of the week does not exist");
                return;
            }
            if (classCountDay[classDay - 1] == 0) {
                System.out.println("No class on that day");
            } else {
                UI.printTimetableByDay(timetable[classDay - 1]);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + "Must be an integer");
        }
    }

}
