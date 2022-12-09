package ciphers

@main def main(): Unit = {
    import scala.io.StdIn.readLine
    val data = Vector("hello", "lol", "hey", "the", "cat", "more", "i", "can", "would", "you", "me", "because", "he", "she", "how", "do", "please", "where", "so", "that", "that", "is")
    val cipher = CeasarCipher(readLine, data)
    println(cipher.decrypt())

}