class SortingAlgorithms {

    fun bogoSort(list: ArrayList<Int>): ArrayList<Int>{

        while(!isInOrder(list)) {
            list.forEachIndexed { index, value ->

                val bogoIndex = (0 until list.size).random()

                val temp = value
                list[index] = list[bogoIndex]
                list[bogoIndex] = temp

            }
        }

        return list
    }

    fun insertionSort(list: ArrayList<Int>): ArrayList<Int>{

        for(i in list.indices){
            if(i == 0) continue

            val chosen = list[i]
            var j = i - 1

            while((j >= 0) && (list[j] > chosen)){
                list[j + 1] = list[j]
                --j
            }

            list[j + 1] = chosen
        }

        return list
    }




    private fun isInOrder(list: ArrayList<Int>): Boolean{

        for(i in list.indices){

            if(i == 0) continue

            if(list[i - 1] > list[i] ) return false

        }
        return true
    }


}