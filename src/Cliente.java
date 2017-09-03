import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	
	private Socket client;
	
	
	public void connect(String address, short port) {
		try {
			client = new Socket(address, port);
			System.out.println("Cliente conectado no servidor na porta "+ port);
			
			
			
	        Scanner entrada = new Scanner(client.getInputStream());

	        while(entrada.hasNextLine()){

	            System.out.println(entrada.nextLine());

	        }

	        client.close();
	        entrada.close();
	        
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
    public static void main(String[] args)throws UnknownHostException, IOException {

        
    	
    	
    	Cliente cliente = new Cliente();
    	cliente.connect("127.0.0.1", (short) 12346);
    	
    	

        
    }
}
