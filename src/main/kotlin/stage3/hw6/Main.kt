package stage3.hw6

fun solution(products: List<String>, product: String) {
    products.forEachIndexed { i, x -> if (x == product) print("$i ")}
}
