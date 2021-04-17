
fun main(){
    val list = arrayListOf<Int>(7,20,14,12,2,9,10,4,16,5,0,17,19,8,18,1,11,6,3,13,15)
    val algorithms = SortingAlgorithms()

    println("Starting Sort")
    val begin = System.nanoTime()

    println(algorithms.insertionSort(list))

    val end = System.nanoTime()
    println("Sort algorithm Execution Time: ${end-begin} nanoseconds")
}