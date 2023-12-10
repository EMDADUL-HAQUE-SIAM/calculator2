fun calculateArea(height: Int, width: Int) : Int {
    return  height * width
}

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${calculateArea(16,12)}")
}