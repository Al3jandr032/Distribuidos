package com.ipn.client;


import com.ipn.server.Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
 
/**
 *
 * @author aletz
 */
public class Client {
 
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("127.0.0.1", Server.PORT)) {
            ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            int result = -1;
            try {
//                dos.writeInt(Server.INIT);
//                dos.flush();
//                Thread.sleep(1000);
                dos.writeInt(Server.ALUMNO);
                dos.writeInt(Server.FIND_ALL);
                dos.flush();
                int index = is.readInt();
                ArrayList<Object> lst = new ArrayList();
                for (int i = 0; i < index; i++) {
                    Object o = is.readObject();
                    lst.add(o);
                }
                
                for (int i = 0; i < index; i++) {
                    System.out.println(lst.get(i));
                }
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.getClass());
                System.out.println(ex.getCause());
//                ex.printStackTrace();
            }
            dos.close();
        }
    }

}
