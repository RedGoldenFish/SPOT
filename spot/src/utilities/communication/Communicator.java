package utilities.communication;

import java.util.ArrayList;

import utilities.communication.communication_handler.Provider;
import utilities.encryption.Signature;


public class Communicator {
		
	public CommunicatorAdress _adress;
	
	private Provider _provider;
	
	protected void sendMessage(CommunicatorAdress device, Message message) {
		_provider.sendMessage(device, message);
	}
	
	protected ArrayList<Message> fetchMessages() {
		Message verifMessage = new Message();
		return _provider.fetchMessages(_adress, verifMessage);
	}
}
