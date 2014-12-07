package shared;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection {

	private Socket clientSocket;
	private DataOutputStream outToServer;

	public void connect() {
		try {
			clientSocket = new Socket("localhost", 8888);
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String gsonString) {
		
		connect();

		byte[] encrypted = encryption(gsonString);
		try {
			outToServer.write(encrypted);
			outToServer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String recieve() {
		BufferedReader inFromServer = null;
		try {
			inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
		String modifiedSentence = null;
		String decrypted = null;

		try {
			modifiedSentence = inFromServer.readLine();
			System.out.println("encrypted from server" + modifiedSentence);
			decrypted = crypt(modifiedSentence.getBytes());
			System.out.println("decrypted" + decrypted);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return decrypted;
	}

	public byte[] encryption(String gsonString) {
		byte[] input = gsonString.getBytes();
		byte key = (byte) 3.014;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);
		return encrypted;
	}
	
	public String crypt(byte[] b)
	{
//		Defines the decryption value of the byte
		String crypKey = "3.014";
		double keyAsDouble = Double.parseDouble(crypKey);
		byte ff = (byte) keyAsDouble;
//		Generates for loop containing decryption value
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
//		Generates new String without any white spaces following or leading
		String encrypted = new String(b).trim();
//		Returns decrypted String
		return encrypted;
	}

	
}
