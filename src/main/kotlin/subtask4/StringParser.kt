package subtask4

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val openBrackets =  arrayOf("<", "[","(")
        val closeBrackets = arrayOf(">", "]", ")")
        var returnArray = ArrayList<String>()
        var bracketsPairs = HashMap<Int, Int>()

        for (i:Int in 0..openBrackets.size - 1)
        {
            val currentOpenBracket = openBrackets[i];
            val currentCloseBracket = closeBrackets[i];
            val openBracketPositions = ArrayList<Int>();
            val closeBracketPositions = ArrayList<Int>();

            var location:Int = 0
            while (true)
            {
                location = if (location > 0)  location + 1 else 0;
               // var rangeLen = string.length - rangeLocation;
                location = inputString.indexOf(currentOpenBracket, startIndex = location, ignoreCase = true)

                if(location == -1)
                    break;
                openBracketPositions.add(location)
            }

            location = 0
            while (true)
            {
                location = if (location > 0)  location + 1 else 0;
                // var rangeLen = string.length - rangeLocation;
                location = inputString.indexOf(currentCloseBracket, startIndex = location, ignoreCase = true)

                if(location == -1)
                    break;
                closeBracketPositions.add(location)
            }

            while (openBracketPositions.size > 0)
            {
                val currentOpenPos = openBracketPositions.last()
                for(closePos in closeBracketPositions)
                {
                    if(closePos < currentOpenPos) continue;
                    bracketsPairs[openBracketPositions.last()] = closePos
                    closeBracketPositions.remove(closePos)
                    break;
                }
                openBracketPositions.removeAt(openBracketPositions.lastIndex)
            }
            closeBracketPositions.clear()
        }

        bracketsPairs.keys.sorted()
        for(key:Int in bracketsPairs.keys.sorted())
        {
            val subStr = inputString.substring(IntRange (key + 1, bracketsPairs[key]!! - 1) );
            returnArray.add(subStr);
        }

        return returnArray.toTypedArray()
    }
}
