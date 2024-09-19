# Diploma Project (part №1): Java Automation Testing 

## Overview
This project demonstrates the implementation of unit tests in a Java application using **JUnit 4**, **Mockito**, and **Jacoco**. The goal is to ensure comprehensive testing with a minimum of 70% code coverage for key business logic in the `Bun`, `Burger`, `Ingredient`, and `IngredientType` classes.

## Key Technologies
- **JUnit 4**: Unit testing framework.
- **Mockito**: Used for creating mock objects to simulate dependencies.
- **Jacoco**: Integrated for measuring code coverage.

## Objectives
1. Achieve **70%+** code coverage.
2. Implement unit tests for:
   - `Bun`
   - `Burger`
   - `Ingredient`
   - `IngredientType`
3. Use **mocks**, **stubs**, and **parameterized tests** where applicable.

## Implementation

### Class Tests

#### 1. `BunTest`
Tests the functionality of the `Bun` class (name and price attributes).

- **Key Tests**:
  - `getNameTest()`: Asserts the name of the bun.
  - `getPriceTest()`: Verifies the price of the bun.

#### 2. `BurgerTest`
Covers the core operations of the `Burger` class, including ingredient management and price calculation.

- **Key Tests**:
  - `addIngredientTest()`: Ensures proper ingredient addition.
  - `removeIngredientTest()`: Tests ingredient removal.
  - `moveIngredientTest()`: Validates ingredient reordering.
  - `getPriceTest()`: Calculates total price with mocked bun and ingredients.
  - `getReceiptTest()`: Generates a burger receipt with mocked values.

#### 3. `IngredientTest`
Parameterized tests for the `Ingredient` class, covering different ingredient types (`SAUCE`, `FILLING`).

- **Key Tests**:
  - `getNameTest()`: Asserts ingredient name.
  - `getPriceTest()`: Verifies ingredient price.
  - `getTypeTest()`: Ensures correct ingredient type.

### Coverage
**Jacoco** is used to monitor test coverage, ensuring that the tests meet or exceed the 70% threshold, covering all major paths and edge cases.

## Running the Project

### Prerequisites
- **Java 8 or higher**
- **Gradle/Maven** for dependencies
- **JUnit 4**, **Mockito**, and **Jacoco**

### Steps
1. Clone the repository:
   ```bash
   git clone <repository_url>
   ```
2. Navigate to the project directory:
   ```bash
   cd <project_name>
   ```
3. Run tests:
   ```bash
   ./gradlew test
   ```
4. Generate code coverage report:
   ```bash
   ./gradlew jacocoTestReport
   ```

## Reports
- **The Jacoco coverage report will be located in the build/reports/jacoco folder.**:

## Conclusion
This project showcases best practices for unit testing in Java using JUnit 4 and Mockito. Through effective use of mocking, stubbing, and parameterization, a high level of code coverage and reliability has been achieved.
