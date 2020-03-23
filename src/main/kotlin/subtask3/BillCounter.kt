package subtask3

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {

        var mutableBill = bill.toCollection(ArrayList())
        if(k >= 0 && k < mutableBill.size)
        {
            mutableBill.removeAt(k)
        }

        val actualSumAnna = mutableBill.sum()

        val sumAnnaInt = b
        val actualSumAnnaInt = actualSumAnna / 2;

        if(actualSumAnnaInt == sumAnnaInt)
        {
            return "Bon Appetit";
        }
        else
        {
            return (sumAnnaInt - actualSumAnnaInt).toString();
        }
    }
}
