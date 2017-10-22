private const val DEFAULT_BUCKET_SIZE = 5

fun main(args: Array<String>) {
    val array = intArrayOf(1, 89, 56, 72, 34, 7, 12, 66)
    sort(array)
    array.forEach {
        println(it)
    }
}

fun sort(array: IntArray) {
    sort(array, DEFAULT_BUCKET_SIZE)
}

fun sort(array: IntArray, bucketSize: Int) {
    if (array.isEmpty()) {
        return
    }

    val minValue = array.min()!!
    val maxValue = array.max()!!

    val bucketCount = (maxValue - minValue) / bucketSize + 1
    val buckets = mutableListOf<MutableList<Int>>().apply {
        for (i in 0 until bucketCount) {
            add(mutableListOf())
        }
    }

    array.forEach {
        buckets[(it - minValue) / bucketSize].add(it)
    }

    var currentIndex = 0
    for (i in buckets.indices) {
        val bucketArray = buckets[i].toIntArray().sortedArray()
        for (j in bucketArray.indices) {
            array[currentIndex++] = bucketArray[j]
        }
    }
}
