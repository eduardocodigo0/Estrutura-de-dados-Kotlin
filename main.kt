
fun main(){
    val cache = LRUCache<String, Int>(3)

    cache.setValue("a", 1)
    cache.setValue("b", 2)
    cache.setValue("c", 3)
    cache.setValue("d", 4)
    println(cache.getValue("b"))
    cache.setValue("e", 5)
    cache.setValue("f", 6)
    println(cache.getValue("b"))
    cache.setValue("g", 7)
    cache.setValue("f", 12)


    println(cache.getValue("a"))
    println(cache.getValue("b"))
    println(cache.getValue("c"))
    println(cache.getValue("d"))
    println(cache.getValue("e"))
    println(cache.getValue("f"))
    println(cache.getValue("g"))
}