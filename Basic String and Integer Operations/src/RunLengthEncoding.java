/*
 * Encodes with length encoding.
 */
public class RunLengthEncoding {
		
	/*
	 * Encodes a string by shortening repetitions.
	 * @param message string to be encoded
	 * @param delimiter stop gap between encodings
	 * @return the encoded text
	 */
	public static String encode(String message, char delimiter) {
		String encoded = "";
		for(int i = 0; i < message.length(); i++) {
			String queue = "";
			int hitCount = 0;
			char current = message.charAt(i);
			if (message.charAt(i) != message.charAt(i+1)) queue += message.charAt(i);
			else {
				while(i+1 < message.length() && message.charAt(i) == message.charAt(i+1)) {
					queue += message.charAt(i);
					hitCount++;
					i++;
				}
				queue += current;
				hitCount++;	
			}
			if (hitCount>3) encoded = encoded + delimiter + message.charAt(i) + hitCount;
			else encoded += queue;
		}
		return encoded;
	}	
}
