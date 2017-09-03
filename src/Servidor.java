import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	
	private ServerSocket servidor;
	private Socket cliente;
	private final short PORT = 12346;
	private short clientCount = 0;
	private PrintStream chat;
	
	
	
	
	public Servidor() {
		try {
			servidor = new ServerSocket(PORT);
			
			System.out.println("Servidor inicializado. Porta "+PORT+" aberta!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void start() {
        try {
            

            while(true) {

            	//Thread fica esperando nova conexao de cliente.
                Socket cliente = servidor.accept();
                //Novo cliente se conecta
                clientCount++;
                //Handle criado
                TratamentoThread tratamentoThread = new TratamentoThread(cliente);
                
                //log 
                System.out.println("Jogador "+ clientCount+" conectado. Endereco: " + cliente.getInetAddress().getHostAddress());
                
                //mensagem de boas vindas para cliente
                chat = new PrintStream(cliente.getOutputStream());
                chat.println("Bem vindo! Voce e o jogador numero: "+clientCount+"\n");
                
                //starta thread.
                Thread thread = new Thread(tratamentoThread);
                thread.start();
            }
        }catch(Exception e){

            System.out.println("exception: " + e);

        }
        finally {
        	try {
				cliente.close();
				servidor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
    public static void main (String[] args){
    	Servidor server = new Servidor();
    	server.start();

    }
}
