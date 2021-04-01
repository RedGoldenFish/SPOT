package utilities.communication.communication_handler;

import java.util.ArrayList;
import java.util.HashMap;

import utilities.communication.CommunicatorAdress;
import utilities.communication.Message;
import utilities.encryption.EncryptionKey;
import utilities.encryption.Signature;

public class Provider {

	private HashMap<CommunicatorAdress, ArrayList<Message>> _mPendingMessages;
	
	private HashMap<CommunicatorAdress, EncryptionKey> _mPublicSignatureKeys;
	
	private HashMap<CommunicatorAdress, EncryptionKey> _mPublicEncryptionKeys;
	
	public void sendMessage(CommunicatorAdress device, Message message) {
		if(_mPendingMessages.containsKey(device)) {
			_mPendingMessages.get(device).add(message);
		}
		else {
			ArrayList<Message> newMessage = new ArrayList<Message>();
			newMessage.add(message);
			_mPendingMessages.put(device, newMessage);
		}
	}

	public ArrayList<Message> fetchMessages(CommunicatorAdress device, Message verifMessage) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
