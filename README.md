## Problem Statement
The goal of this project is to create a simple string calculator that can handle various input formats. The primary task is to implement an add method that takes a string of numbers and returns their sum, adhering to specific rules and requirements.

## Approach
Tests are written incrementally for each step of the development, ensuring that the code adheres to the requirements given. 
### Step 1 - Creating a StringCalculator with a basic Add method 
- Started by creating a 'StringCalculator' class with a method 'add(String numbers)' that returns an integer
- Began with the simplest cases as stated in the description, like an empty String or a single number, and gradually added more complex cases. 
- Assumed (',') as the default delimiter to split the input String. 
- Used regular expressions to extract numbers from the String.
- Used Java Streams to achieve sum operation, which is easy and handy for unknown number of numbers.
- When the new delimiter was introduced (new line), introduced a more complex regex to meet the requirement.

### Step 2 - Handling a different delimiter
- New delimiter requirement was introduced with the following rule: "//[delimiter]\n[numbers]"
- Added more logic to change the default delimiters (',' '\n') if the String starts with '//' but the code already got more complex.

### Step 3 - Handling negative numbers
- Implemented to logic to peek the negative numbers from stream and to add the number to a new list (negatives).
- If the negatives are greater than zero, NegativeNumberException is thrown. 

### Step 4 - Handling negative numbers
- Modified the code to ignore numbers greater than 1000 when calculating the sum by adding filter to Java Streams.

### Step 5 - Allowing multiple delimiters
- When the new requirement of allowing multiple delimiters was introduced, it was very clear that initial solution which was extracting integers from a given String was not a proper choice.
- Then, the logic was changed to extract any other characters rather than negative and positive numbers by using the following regex: "[-+]?\\d+"
- Another list was introduced to add the positive numbers matching with the given regex. 
- Previous requirements were also ensured in the new logic such as ignoring numbers greater than 1000 or throwing exception if there is any negative numbers in the given String. 
- This new approach helped to meet the final requirement, which is handling multiple delimiters of any length. 

## Conclusion 
It was a good exercise especially for practicing TDD. It took a few rounds to complete it around 30mins, although it was a need to get help for regex. 

