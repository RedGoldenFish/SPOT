package utilities.communication;

import utilities.encryption.Signature;

public class Message {
	
	//TODO Do they really have to be public ?
	public byte[] _message;
	public Signature _signature;
	public CommunicatorAdress _senderAdress;


}
