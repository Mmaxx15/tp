package gpa;

import static seedu.duke.CantVasMain.ui;


public class GPACommand {

    public static void processGPACommand() {

        while (true) {
            System.out.println("Enter 'GPA' to start or 'exit' to exit to main menu:");
            String command = ui.getUserCommand();

            if ("exit".equalsIgnoreCase(command)) {
                System.out.println("Exiting the GPA calculator. Thank you for using it!");
                break;
            } else if (!"GPA".equalsIgnoreCase(command)) {
                System.out.println("Invalid input. " +
                        "Please input 'GPA' to start or 'exit' to exit.");
                continue;
            }

            double currentGPA;
            int totalAccumulatedCredits;

            while (true) {
                System.out.println("Enter your current GPA and the number of MCs taken  " +
                        " (format: GPA_SCORE /NUMBER_OF_MCS):");
                String gpaInput = ui.getUserCommand();
                if ("exit".equalsIgnoreCase(gpaInput.trim())) {
                    System.out.println("Exiting the GPA calculator. Thank you for using it!");
                    return; // Use return to exit the method immediately
                }

                try {
                    String[] parts = gpaInput.split("/");
                    if (parts.length != 2) {
                        throw new IllegalArgumentException("Input does not match expected format.");
                    }

                    currentGPA = Double.parseDouble(parts[0].trim());
                    totalAccumulatedCredits = Integer.parseInt(parts[1].trim());

                    if (currentGPA < 0 || currentGPA > 5 || totalAccumulatedCredits < 0) {
                        System.out.println("Invalid input: GPA score should be between 0 and 5," +
                                " and MCs should not be negative.");
                        continue; // This continues the inner while-loop for re-input
                    } else if (totalAccumulatedCredits >= 999999) {
                        System.out.println("You have input a tooooo large value" +
                                "for your MCs");
                        continue;
                    }
                    break; // Breaks the inner while-loop if input is valid
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input detected!!!! \n" +
                            "Please ensure your input matches the format:" +
                            "GPA_SCORE / NUMBER_OF_MCS.\n" +
                            "Example: 4.5 / 30");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input detected!!!! \n" +
                            "Please ensure your input matches the format: " +
                            "GPA_SCORE / NUMBER_OF_MCS.\n" +
                            "Example: 4.5 / 30");
                }
            }


            // Assertions for additional validation
            assert currentGPA >= 0 && currentGPA <= 5 : "GPA should be between 0 and 5.";
            assert totalAccumulatedCredits >= 0 : "MCs should not be negative.";


            int numOfModules = 0;
            boolean validNumOfModules = false;
            while (!validNumOfModules) {
                System.out.println("Enter the number of mods you want to add (format: NUMBER_OF_MODS):");
                String modsInput = ui.getUserCommand();
                if ("exit".equalsIgnoreCase(modsInput.trim())) {
                    System.out.println("Exiting the GPA calculator. Thank you for using it!");
                    return; // Use return to exit the method immediately
                }

                try {
                    numOfModules = Integer.parseInt(modsInput.trim());
                    if (numOfModules < 0) {
                        System.out.println("Invalid input: Number of modules cannot be negative.");
                    } else if (numOfModules >=999) {
                        System.out.println("You have input too many modules!");
                    } else {
                        validNumOfModules = true; // Input is valid, proceed to the next step
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input detected!!!! \n" +
                            "Please enter a valid integer for the number of modules!");
                }
            }
            assert numOfModules <= 999 && numOfModules >= 0 :"" +
                    "Numbers of Modules input should be between 0 and 999";

            int[] moduleCredits = new int[numOfModules];
            String[] moduleGrades = new String[numOfModules];


            for (int i = 0; i < numOfModules; i++) {
                while (true) {
                    System.out.println("Enter modular credit and expected grade for module " + (i + 1) +
                            " (format: MODULAR_CREDIT / EXPECTED_GRADE):");
                    String modInput = ui.getUserCommand();
                    if ("exit".equalsIgnoreCase(modInput.trim())) {
                        System.out.println("Exiting the GPA calculator. Thank you for using!");
                        return;
                    }

                    try {
                        String[] parts = modInput.split("/");
                        if (parts.length != 2) {
                            throw new IllegalArgumentException("Input does not match expected format.");
                        }

                        int credit = Integer.parseInt(parts[0].trim());
                        if (credit < 0 || credit > 12) {
                            throw new IllegalArgumentException("Invalid modular credit input: Credit should be " +
                                    "between 0 and 12.");
                        }
                        String grade = parts[1].trim().toUpperCase();

                        double gradePoints = GPAMain.calculatePointsForGrade(grade);

                        moduleCredits[i] = credit;
                        moduleGrades[i] = grade;
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format. Please ensure you enter an integer for the " +
                                "modular credit.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            double updatedGPA = GPAMain.calculateNewGPA(currentGPA,
                    totalAccumulatedCredits, numOfModules, moduleCredits, moduleGrades);
            System.out.printf("Your updated GPA is: %.2f\n", updatedGPA);
        }
    }
}
