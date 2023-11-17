fun main() {
    print("Введите слова через запятую: ")
    val input = readLine()

    if (input.isNullOrBlank()) {
        println("Вы не ввели слова.")
        return
    }

    val words = input.split(",").map { it.trim() }

    val groupedWords = groupWordsByAnagram(words)

    for (group in groupedWords) {
        println(group.joinToString(", "))
    }
}

fun groupWordsByAnagram(words: List<String>): List<List<String>> {
    val groupedWords = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")

        if (!groupedWords.containsKey(sortedWord)) {
            groupedWords[sortedWord] = mutableListOf()
        }

        groupedWords[sortedWord]?.add(word)
    }

    return groupedWords.values.toList()
}
