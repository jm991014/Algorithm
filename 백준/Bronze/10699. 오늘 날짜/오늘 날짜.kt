import java.time.LocalDate

fun main() = with(System.out.bufferedWriter()) {
    write("${LocalDate.now()}")
    close()
}