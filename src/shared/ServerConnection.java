package shared;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection {

	private Socket clientSocket;
	private DataOutputStream outToServer;

	public void Connect() {
		try {
			clientSocket = new Socket("localhost", 8888);
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Send(String gsonString) {
		
		Connect();

		byte[] encrypted = Encryption(gsonString);
		try {
			
			System.out.println(encrypted);
			outToServer.write(encrypted);
			outToServer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String Recieve() {
		BufferedReader inFromServer = null;
		try {
			inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
		String modifiedSentence = null;

		try {
			modifiedSentence = inFromServer.readLine();
			System.out.println(modifiedSentence);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modifiedSentence;
	}

	public byte[] Encryption(String gsonString) {
		byte[] input = gsonString.getBytes();
		byte key = (byte) 3.014;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);
		return encrypted;
	}
}
