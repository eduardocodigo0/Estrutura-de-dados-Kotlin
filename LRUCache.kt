class LRUCache<K, V>(private val maxSize: Int) {

    private val cache = hashMapOf<K, V>()
    private var cachedKeyList = mutableListOf<K>()

    fun getValue(key: K): V? {
        updateListTop(key)
        return cache[key]
    }

    fun setValue(key: K, value: V){
        cache[key] = value
        updateListTop(key)
        updateListBottom()
    }

    private fun updateListTop(key: K) {
        cachedKeyList.remove(key)
        cachedKeyList.add(key)
    }

    private fun updateListBottom(){
        if(cachedKeyList.size > maxSize){
            cache.remove(cachedKeyList.first())
            cachedKeyList.remove(cachedKeyList.first())
        }
    }
}