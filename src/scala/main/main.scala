package Ciphers

@main def main(): Unit = {
    import scala.io.StdIn.readLine
    val data = Vector("hello", "lol", "hey", "the", "cat", "more", "i", "can", "would", "you", "me", "because", "he", "she", "how", "do", "please")
    val cipher = CeasarCipher(readLine, data)
    val krypterat = cipher.encryptRandom()
    println(krypterat)
    println(cipher.decrypt())

}