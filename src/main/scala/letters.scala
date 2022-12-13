package ciphers

class Letter(input: Char) {
    import Letter.*
    var value = input.toLower

    def shiftLetter(shiftNum: Int): Unit =
        if value != ' ' then
            value = alphabet((alphabet.indexOf(value) + shiftNum) % 29)

    def position(): Int = alphabet.indexOf(value)
}

object Letter {
    import scala.util.Random.nextInt
    def random(): Letter = alphabet(nextInt(alphabet.length))

    val alphabet: Vector[Char] = Vector('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'å', 'ä', 'ö')
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

extension (c: Char) {
    def toLetter(): Letter = Letter(c)
}