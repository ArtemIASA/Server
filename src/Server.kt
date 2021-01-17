import java.io.DataInputStream
import java.io.OutputStream
import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.Charset
import java.time.Instant
import java.util.*


class Server(serverSocket: ServerSocket) {
    private val server: ServerSocket = serverSocket
    private val socket: Socket = server.accept()
    private val reader: Scanner = Scanner(socket.getInputStream())
    private val writer: OutputStream = socket.getOutputStream()

    fun send_time() {
        val t_server = Instant.now()
        writer.write((t_server.toString() + '\n').toByteArray(Charset.defaultCharset()))
    }

    fun run() {
        while(true) {
            if(reader.hasNextLine()){
                send_time()
            }
        }
    }

}