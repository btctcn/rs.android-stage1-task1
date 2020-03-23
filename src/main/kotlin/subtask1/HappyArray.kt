package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {

        if(sadArray.size < 3)
            return sadArray

        val mutableSadArray = sadArray.toCollection(ArrayList())
        val indiciesToRemove = ArrayList<Int>()
        var currentArrayLen = sadArray.size
        var reducedArrayLen = 0;
        while(reducedArrayLen != currentArrayLen)
        {
            currentArrayLen = mutableSadArray.size;
            for(i:Int in 1..currentArrayLen - 2)
            {
                val prev = mutableSadArray[i-1];
                val curr = mutableSadArray[i];
                val next = mutableSadArray[i+1];
                if((prev + next) < curr)
                {
                    indiciesToRemove.add(i);
                }
            }

            for(i: Int in indiciesToRemove.size - 1 downTo 0)
            {
                mutableSadArray.removeAt(indiciesToRemove[i])
            }

            indiciesToRemove.clear()

            reducedArrayLen = mutableSadArray.size;
        }

        return mutableSadArray.toIntArray();
    }
}
