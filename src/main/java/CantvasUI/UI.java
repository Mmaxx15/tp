package CantvasUI;
import motivationalquote.MotivationalQuotes;
import timetable.Days;

import java.util.Scanner;

public class UI {

    private final Scanner in;

    public UI() {
        this.in = new Scanner(System.in);
    }

    public String getUserCommand() {
        String input;
        do {
            input = in.nextLine();
        } while (input.trim().isEmpty()); // Checks if the input is not just whitespace
        return input;
    }

    public static void printLogo() {
        System.out.println("   _____            ___      __\n"
                + "  / ____|          | \\ \\    / /\n"
                + " | |     __ _ _ __ | |\\ \\  / /_ _ ___\n"
                + " | |    / _` | '_ \\| __\\ \\/ / _` / __|\n"
                + " | |___| (_| | | | | |_ \\  / (_| \\__ \\\n"
                + "  \\_____\\__,_|_| |_|\\__| \\/ \\__,_|___/\n"
        );
    }

    public static void printHelpMessage() {
        System.out.println("Cantvas Help\n");
        expenditureHelpMessage();
        printLineBreak();
        timetableHelpMessage();
        printLineBreak();
        gpaHelpMessage();
        printLineBreak();
    }

    private static void expenditureHelpMessage() {
        System.out.println("Expenditure help:\n"
                + "\nTo input expenses, use format:\n"
                + "<< e/ add/ d/ <description> amt/ <cost> date/ <dd.mm.yyyy> >>\n"
                + "\nTo input expenses with type, use format:\n"
                + "<< e/ add/ d/ <description> t/ <type> amt/ <cost> date/ <dd.mm.yyyy> >>\n"
                + "\nTo delete saved expenses, use format:\n<< e/ del/ <index> >>\n"
                + "\nTo clear the entire expenditure list, use format: \n<< clearlist >>\n"
                + "\nTo List saved expenses, use format:\n<< list >>\n"
                + "\nTo view saved expenses by month, use format:\n<< e/ view/ m/ <mm.yyyy> >>\n"
                + "\nTo view saved expenses by year, use format:\n<< e/ view/ y/ <yyyy> >>\n"
                + "\nTo view saved expenses by type, use format:\n<< e/ view/ t/ <type> >>\n");
    }

    private static void timetableHelpMessage() {
        System.out.println("\nTimetable help:\n"
                + "\nTo input class to timetable, use format:\n"
                + "<< tt/ add/ day/ <day> code/ <classCode> time/ <hh> duration/ <duration> location/ <location> >>\n"
                + "\nTo delete saved class, use format:\n"
                + "<< tt/ del/ day/ <day> code/ <code> >>\n"
                + "\nTo view you timetable, use format\n"
                + "tt/ list/\n");
    }

    private static void gpaHelpMessage() {
        System.out.println("\nGPA help:\n"
                + "\nTo Use gpa calculator, type 'gpa' to continue\n"
                + "\nTo end the program, type 'exit'\n");
    }

    public static void printExitMessage() {
        System.out.println("Shutting down... Goodbye!!");
    }

    public static void printMotivationQuote() {
        String quote = MotivationalQuotes.getQuote();
        System.out.println("Here is your motivational quote of the day :D\n");
        System.out.println(quote);
        printLineBreak();
    }

    public static void printLineBreak() {
        System.out.println("-------------------------------------------------------------");
    }

    public static void printTimetableByDay(Days[] timetable) {
        for (int i = 0; i < 24; i ++) {
            if (timetable[i] != null) {
                System.out.println(timetable[i].getClassTime() +
                        " | " + timetable[i].getClassCode() +
                        " | " + timetable[i].getClassLocation());
            }
        }
    }

}
