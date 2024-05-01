/**
 * Exercise 6
 * Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100 incrementally, replacing any number divisible by three with the word "fizz", and any number divisible by five with the word "buzz". Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".
 *
 * Use a for loop to count numbers and a when expression to decide what to print at each step.
 *
 * fun main() {
 * // Write your code here
 * }
 *
 */

fun main() {
    for (number in 1..100) {
        when {
            number % 15 == 0 -> println("fizzbuzz")
            number % 3 == 0 -> println("fizz")
            number % 5 == 0 -> println("buzz")
            else -> println(number)
        }
    }
}
