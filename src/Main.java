public class Main {
    public static void main(String[] args) {
        VigenereCipher cipher = new VigenereCipher("FALSE");

        String message = "Sebastian Pereira, seller of dark wood!";
        String encryptedMessage = cipher.encrypt(message);
        String decryptedMessage = cipher.decrypt(encryptedMessage);

        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
