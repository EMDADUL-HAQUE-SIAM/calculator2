class Company(Name: String , Salary:Int){
    val companyName: String
    var employeeSalary: Int

    init{
        companyName = "Simec"
        employeeSalary = Salary
    }

    fun incrementSalary(): Int{
        employeeSalary = employeeSalary + 10
        return employeeSalary
    }

    fun decrementSalary() {
        employeeSalary = employeeSalary - 5
        println("decrementSalary: ${employeeSalary}")
    }
}

fun main(){
    println("Digital foundation")

    val employee = Company("Shamil", 1000)
    println("Employee name is : ${employee.companyName}")

    println("Employee incremented salary : ${employee.incrementSalary()}")

    employee.decrementSalary()


}