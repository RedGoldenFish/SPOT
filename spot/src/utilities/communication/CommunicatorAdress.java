package utilities.communication;

import java.util.Objects;

public class CommunicatorAdress {
	String _sId;

	@Override
	public int hashCode() {
		return Objects.hash(_sId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CommunicatorAdress)) {
			return false;
		}
		CommunicatorAdress other = (CommunicatorAdress) obj;
		return Objects.equals(_sId, other._sId);
	}
	
}
