# Dynamic Programming Spring Boot Application

## How It Works

1. **Spring Boot Initialization:**
    - The app starts from the `@SpringBootApplication` class (via `main()`).
    - Spring Boot initializes the application context.

2. **Spring Bean Creation:**
    - Spring scans the package and creates beans for classes annotated with `@Component`.
    - Dependencies are automatically injected with `@Autowired` and `@Qualifier`.

3. **CommandLineRunner Execution:**
    - The `Runner` class implements `CommandLineRunner`, which is automatically run when the app starts.
    - The `run()` method is executed and computes the solution for a dynamic programming problem.

4. **Problem Execution:**
    - `ClimbingStairs` (or another class) receives input via setter methods and calculates the result when `solve()` is called.

---

## What to Change to Run a New Class?

To run a new dynamic programming problem:

1. **In the `Runner` class, change the `@Qualifier` name**
    - Update the `@Qualifier` to match the new class name in the `Runner` constructor. The class name will be in lowercase by default (e.g., `"fibonacci"` for the `Fibonacci` class).

2. **Make it an instance of the new class in the `run()` method**
    - Inside the `run()` method of `Runner`, check if the `configDP` bean is an instance of the new class, and set the necessary parameters (e.g., `n`).

---

## Example: Editing `Runner` to Add `Fibonacci` Class

Let's say we want to add a `Fibonacci` class to the project. Here's what we need to change in the `Runner` class:

1. **Change the `@Qualifier` annotation to the new class name:**

    - Update the `@Qualifier` in the constructor of `Runner` to `"fibonacci"` to match the `Fibonacci` class.
2. **Make it an instance of new class in run methods.
   Example change in the `Runner` class:**
   ```java
   @Autowired
   public Runner(@Qualifier("fibonacci") dp configDP) {
       this.configDP = configDP;
   }
   if (configDP instanceof Fibonacci) {
            "Fibonacci" climbingStairs = ("Fibonacci") configDP;
            climbingStairs.setN(10);  // Set `n` to 10 for ClimbingStairs
    }
