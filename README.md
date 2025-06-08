# 📦 Package Challenge Solver

This Java application solves the **Package Challenge**: selecting the best combination of items to pack without exceeding a weight limit, while maximizing total cost. If multiple combinations give the same cost, the one with the lowest total weight is preferred.

---

## 🧩 Problem Description

You are given a number of items, each with:

- An index (starting from 1),
- A weight in kilograms,
- A cost in euros (€).

You want to send a package with these items. The package has a **weight limit (≤ 100 kg)**. Your goal is to **select the subset of items** with:

- The **highest total cost**,  
- Not exceeding the weight limit,  
- Among options with the same cost, prefer the one with **lower total weight**.

If no combination fits the weight constraint, return `-`.

---

## ✅ Constraints

- Max weight the package can carry: **≤ 100**
- Max number of items per test case: **≤ 15**
- Each item's:
  - Weight: **≤ 100**
  - Cost: **≤ €100**

Invalid inputs (constraint violations) throw an exception with a helpful error message.

---

## 📄 Input Format

Each line in the input file represents a test case:

[package weight] : (index,weight,€cost) (index,weight,€cost) ..

### Example:
81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)

---

## 📤 Output Format

For each test case, print:

- A comma-separated list of item indices (in ascending order) **if a valid selection exists**  
- `-` if **no valid combination** fits the constraints

### Example Output:

4
-
2,7
8,9

---

## 📁 Sample input.txt

81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
8 : (1,15.3,€34)
75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)
56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)


---

## 💻 How to Run

1. Compile the Java program:

```bash
cd C:\Users\yasemin\Desktop\demo>
java -cp out;log4j-api-2.24.3.jar;log4j-core-2.3.2.jar PackageSolverStr src\main\resources\input.txt
````

## Technologies

- Java 11+

- Standard Input/Output

- Object-Oriented Design (Item class)

Bitmasking fo- r subset evaluation

👨‍💻 Author
Developed with ❤️ by Yasemin 
For improvements or feedback, feel free to submit a PR or contact.


