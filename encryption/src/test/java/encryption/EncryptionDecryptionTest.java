package encryption;

public class EncryptionDecryptionTest {

	public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	String plaintext="java is object oriented programming";
	System.out.println("plaintext: "+plaintext);
	String encryptiontext=	EncryptionDecryption.encrypt(plaintext);
	System.out.println("encryptedtext: "+encryptiontext);
	String decryptiontext= EncryptionDecryption.decrypt(encryptiontext);
	System.out.println("decryptedtext: "+decryptiontext);

	}
}
