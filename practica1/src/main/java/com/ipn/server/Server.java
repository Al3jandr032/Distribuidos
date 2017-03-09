package com.ipn.server;

import com.ipn.support.AlumnoImpl;
import com.ipn.support.AsignacionImpl;
import com.ipn.support.CursoImpl;
import com.ipn.vo.Alumno;
import com.ipn.vo.Asignacion;
import com.ipn.vo.Curso;
import com.ipn.vo.CursoAlumno;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 
/**
 *
 * @author Alex
 */
public class Server extends Thread {

    public static final int PORT = 6666;
    public static final int INIT = 0;
    public static final int ALUMNO = 1;
    public static final int CURSO = 2;
    public static final int ASIGNACION = 3;
    public static final int CREATE = 4;
    public static final int UPDATE = 5;
    public static final int FIND = 6;
    public static final int REMOVE = 7;
    public static final int FIND_ALL = 8;
    public static final int FIND_ALL_CUSTOM = 9;
    private ServerSocket socket;
    protected ObjectInputStream entrada;
    protected ObjectOutputStream salida;
    private AlumnoImpl daoAlumno;
    private AsignacionImpl daoAsignacion;
    private CursoImpl daocurso;
    private Socket client = null;

    public Server() {
        try {
            Properties p = new Properties();
            p.setProperty("connection", "jdbc:mysql://maquinavirtual/practica1");
            p.setProperty("user", "debian");
            p.setProperty("pass", "debianpass");
            daoAlumno = new AlumnoImpl(p);
            daoAsignacion = new AsignacionImpl(p);
            daocurso = new CursoImpl(p);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
            System.out.println(ex.getCause());
        }
        try {
            this.socket = new ServerSocket(PORT);
            System.out.println("Funcionando");

            start();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
            System.out.println(ex.getCause());
//            ex.printStackTrace();
        }

    }

    public ServerSocket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                client = this.socket.accept();
                System.out.println("connecting " + client.getRemoteSocketAddress() + " ... ");
                entrada = new ObjectInputStream(client.getInputStream());
                salida = new ObjectOutputStream(client.getOutputStream());
                System.out.println("conection done " + client.getRemoteSocketAddress());
                int i = entrada.readInt();
                if (i == INIT) {
                    System.out.println("Init connection");
                } else {
                    System.out.println(i);
                    this.operation(i);
                }
//                salida.writeInt(1);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void operation(int type) throws IOException, ClassNotFoundException {
        int op = entrada.readInt();
        Object input = null;
        switch (op) {
            case CREATE:
                switch (type) {
                    case ALUMNO:
                        input = entrada.readObject();
                        Alumno alumno = (Alumno) input;
                        this.daoAlumno.create(alumno);
                        break;
                    case CURSO:
                        input = entrada.readObject();
                        Curso curso = (Curso) input;
                        this.daocurso.create(curso);
                        break;
                    case ASIGNACION:
                        input = entrada.readObject();
                        Asignacion asig = (Asignacion) input;
                        this.daoAsignacion.create(asig);
                        break;
                }
                break;
            case UPDATE:
                switch (type) {
                    case ALUMNO:
                        input = entrada.readObject();
                        Alumno alumno = (Alumno) input;
                        this.daoAlumno.update(alumno);
                        break;
                    case CURSO:
                        input = entrada.readObject();
                        Curso curso = (Curso) input;
                        this.daocurso.update(curso);
                        break;
                    case ASIGNACION:
                        input = entrada.readObject();
                        Asignacion asig = (Asignacion) input;
                        this.daoAsignacion.update(asig);
                        break;
                }
                break;
            case REMOVE:
                switch (type) {
                    case ALUMNO:
                        input = entrada.readObject();
                        Alumno alumno = (Alumno) input;
                        this.daoAlumno.remove(alumno);
                        break;
                    case CURSO:
                        input = entrada.readObject();
                        Curso curso = (Curso) input;
                        this.daocurso.remove(curso);
                        break;
                    case ASIGNACION:
                        input = entrada.readObject();
                        Asignacion asig = (Asignacion) input;
                        this.daoAsignacion.remove(asig);
                        break;
                }
                break;
            case FIND:
                int id ;//= entrada.readInt();
                switch (type) {
                    case ALUMNO:
                        id = entrada.readInt();
                        Alumno alumno = this.daoAlumno.find(id);
                        salida.writeObject(alumno);
                        break;
                    case CURSO:
                        id = entrada.readInt();
                        Curso curso = this.daocurso.find(id);
                        salida.writeObject(curso);
                        break;
                    case ASIGNACION:
                        id = entrada.readInt();
                        int id_c = entrada.readInt();
                        Asignacion asig = this.daoAsignacion.find(id,id_c);
                        salida.writeObject(asig);
                        break;
                }
                break;
            case FIND_ALL:
                switch (type) {
                    case ALUMNO:
                        List<Alumno> aux = this.daoAlumno.findAll();
                        salida.writeInt(aux.size());
                        for (Alumno a : aux) {
                            salida.writeObject(a);
                        }
                        break;
                    case CURSO:
                        List<Curso> aux_curso = this.daocurso.findAll();
                        salida.writeInt(aux_curso.size());
                        for (Curso a : aux_curso) {
                            salida.writeObject(a);
                        }
                        break;
                    case ASIGNACION:
                        List<Asignacion> aux_asig = this.daoAsignacion.findAll();
                        salida.writeInt(aux_asig.size());
                        for (Asignacion a : aux_asig) {
                            salida.writeObject(a);
                        }
                        break;
                }
                break;
            case FIND_ALL_CUSTOM:
                List<CursoAlumno> aux_calumno = this.daoAsignacion.getListCursoAlumno();
                salida.writeInt(aux_calumno.size());
                for (CursoAlumno a : aux_calumno) {
                    salida.writeObject(a);
                }
                break;
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        
    }
}