package socket.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.SortedSet;
import java.util.TreeSet;

public class SocketFlotsClient {

    public static void main(String[] args) {

        try (Socket socket = new Socket(InetAddress.getLocalHost(), 5000)) {
// ouverture d'une connexion TCP
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
// envoi vers le serveur de cette «requête»
            SortedSet<String> l = new TreeSet<String>();
            l.add("TCP");
            l.add("essai");
            oos.writeObject(l);
// lecture de la réponse retournée
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("le serveur retourne : " + ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
