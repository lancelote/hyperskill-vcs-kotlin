package stage1.hw28

fun main() {
    val numOfCompanies = readLine()!!.toInt()
    val incomes = IntArray(numOfCompanies)
    val taxes = IntArray(numOfCompanies)

    for (i in 0 until numOfCompanies) {
        incomes[i] = readLine()!!.toInt()
    }

    for (i in 0 until numOfCompanies) {
        taxes[i] = readLine()!!.toInt()
    }

    val taxPaid = DoubleArray(numOfCompanies)

    for (i in 0 until numOfCompanies) {
        taxPaid[i] = incomes[i] * taxes[i] / 100.0
    }

    var maxTaxPaid = 0.0
    var maxTaxPaidCompany = 0

    for ((i, amount) in taxPaid.withIndex()) {
        if (amount > maxTaxPaid) {
            maxTaxPaid = amount
            maxTaxPaidCompany = i
        }
    }

    println(maxTaxPaidCompany + 1)
}
