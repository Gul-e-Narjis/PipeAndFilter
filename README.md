# Description of the Code
This program demonstrates the Pipe and Filter pattern using Java Streams. The input list of integers passes through a series of transformations (filters), each applied sequentially. The filters are added to a pipeline in an ArrayList, and processPipeline() processes them in order.

# Newly Added Filters and Their Working
# ->Increment Numbers by 5 (incrementNumbersByFive)

Function: Increases each number in the list by 5.

Working: Uses .map(n -> n + 5), which adds 5 to every element.

Example: [16, 36, 64, 100] → [21, 41, 69, 105].

# ->Filter Odd Numbers (filterOddNumbers)

Function: Keeps only even numbers, removing all odd numbers.

Working: Uses .filter(n -> n % 2 == 0), which retains numbers divisible by 2.

Effect: Since the previous filter (incrementNumbersByFive) made all numbers odd, this results in an empty list.

Example: [21, 41, 69, 105] → [].

# ->How the Filters Work in Sequence
filterEvenNumbers: Retains only even numbers.

squareNumbers: Squares the remaining numbers.

filterNumbersGreaterThanTen: Keeps numbers greater than 10.

incrementNumbersByFive (New): Adds 5 to each number.

filterOddNumbers (New): Removes all odd numbers (resulting in an empty list).

# ->Final Outcome
Since incrementNumbersByFive makes all numbers odd, and filterOddNumbers removes odd numbers, the final output is an empty list [].
