class Parameters(a: String) {
    private val name: String

    init {
        name = a
    }

    fun displayName() {
        println("my name is ${name}")
    }

    fun displayArrayList(array:Array<Any>){
        for (item in array){
         println(item)
        }

    }
}