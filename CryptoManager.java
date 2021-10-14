package solution;



public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		
		// declare a boolean to determine if the is or not in the bounds of the ASCII
		// true being in the bounds and false not being in the bounds
		boolean boundary = true;
		
		//for loop until surpasses plaintext amount
		//
		for (int iteration = 0; iteration < plainText.length(); iteration++) {
		
			// if the plaintext characters are inbetween the lower and upper bounds than
			// boundary returns true
			//else it is false
			if (plainText.charAt(iteration) < LOWER_BOUND || plainText.charAt(iteration) > UPPER_BOUND) {
				
				
				boundary = false;
				
				
				
				
			}
		
			
		}
				
				
		
		return boundary;
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		
		String encryptedString = "";
		
		if(stringInBounds(plainText)) {
			
		
		
		for (int a = 0; a < plainText.length(); a++) {
			
			char c = plainText.charAt(a);
			
			int encryptedChar = ((int)c+key);
			
			while(encryptedChar > UPPER_BOUND) {
				
				encryptedChar -= RANGE;
			}
			
			
			encryptedString +=(char)encryptedChar;
			
			
		}
		
		}
	
		return encryptedString;
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		int bellasoLength = bellasoStr.length();
		String encryptedText = "";
		
		
		for (int i = 0; i < plainText.length(); i++) {
			
			char c = plainText.charAt(i);
			
			
			
			int encryptedChar = ((int)c+(int)bellasoStr.charAt(i%bellasoLength));
			
			
			while (encryptedChar > (int)UPPER_BOUND) {
				
				encryptedChar -= RANGE;
				
			}
			
			encryptedText += (char)encryptedChar;
			
			
		}
		
		
		return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		
		String decryptedString = "";
		
		for (int iteration = 0; iteration < encryptedText.length(); iteration++) {
			
			char c = encryptedText.charAt(iteration);
			int decryptedChar = ((int) c-key);
			
			
			while (decryptedChar < LOWER_BOUND) {
				
				decryptedChar += RANGE;
				
			}
			
			decryptedString += (char)decryptedChar;
			
		}
		
		return decryptedString;
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		String decryptedText = "";
		
		int bellasoLength = bellasoStr.length();
		
		for (int iteration = 0; iteration < encryptedText.length(); iteration++) {
		
			char c = encryptedText.charAt(iteration);
			int decryptedChar = ((int)c-(int)bellasoStr.charAt(iteration%bellasoLength));
		while(decryptedChar < (int)LOWER_BOUND) {
			
			decryptedChar += RANGE;
		}
			
		decryptedText += (char)decryptedChar;
		
		
	}
	
	return decryptedText;
	}
}
	
