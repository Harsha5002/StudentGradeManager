# Student Grade Manager 📚

A console-based Java application to manage student grades. Built this to practice Java collections and basic OOP concepts.

## What it does
- Add students by name
- Assign multiple subject marks to each student
- Auto-calculates average and assigns grade (A+, A, B, C, D, F)
- Clean report view for all students

## How to run

```bash
javac StudentGradeManager.java
java StudentGradeManager
```

## Sample Output

```
=== Student Grade Manager ===
1. Add Student
2. Add Marks
3. View Report
4. Exit

--- Grade Report ---
Harsha → Avg: 85.00 | Grade: A
Riya   → Avg: 72.50 | Grade: B
```

## Tech used
- Java (Collections, Scanner, Streams)
- No external libraries — pure Java

## What I learned
Working with `LinkedHashMap` to preserve insertion order, using Java Streams for average calculation, and building a simple menu-driven program.
