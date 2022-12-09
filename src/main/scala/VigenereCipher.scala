package ciphers

class VigenereCipher() {

    def generateTable() =
        import scala.collection.mutable.Buffer
        var alphabetRow = Letter.alphabet.toBuffer

        def shiftAlphabet(): Buffer[Char] =
            var tempLetter = alphabetRow.last
            alphabetRow -= tempLetter
            alphabetRow.prepend(tempLetter)
            alphabetRow

        var table: Vector[Vector[Char]] = Vector.fill(alphabetRow.size)(shiftAlphabet().toVector)    
        table
        
    lazy val VigenereTable: Vector[Vector[Char]] = generateTable()
}