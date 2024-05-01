/**
 * Exercise 5
 * You have a program that counts pizza slices until there’s a whole pizza with 8 slices. Refactor this program in two ways: Use a while loop.
 * Use a do-while loop.
 *
 * fun main() {
 * var pizzaSlices = 0
 * // Start refactoring here
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * println("There's only $pizzaSlices slice/s of pizza :(")
 * pizzaSlices++
 * // End refactoring here
 * println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
 * }
 */

fun main() {
    println("Running the while loop version:")
    countPizzaSlicesWithWhileLoop()

    println("\nRunning the do-while loop version:")
    countPizzaSlicesWithDoWhileLoop()
}

fun countPizzaSlicesWithWhileLoop() {
    var pizzaSlices = 0
    while (pizzaSlices < 8) {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    }
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}

fun countPizzaSlicesWithDoWhileLoop() {
    var pizzaSlices = 0
    do {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    } while (pizzaSlices < 8)
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}
