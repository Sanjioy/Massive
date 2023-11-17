fun encrypt(inputText: String, keyword: String, alphabet: List<Char>, alphabetIndices: Map<Char, Int>): String {
    val encryptedText = StringBuilder()
    val keywordIndices = keyword.map { alphabetIndices[it] ?: 0 }

    for (i in inputText.indices) {
        val char = inputText[i]
        if (char in alphabet) {
            val alphabetIndex = alphabetIndices[char] ?: 0
            val shift = keywordIndices[i % keyword.length]
            val newIndex = (alphabetIndex + shift - 1) % alphabet.size
            encryptedText.append(alphabet[newIndex])
        } else {
            encryptedText.append(char)
        }
    }

    return encryptedText.toString()
}

fun decrypt(inputText: String, keyword: String, alphabet: List<Char>, alphabetIndices: Map<Char, Int>): String {
    val decryptedText = StringBuilder()
    val keywordIndices = keyword.map { alphabetIndices[it] ?: 0 }

    for (i in inputText.indices) {
        val char = inputText[i]
        if (char in alphabet) {
            val alphabetIndex = alphabetIndices[char] ?: 0
            val shift = keywordIndices[i % keyword.length]
            val newIndex = (alphabetIndex - shift + 1 + alphabet.size) % alphabet.size
            decryptedText.append(alphabet[newIndex])
        } else {
            decryptedText.append(char)
        }
    }

    return decryptedText.toString()
}

fun main() {
    val alphabet = listOf(
        'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О',
        'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я'
    )

    val alphabetIndices = mapOf(
        'А' to 21, 'Б' to 13, 'В' to 4, 'Г' to 20, 'Д' to 22, 'Е' to 1, 'Ё' to 25, 'Ж' to 12,
        'З' to 24, 'И' to 14, 'Й' to 2, 'К' to 28, 'Л' to 9, 'М' to 23, 'Н' to 3, 'О' to 29,
        'П' to 6, 'Р' to 16, 'С' to 15, 'Т' to 11, 'У' to 26, 'Ф' to 5, 'Х' to 30, 'Ц' to 27,
        'Ч' to 8, 'Ш' to 18, 'Щ' to 10, 'Ь' to 33, 'Ы' to 31, 'Ъ' to 32, 'Э' to 19, 'Ю' to 7, 'Я' to 17
    )

    while (true) {
        println("Выберите действие:")
        println("1. Зашифровать текст")
        println("2. Расшифровать текст")
        println("3. Выйти")

        when (readLine()?.toIntOrNull() ?: 0) {
            1 -> {
                print("Введите текст для шифровки: ")
                val inputText = readLine()?.toUpperCase()
                print("Введите ключевое слово: ")
                val keyword = readLine()?.toUpperCase()

                if (inputText != null && keyword != null) {
                    val encryptedText = encrypt(inputText, keyword, alphabet, alphabetIndices)
                    println("Зашифрованный текст: $encryptedText")
                } else {
                    println("Неверный ввод.")
                }
            }
            2 -> {
                print("Введите текст для расшифровки: ")
                val inputText = readLine()?.toUpperCase()
                print("Введите ключевое слово: ")
                val keyword = readLine()?.toUpperCase()

                if (inputText != null && keyword != null) {
                    val decryptedText = decrypt(inputText, keyword, alphabet, alphabetIndices)
                    println("Расшифрованный текст: $decryptedText")
                } else {
                    println("Неверный ввод.")
                }
            }
            3 -> {
                println("Программа завершена.")
                return
            }
            else -> {
                println("Неверный выбор. Попробуйте снова.")
            }
        }
    }
}
