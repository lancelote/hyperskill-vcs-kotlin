package stage1.hw36

fun main() {
    val priceList = mapOf("Cola" to 500, "Apple" to 1500, "Banana" to 300)
    val shoppingList = mutableListOf("Cola", "Apple")
    println(bill(priceList, shoppingList))
}

fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    var total = 0

    for (shoppingItem in shoppingList) {
        total += priceList.getOrDefault(shoppingItem, 0)
    }

    return total
}
