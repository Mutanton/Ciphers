package ciphers

class VigenereCipher() {

    def generateTable() =
        var first = true
        import scala.collection.mutable.Buffer
        var alphabetRow = Letter.alphabet.toBuffer

        def shiftAlphabet(): Buffer[Char] =
            if !first then
                var tempLetter = alphabetRow.last
                alphabetRow -= tempLetter
                alphabetRow.prepend(tempLetter)
                alphabetRow
            else 
                first = false
                alphabetRow

        var table: Vector[Vector[Char]] = Vector.fill(alphabetRow.size)(shiftAlphabet().toVector)    
        table
        
    lazy val vigenereTable: Vector[Vector[Char]] = generateTable()

    override def toString(): String =
        var result = ""
        vigenereTable.foreach(row => 
            result += row.mkString.replace("", " ").trim() 
            result += "\n"
        )
        result
}