case class CeasarCipher(sentence: String, wordDatabase: Vector[String]) {
    var rawData: String = sentence.toLowerCase()
    

    def ciphShift(shiftNum: Int, data: String = rawData): String =
        data.map(letter => 
            if letter != ' ' && letter != '.' then
                (((letter.toInt-97 + shiftNum) % 26)+97).toChar
            else letter  
        ).toString

    def encrypt(shiftNum: Int, data: String = rawData): String = 
        ciphShift(shiftNum, data)

    def encryptRandom(data: String = rawData): String =
        import scala.util.Random.nextInt
        ciphShift(nextInt(25)+1, data)

    def decrypt(data: String = rawData): Vector[String] =
        import scala.collection.mutable.Buffer
        var guesses: Buffer[String] = Buffer.empty[String]
        for i <- 1 to 25 do
            var possibleSolution = ciphShift(i, data)
            var shiftedWords = possibleSolution.split(" ")
            if wordDatabase.contains(shiftedWords(0)) then
                guesses += possibleSolution
        guesses.toVector      
}

@main def main(): Unit = {
    import scala.io.StdIn.readLine
    val data = Vector("hello", "lol", "hey", "the", "cat", "more", "i", "can", "would", "you", "me", "because", "he", "she", "how", "do", "please")
    val cipher = CeasarCipher(readLine, data)
    val krypterat = cipher.encryptRandom()
    println(krypterat)
    println(cipher.decrypt())

}