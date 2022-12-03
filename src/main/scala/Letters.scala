package ciphers

class Letter(input: Char) {
    var value = input
    private val alphabet: Vector[Char] = Vector('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'å', 'ä', 'ö')

    def shiftLetter(shiftNum: Int): Unit =
        if value != ' ' then
            value = alphabet((alphabet.indexOf(value) + shiftNum) % 29)
}

class Sentence(input: String) {
    private var sentence = input.map(char => Letter(char)).toVector

    def shiftSentence(shiftNum: Int): Unit =
        sentence.foreach(letter => 
            letter.shiftLetter(shiftNum)
        )

    override def toString(): String =
        var result: String = ""
        sentence.foreach(letter =>
            result += letter.value.toString
        )
        result
}