public class VigenereCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String key;

    public VigenereCipher(String key) {
        this.key = key;
    }

    private char shiftChar(char c, int shift, boolean encrypt) {
        if (!Character.isLetter(c)) return c;

        int position = ALPHABET.indexOf(Character.toUpperCase(c));
        if (position == -1) return c;

        int newPosition;
        if (encrypt) {
            newPosition = (position + shift) % ALPHABET.length();
        } else {
            newPosition = (position - shift + ALPHABET.length()) % ALPHABET.length();
        }

        char shiftedChar = ALPHABET.charAt(newPosition);
        return Character.isUpperCase(c) ? shiftedChar : Character.toLowerCase(shiftedChar);
    }

    public String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int keyPosition = ALPHABET.indexOf(Character.toUpperCase(key.charAt(i % key.length())));
            encryptedText.append(shiftChar(text.charAt(i), keyPosition, true));
        }
        return encryptedText.toString();
    }

    public String decrypt(String text) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int keyPosition = ALPHABET.indexOf(Character.toUpperCase(key.charAt(i % key.length())));
            decryptedText.append(shiftChar(text.charAt(i), keyPosition, false));
        }
        return decryptedText.toString();
    }
}
