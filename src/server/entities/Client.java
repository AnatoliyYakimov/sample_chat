package server.entities;

import server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements AutoCloseable {
    String login;
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.inputStream = new ObjectInputStream(socket.getInputStream());
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());

    }

    public Client(String login, Socket socket) throws IOException {
        this(socket);
        this.login = login;

    }

    public void close() {
        if (socket != null && !socket.isClosed()) {
            try {
                Server.getUserList().deleteUser(this.login);
                socket.close();
            } catch (IOException e) {
                System.err.println("Error while closing Connetion");
            }
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    void setOutputStream(ObjectOutputStream oos){
        outputStream = oos;
    }
    void setInutStream(ObjectInputStream ois){
        inputStream = ois;
    }
    public ObjectInputStream getInputStream() {
        return inputStream;
    }
    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }
    public Socket getSocket() {
        return socket;
    }
}
