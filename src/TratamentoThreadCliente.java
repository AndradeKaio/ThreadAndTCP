import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TratamentoThreadCliente implements Runnable {

    private Socket socket;

    public TratamentoThreadCliente(Socket socket){

        this.socket = socket;

    }

    public void setSocket(Socket socket){

        this.socket = socket;

    }

    public Socket getSocket(Socket socket){

        return this.socket;
    }

    /**
     * executa o codigo do servidor para lidar com o cliente.
     * no caso, receber a mensagem do cliente conectado
     */

    public void run(){

        try {

            Scanner scanner = new Scanner(this.socket.getInputStream());

            while (scanner.hasNextLine()) {

                System.out.println(scanner.nextLine());

            }
        }catch(Exception e){

<<<<<<< HEAD:src/TratamentoThread.java
            System.out.println("Excecao na classe TratamentoThread: " + e);
=======
            System.out.println("Exceção na classe TratamentoThreadCliente: " + e);
>>>>>>> upstream/master:src/TratamentoThreadCliente.java
        }
        finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}
