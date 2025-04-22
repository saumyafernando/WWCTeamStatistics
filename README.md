# 🏆 FIFA WWC Team Statistics – Java Project

A Java application to manage and analyze FIFA Women's World Cup (WWC) team statistics. Built as a two-part system, the project includes a data entry module to collect team data and a data analysis module that provides statistical insights.

---

## 📌 Project Overview

This software simulates a real-world WWC statistics management system. It is designed for educational purposes and demonstrates principles of input validation, file I/O, class design, and data analysis.

The project consists of two main programs:

- **Data Entry Program** – collect and validate team information, then store it in a CSV file.
- **Data Analysis Program** – read the CSV file, create `Team` objects, sort them, and display performance statistics.

---

###🧠 Key Concepts

- Object-Oriented Programming (encapsulation, classes)
- Manual array resizing (no ArrayLists used)
- File I/O using PrintWriter and BufferedReader
- Selection Sort implementation
- Input validation with regular expressions
- Modular design with single-responsibility classes


---

## ⚙️ Features

### 🔹 Data Entry Program

- Collects the following information from the user:
  - Team Name (e.g., *Matildas*)
  - Team Code (3-letter, e.g., *AUS*)
  - Goals Scored by the Team
  - Goals Scored Against the Team
  - Group (A, B, C, or D)
- Validates all inputs:
  - Names must not be empty or contain numbers
  - Codes must be 3 capital letters
  - Scores must be non-negative integers
  - Group must be A, B, C, or D
- Prevents duplicate team names and codes
- Displays the entered data
- Exports all data into a user-named `.csv` file

### 🔹 Data Analysis Program

- Imports data from the CSV file
- Creates and stores `Team` objects in an array
- Calculates:
  - **Net Goals** = Goals For − Goals Against
- Allows two types of analysis:
  1. **Overall Analysis** – on all teams
  2. **Group Analysis** – filtered by Group A–D
- Sorting Options:
  - Teams by Net Goals (descending)
  - Teams by Goals Against (descending)
  - Teams by Goals Scored (descending)
- Displays the best-performing team(s) with the highest net goals

---

## 📁 Project Structure

```
WWCTeamStatistics/
│
├── DataEntryApp.java
│   - Entry point for data entry.
│   - Handles user interactions to input team data.
│   - Uses:
│     - `Team.java` from `Objects` package
│     - `UserManager.java` & `CSVWriter.java` from `Managers` package
│
├── DataAnalysisApp.java
│   - Entry point for analyzing stored data.
│   - Uses:
│     - `Team.java` from `Objects` package
│     - `Analyzer.java` & `CSVReader.java` from `Managers` package
│
├── Objects/
│   └── Team.java
│       - Defines attributes of a team: name, code, goals for/against, group, net goals
│       - Used by both entry and analysis apps
│
└── Managers/
    ├── Analyzer.java
    │   - Performs overall and group-based analysis
    │   - Used by `DataAnalysisApp`
    │
    ├── CSVReader.java
    │   - Reads team data from CSV file
    │   - Used by `DataAnalysisApp`
    │
    ├── UserManager.java
    │   - Handles team input, validation, duplicate check
    │   - Used by `DataEntryApp`
    │
    └── CSVWriter.java
        - Writes team data to CSV file
        - Used by `DataEntryApp`
```

---


---

## 💡 Example CSV Format

```csv
Team Name,Team Code,Goals For,Goals Against,Group
Matildas,AUS,5,1,A
England,ENG,3,0,B
Japan,JPN,4,2,C
```


---
## 🚀 How to Run

**Compile all Java files:**
```bash
javac Objects/Team.java Managers/*.java DataEntryApp.java DataAnalysisApp.java
```

**Run the data entry program:**
```bash
java DataEntryApp
```
**Run the data analysis program:**
```bash
java DataAnalysisApp
```
___



## 🎓 Reference

> I declare that I referred to **FreeCodeCamp** as a learning resource to understand and implement the regular expressions in my code for exception handling.

Ferdous, T. (2023, August 1).  
*A Practical Guide to Regular Expressions – Learn RegEx with Real Life Examples.*  
freeCodeCamp.org  
🔗 [https://www.freecodecamp.org/news/practical-regex-guide-with-real-life-examples/](https://www.freecodecamp.org/news/practical-regex-guide-with-real-life-examples/)

---

## 👨‍💻 Author

**Naveen Fernando**  
*Curtin University | 2023*

---

