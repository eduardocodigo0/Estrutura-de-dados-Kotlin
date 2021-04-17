class BinaryTree {

    private var value: Int? = null
    private var nodeLeft: BinaryTree? = null
    private var nodeRight: BinaryTree? = null

    companion object {

        private var root: BinaryTree? = null
        private var treeArray: ArrayList<Int> = arrayListOf()

        fun create(): BinaryTree {

            root = BinaryTree()
            return root!!

        }

    }

    fun getRoot() = BinaryTree.root

    fun generateNewNode(value: Int): BinaryTree {
        val newNode = BinaryTree()
        newNode.value = value
        return newNode
    }

    fun insert(newValue: Int, node: BinaryTree? = BinaryTree.root) {


        if (node?.value == null) {
            node?.value = newValue
            return
        }

        if (newValue == node.value) {
            println("The tree already has this value")
            return
        }


        if (node.value!! < newValue) {

            if (node.nodeRight == null) {
                node.nodeRight = generateNewNode(newValue)
                return
            } else {
                insert(newValue, node.nodeRight!!)
            }

        } else {

            if (node.nodeLeft == null) {
                node.nodeLeft = generateNewNode(newValue)
                return
            } else {
                insert(newValue, node.nodeLeft!!)
            }

        }
    }

    fun showPreOrder(node: BinaryTree? = BinaryTree.root) {

        if (node == null) return

        println("[NODE VALUE = ${node.value}] -> L = ${node.nodeLeft?.value ?: "None"} | R = ${node.nodeRight?.value ?: "None"}")
        showPreOrder(node.nodeLeft)
        showPreOrder(node.nodeRight)

    }

    fun showPostOrder(node: BinaryTree? = BinaryTree.root) {

        if (node == null) return

        showPostOrder(node.nodeLeft)
        showPostOrder(node.nodeRight)
        println("[NODE VALUE = ${node.value}] -> L = ${node.nodeLeft?.value ?: "None"} | R = ${node.nodeRight?.value ?: "None"}")

    }

    fun showInOrder(node: BinaryTree? = BinaryTree.root) {

        if (node == null) return

        showInOrder(node.nodeLeft)
        println("[NODE VALUE = ${node.value}] -> L = ${node.nodeLeft?.value ?: "None"} | R = ${node.nodeRight?.value ?: "None"}")
        showInOrder(node.nodeRight)

    }

    private fun getInOrderSucessor(node: BinaryTree?): BinaryTree?{

        var current = node?.nodeRight

        while (true){

            if(current?.nodeLeft != null){
                current = current.nodeLeft
            }else{
                return current
            }
        }

    }

    fun delete(value: Int){

        BinaryTree.treeArray = arrayListOf()
        setTreeInArray()
        BinaryTree.root = BinaryTree()
        BinaryTree.treeArray.remove(value)
        reInsertTree()

    }

    private fun setTreeInArray(node:BinaryTree? = BinaryTree.root){

        if(node == null) return

        BinaryTree.treeArray.add(node.value!!)

        setTreeInArray(node.nodeRight)
        setTreeInArray(node.nodeLeft)

    }

    private fun reInsertTree(){

        BinaryTree.treeArray.forEach { value ->
            BinaryTree.root?.insert(newValue = value)
        }

    }

    fun search(node:BinaryTree? = BinaryTree.root, value: Int): Boolean{

        if(node == null) return false
        if(node.value == value) return true

        if(value > node.value!!){
            return search(node.nodeRight, value)
        }else{
            return search(node.nodeLeft, value)
        }

    }


    fun getHeight(node: BinaryTree? = BinaryTree.root, deepth: Int = 0): Int {

        if (node == null) {
            return deepth
        }
        val newDeepth = deepth + 1

        val hl = getHeight(node.nodeLeft, newDeepth)
        val hr = getHeight(node.nodeRight, newDeepth)

        return if (hl > hr) hl else hr

    }

    fun balanceTree(node: BinaryTree?): BinaryTree {

        var mutNode = node
        var balanceFactor = getHeight(mutNode?.nodeRight) - getHeight(mutNode?.nodeLeft)

        while(true){

            if (balanceFactor > 1) {
                mutNode = rotateLeft(mutNode)
            } else if(balanceFactor < -1){
                mutNode = rotateRight(mutNode)
            }else{
                break
            }

            balanceFactor = getHeight(mutNode?.nodeRight) - getHeight(mutNode?.nodeLeft)
        }


        mutNode?.nodeRight ?: balanceTree(mutNode?.nodeRight)
        mutNode?.nodeLeft ?: balanceTree(mutNode?.nodeLeft)

        return mutNode!!
    }

    fun balanceTree() {


        var balanceFactor = getHeight(BinaryTree.root?.nodeRight) - getHeight(BinaryTree.root?.nodeLeft)

        while (true) {

            if(balanceFactor < -1){
                BinaryTree.root = rotateRight(BinaryTree.root)
            }else if(balanceFactor > 1){
                BinaryTree.root = rotateLeft(BinaryTree.root)
            }else{
                break
            }

            balanceFactor = getHeight(BinaryTree.root?.nodeRight) - getHeight(BinaryTree.root?.nodeLeft)

        }

        BinaryTree.root?.nodeRight =  balanceTree(BinaryTree.root?.nodeRight)
        BinaryTree.root?.nodeLeft = balanceTree(BinaryTree.root?.nodeLeft)

    }

    fun rotateRight(node: BinaryTree?): BinaryTree? {

        val subTreeLeft = node?.nodeLeft
        node?.nodeLeft = subTreeLeft?.nodeRight
        subTreeLeft?.nodeRight = node

        return subTreeLeft

    }

    fun rotateLeft(node: BinaryTree?): BinaryTree? {

        val subTreeRight = node?.nodeRight
        node?.nodeRight = subTreeRight?.nodeLeft
        subTreeRight?.nodeLeft = node

        return subTreeRight

    }


}