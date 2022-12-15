package ciphers

case class CeasarCipher(input: String, wordDatabase: Vector[String]) {
    import scala.collection.mutable.Buffer

    val data: Sentence = Sentence(input.toLowerCase())
    val guesses: Buffer[String] = Buffer.empty[String]

    def encrypt(shiftNum: Int): Unit = 
        data.shiftSentence(shiftNum)

    def encryptRandom(): Unit =
        import scala.util.Random.nextInt
        data.shiftSentence(nextInt(Letter.alphabet.size-1)+1)

    def decrypt(): Unit =
        for i <- 1 to Letter.alphabet.size-1 do
            data.shiftSentence(1)
            var possibleSolution = data.toString
            var shiftedWords = possibleSolution.split(" ")
            if wordDatabase.contains(shiftedWords(0)) then
                guesses += possibleSolution
}
