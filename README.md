# FIFA WWC Team Statistics – Java Project

This project is designed to manage and analyze FIFA Women's World Cup team data using Java. It includes two main applications: one for data entry and another for data analysis.

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

