
fun main(){
    var list = LinkedList.create()


    list.insertEnd(0)
    list.insertEnd(2)
    list.insertEnd(8)
    list.insertEnd(9)
    list.insertEnd(2)
    list.insertEnd(2)

    list.insertStart(0)
    list.insertStart(4)


    list.printList()

    println(list.find(1))
    println(list.find(2))

    list.delete(4)

    list.printList()

}