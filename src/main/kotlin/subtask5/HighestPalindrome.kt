package subtask5

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val TheInvalidPalindrome = "-1";
        val MinNumber = 0;
        val MaxNumber = 10000;

        val s = digitString;
        if(s.length == 0) return TheInvalidPalindrome;

        var nInt = n
        var kInt = k
        var minNumberInt = MinNumber
        var maxNumberInt = MaxNumber
        if(nInt < minNumberInt || nInt > maxNumberInt || kInt < minNumberInt || kInt > maxNumberInt) return TheInvalidPalindrome

        var len = s.length
        var left:String = ""
        var right:String = ""
        var middle:String = ""
        var odd = len % 2 != 0
        left = s.substring(0, len/2)
        right = s.substring (len/2 + if(odd) 1 else 0, len)
        middle = if(odd) s.substring(len/2,  len/2 + 1) else ""

        var diffCount = 0;

        var i:Int = 0
        var j:Int = right.length - 1


        while(i < left.length && j >= 0 && kInt >= 0)
        {
            var leftChar:String = left.substring(i, i+1);
            var rightChar:String = right.substring(j, j+1);

            if(!leftChar.equals(rightChar))
            {
                diffCount++;

                var leftInt = leftChar.toInt()
                var rightInt = rightChar.toInt()
                if(leftInt != 9 && rightInt != 9 && kInt >= 2)
                {
                    right = right.replaceRange(IntRange(j, j),"9")
                    left = left.replaceRange(IntRange(i, i), "9")
                    kInt-=2;
                }
                else
                {
                    if(leftInt > rightInt)
                    {
                        right = right.replaceRange(IntRange(j, j), leftChar);
                    }
                    else
                    {
                        left = left.replaceRange(IntRange(i, i), rightChar)
                    }
                    kInt--;
                }
            }
            i++
            j--
        }

        i = 0
        j = right.length - 1

        while(i < left.length && j >= 0)
        {
            if(left[i] != right[j])
                return TheInvalidPalindrome;

            i++
            j--
        }

        left += middle
        left += right

        return left;
    }
}
