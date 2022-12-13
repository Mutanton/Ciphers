package ciphers

class VigenereCipher() {

    private def generateTable() =
        var first = true
        import scala.collection.mutable.Buffer
        var alphabetRow = Letter.alphabet.toBuffer

        def shiftAlphabet(): Buffer[Char] =
            if !first then
                var tempLetter = alphabetRow(0)
                alphabetRow -= tempLetter
                alphabetRow.append(tempLetter)
                alphabetRow
            else 
                first = false
                alphabetRow

        var table: Vector[Vector[Char]] = Vector.fill(alphabetRow.size)(shiftAlphabet().toVector)    
        table

    lazy val vigenereTable: Vector[Vector[Char]] = generateTable()
    
    def getEncryptedChar(unencryptedChar: Char, key: Char): Char =
        vigenereTable(key.toLetter().position())(unencryptedChar.toLetter().position())

    def encrypt(message: String, key: String): String =
        val result = StringBuilder(message.length())
        message.indices.foreach(messageIndex => 
            var keyPartIndex: Int = messageIndex % key.length()
            result += getEncryptedChar(message(messageIndex), key(keyPartIndex))
        )
        result.toString

    def encryptRandom(): (String, String) =
        ???

    def decrypt(encryptedMessage: String, key: String): String =
        val result = StringBuilder(encryptedMessage.length())
        encryptedMessage.indices.foreach(messageIndex =>
            var keyPartIndex: Int = messageIndex % key.length()
            var rowIndex: Int = vigenereTable(key(keyPartIndex).toLetter().position()).indexOf(encryptedMessage(messageIndex))
            result += vigenereTable(0)(rowIndex)
        )
        result.toString


    override def toString(): String =
        var result = ""
        vigenereTable.foreach(row => 
            result += row.mkString.replace("", " ").trim() 
            result += "\n"
        )
        result
}