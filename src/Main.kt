import java.net.ServerSocket

fun main() {
    val serverSocket = ServerSocket(5050)
    val server = Server(serverSocket)
    server.run()
}