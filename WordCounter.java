import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = "";
        
        System.out.println("Do you want to enter text manually or provide a file path?");
        System.out.println("Enter 'text' for manual input or 'file' for file input:");
        String choice = scanner.nextLine().trim().toLowerCase();
        
        switch (choice) {
            case "text":
                System.out.println("Please enter your text:");
                inputText = scanner.nextLine();
                break;
            case "file":
                System.out.println("Please provide the file path:");
                String filePath = scanner.nextLine();
                try {
                    inputText = readFile(filePath);
                } catch (IOException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("Invalid choice. Please run the program again.");
                return;
        }
        
        int wordCount = countWords(inputText);
        System.out.println("Total word count: " + wordCount);
        
        scanner.close();
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append(" ");
            }
        }
        return contentBuilder.toString();
    }

    private static int countWords(String content) {
        if (content == null || content.isEmpty()) {
            return 0;
        }
        String[] words = content.trim().split("\\s+");
        return words.length;
    }
}
