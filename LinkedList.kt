class LinkedList() {

    private var value: Int? = null
    private var next:LinkedList? = null

    companion object{

        private var first: LinkedList? = null
            get() = first
        private var last: LinkedList? = null
            get() = last

        fun create(): LinkedList{
            first = LinkedList()
            last = first
            return first as LinkedList
        }

    }

    fun isEmpty(): Boolean{

        return LinkedList.first == null

    }

    fun printList(){

        println("===== START PRINTING LINKED LIST =====")
        var top = LinkedList.first

        while(top?.next != null){

            println(top.value)
            top = top.next

        }
        println("===== FINISHED PRINTING LINKED LIST =====")
    }

    fun insertEnd(value: Int){
        LinkedList.last?.next = LinkedList()
        LinkedList.last?.value = value
        LinkedList.last = LinkedList.last?.next

    }

    fun insertStart(value: Int){

        var new = LinkedList()
        new.value = value
        new.next = LinkedList.first

        LinkedList.first = new

    }

    fun find(value: Int): Boolean{

        var current = LinkedList.first

        while(current?.next != null){

            if(current.value == value) return true
            current = current.next
        }

        return false

    }

    fun delete(value: Int): Boolean{

        if(!find(value)) return false


        while(LinkedList.first?.value == value){
            LinkedList.first = LinkedList.first?.next
        }

        var current = LinkedList.first?.next
        var previous = LinkedList.first


        while(current!= null){

            if(current.value == value){
                previous?.next = current.next
                current = current?.next
            }else{
                previous = current
                current = current?.next
            }

        }
        return true

    }
}