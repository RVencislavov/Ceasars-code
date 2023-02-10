import java.util.Scanner;

public class CaesarsCode {
    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Crypt");
        System.out.println("2. Decrypt");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        System.out.print("Enter the key: ");
        int key = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter the message: ");
        String message = scan.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Encrypted message: " + crypt(message, key));
                break;
            case 2:
                System.out.println("Decrypted message: " + decrypt(message, key));
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

        static String crypt (String message,int key){
            message = message.toUpperCase();
            String result = "";
            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                int index = ALPHABET.indexOf(c);
                if (index != -1) {
                    result += ALPHABET.charAt((index + key) % ALPHABET.length());
                } else {
                    result += c;
                }
            }
            return result;
        }

        static String decrypt (String message,int key){
            message = message.toUpperCase();
            String result = "";
            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                int index = ALPHABET.indexOf(c);
                if (index != -1) {
                    int newIndex = (index - key + ALPHABET.length()) % ALPHABET.length();
                    result += ALPHABET.charAt(newIndex);
                } else {
                    result += c;
                }
            }
            return result;
        }
    }

