# User Guide

## Introduction

# Welcome to CantVas!

Congratulations on taking the first step towards smarter, more organized 
student life! CantVas is your ultimate companion for managing your academic 
and financial responsibilities with ease. Designed with students in mind, our 
app offers a comprehensive suite of tools to help you stay on top of your 
expenses, organize your timetable and track your grades.

## Quick Start
1. Ensure you have `Java-11` or above installed on your computer.
2. Download the latest version of `CantVas` from [here](https://github.com/AY2324S2-CS2113-W13-3/tp/releases).
3. Copy the jar file to your desired folder.
4. Open a command prompt in the same directory as the jar file.
5. Run `java -jar CantVas.jar` to run the application.

## Features 
CantVas includes the following 
features:
- Expenditure Tracker 
- GPA Calculator
- Timetable Tracker
- Daily Motivational Quotes

### Expenditure Tracker
The expenditure tracker allows you to store, view, delete and filter the 
expenditures you have entered. Making it a good way to track your 
expenses.

The features include:
- Adding new expenditures without specifying the type. To do so, 
  key in with the following format: `e/ add/ d/ <description> amt/ 
  <cost> date/ <dd.mm.yyyy>`. Example: `e/ add/ d/ self-help book amt/ 
  19.99 date/ 15.03.2024`.
- Adding new expenditures with type of expenditure specified. To
  do so, key in with the following format: `e/ add/ d/ <description> t/ 
  <type> amt/ <cost> date/ <dd.mm.yyyy>`. Example: `e/ add/ d/ self-help
  book t/ book amt/ 19.99 date/ 06.04.2024`.
- Viewing saved expenditures without filters. To do so, key in 
  with the following format: `list`.
- Viewing saved expenditures by month and year. To do so, key in 
  with the following format: `e/ view/ m/ <mm.yyyy>`. Example:
  `e/ view/ m/ 03.2024`.
- Viewing saved expenditures by year. To do so, key in with the
  following format: `e/ view/ y/ <yyyy>`. Example: `e/ view/ y/ 2024`.
- Viewing saved expenditures by type. To do so, key in with the
  following format: `e/ view/ t/ <type>`. Example: `e/ view/ t/ FOOD`.
- Deleting saved expenditures. To do so, key in with the following format:
  `e/ del/ <index>`. Example: `e/ del/ 2`.
- Deleting the entire saved expenditure list. To do so, key in with the
  following format: `clearlist`.

### GPA Calculator
The GPA calculator allows you to calculate your GPA, based on your previous GPA
and your new modules' grades and module credit numbers. To use the GPA calculator,
perform the following steps.

1. Type `GPA` (Regardless of caps) to proceed to start the function.
2. Type Your `Current_GPA / Numbers_of_MCs_Taken`. Example: `4.00/24`
3. Type the numbers of modules taken for this semester. Example: `4`
4. Type in the Modular_Credit/Expected grade for each module taken.
Example: `4/A+` and `2/b+`. Modular credit should be a non-negative integer value between
0 and 12.
5. Your GPA will be automatically calculated afterwards.

### Timetable
The timetable tracker allows you to store, view and delete classes you
have entered for the current semester. Making it a good way to track what
are the classes, where are the classes and the class durations from monday
to friday respectively.

The features include:
- Adding new classes. To do so, key in with the following format: `tt/
  add/ day/ <day> code/ <classCode> time/ <hh> duration/ <duration> location/ 
  <location>`. Example: `tt/ add/ day/ 3 code/ EE2026 time/ 09 duration/ 3 location/
  E4-03-07`.
> Note that in this command: 
> 
> `day` refers to integers from 1 to 5, each mapping a day from monday to friday.
> For example, monday classes will have a day input of `1` and wednesday classes
> will have a day input of `3`.
> 
> `time` refers to 24-hours in 2 digit integer format. For example, 1pm will 
> be inputted as `13` and 9am will be inputted as `09`. 
> 
>`duration` refers to how long the class lasts. For example, if a class lasts for 3
> hours, the duration input will be `3`. 

- Deleting saved classes. To do so, key in with the following format: `tt/ del/ day/ 
  <day> code/ <code>`. Example: `tt/ del/ day/ 3 code/ cs2113`.
- Viewing saved classes according the days in the week, arranged in ascending order of
  time. To do so, key in with the following format: `tt/ list/`.

### Daily Motivational Quotes
Feeling Down? Dread looking at your packed timetable?
CantVas is here to save your day and uplift your spirits whenever you need it most
(when looking at expenses and timetable)

Everytime you start CantVas, we will provide you with a motivational quote to give 
you energy and encouragement to get through your day!

## FAQ

**Q**: What if I key in the wrong expenditure or timetable class?

**A**: Editing the list is not possible, in the event of erroneous input, please delete 
and input the correct expense or class accordingly.

**Q**: Why can't I find the expenditure I inputted via the `e/ view/ t/` function?

**A**: Double check if you have inputted in the type of expenditure by using the list command 
to check if there exists an `NA` after the expenditure description. If so, amend accordingly 
and then `e/ view/ t/` should work as expected.

**Q**: What kind of timetable is the app able to display? Is it for the whole semester, one month 
or one week?

**A**: CantVas is able to display your timetable from Monday to Friday for classes in the semester using
a list format for each day, arranged based on the time of the day. For example, if we have a 3-hour 
CG2023 from 1pm on monday at E4-03-07 and a 2-hour EE2026 from 9am on monday at LT6, the list will output:
> Monday:
> - Code: ee2026, Class Time: 9, Duration: 3, Location: LT6
> - ode: ee2026, Class Time: 10, Duration: 2, Location: LT6
> - Code: ee2026, Class Time: 11, Duration: 1, Location: LT6
> - Code: cg2023, Class Time: 13, Duration: 3, Location: E4-03-07
> - Code: cg2023, Class Time: 14, Duration: 2, Location: E4-03-07
> - Code: cg2023, Class Time: 15, Duration: 1, Location: E4-03-07

Take note that each hour is listed out as an individual row. Hence, for any classes lasting more than an
hour, there will be more than one rows for such classes. But each row will have `total hours -1` value
for the duration.

## Command Summary
- For addition of expenditure without type: `e/ add/ d/ <description> amt/ <cost> date/ <dd.mm.yyyy>`.
- For addition of expenditure with type: `e/ add/ d/ <description> t/ <type> amt/ <cost> date/ <dd.mm.yyyy>`.
- For deletion of saved expenditure: `e/ del/ <index>`.
- For clearing of all expenditures: `clearlist`.
- For listing of all expenditures: `list`.
- For viewing of expenditures filtered by month: `e/ view/ m/ <mm.yyyy>`.
- For viewing of expenditures filtered by year: `e/ view/ y/ <yyyy>`.
- For viewing of expenditures filtered by type: `e/ view/ t/ <type>`.
- For inputting of timetable classes: `tt/ add/ day/ <day> code/ <classCode> time/ <hh> duration/ <duration>
  location/ <location>`.
- For deletion of saved timetable classes: `tt/ del/ day/ <day> time/ <hh>`.
- For using GPA calculator: `gpa`.

