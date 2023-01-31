class Stack<T> {
    private var myStackList: MutableList<T> = mutableListOf()

    fun push(item: T){
        myStackList.add(item)
    }

    fun pop(): T? {
        return if (!isEmpty()){
            val item: T? = myStackList.last()
            myStackList.removeAt(myStackList.lastIndex)
            item
        } else null
    }

    fun isEmpty(): Boolean {
        return myStackList.size == 0
    }

}