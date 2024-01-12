package advent.advent2022

abstract class Record(val parent: Dir?, val name: String) {
    abstract fun size(): Long
}

class Dir(parent: Dir?, name: String) : Record(parent, name) {
    var items: List<Record> = emptyList()

    override fun size(): Long {
        var size = 0L
        for (item in items) {
            size += item.size()
        }
        return size
    }
}

class File(parent: Dir?, name: String, val size: Long) : Record(parent, name) {

    override fun size(): Long {
        return size
    }
}
