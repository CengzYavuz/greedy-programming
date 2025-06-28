# 🎯 Greedy Judge Assignment

**Greedy Judge Assignment** is a Java-based application that implements a greedy algorithm to assign sequential programming problems to multiple judges, minimizing the total cost of switching between problem types. This solution was developed as part of the **Algorithm Analysis** coursework at Dokuz Eylül University.

---

## 📝 Problem Definition

In a programming contest, problems arrive in a fixed order and each has a type (difficulty/category). You have **J judges**, each can evaluate one problem at a time. Switching a judge from one problem type to another incurs a constant **switch cost**. You must assign each problem, in arrival order, to judges so that the **total switch cost** across all judges is minimized.

**Inputs:**

1. Number of judges (**J**)
2. Cost of switching problem types (**C**)
3. File `input.txt` listing problem types in order (e.g. `2 1 3 2 1`)

**Output:**

* Minimum total switch cost required to process all problems in sequence.

**Examples:**

> **Example 1** (J=3, C=3)
> Problem types: 2, 1, 3, 2, 1
> Minimum total cost: 9

> **Example 2** (J=2, C=1)
> Problem types: 1, 3, 4, 2, 1, 2, 3, 4, 1
> Minimum total cost: 6

> **Example 3** (J=3, C=1)
> Problem types: 7, 1, 7, 6, 3, 2, 1, 3, 6, 5, 7, 6
> Minimum total cost: 8

---

## 🚀 Features

* **Greedy Assignment**
  Assigns each new problem to the judge whose last-assigned type matches if possible, otherwise to the judge whose switch incurs minimal cost.

* **Sequential Processing**
  Processes problems in the exact input order—no reordering allowed.

* **Configurable Parameters**
  Number of judges and switch cost are read interactively or via command-line arguments.

* **Runtime Annotations**
  Each method includes a comment with its worst-case time complexity.

---

## 🛠️ Installation & Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-org/greedy-judge-assignment.git
   cd greedy-judge-assignment
   ```

2. **Import into IntelliJ IDEA**

   * Open IntelliJ IDEA > **Open** > select project folder.
   * Ensure JDK 11+ is configured in **Project Structure**.

3. **Run in IDE**

   * Locate `com.yourpackage.Main.java`.
   * Run with **Run ▶**.
   * Enter prompts for judges, switch cost, and ensure `input.txt` is in the project root.

4. **Command-Line Build & Run**

   ```bash
   # Compile
   javac -d out src/**/*.java

   # Run
   java -cp out com.yourpackage.Main
   ```

---

## 📂 Code Structure

```text
src/
└── com/yourpackage/
    ├── Main.java           # Entry point; handles input & output
    ├── GreedyAssigner.java # Implements the greedy algorithm (O(N·J))
    ├── Judge.java          # Represents judge state and last problem type
    └── util/
        └── InputReader.java # Reads and parses input.txt into a list
```

---

## ⚙️ Algorithm Complexity

* **Time**: O(N × J), where N is number of problems and J is number of judges.
* **Space**: O(J + N) for judge states and problem list.

---

## 🔮 Future Improvements

* **Priority Queue**: Use a heap to find the best judge in O(log J) per assignment.
* **Batch Processing**: Group identical types to reduce repeated checks.
* **Unit Tests**: Add JUnit tests covering edge cases (no judges, single judge, all identical types).
* **GUI/CLI Options**: Accept command-line flags for input/output file names and parameters.

---

## 📧 Contact

**Ahmed Cengiz**
Email: [ahmedcengizyavuz@gmail.com](mailto:ahmedcengizyavuz@gmail.com)
