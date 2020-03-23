package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        var sum = input.sum()
        var min = sum;
        var max = 0;

        for(currentNum:Int in input)
        {
            val currentSum = sum - currentNum
            if(currentSum < min)
                min = currentSum
            if(currentSum > max)
                max = currentSum
        }

        return intArrayOf(min, max)
    }
}
