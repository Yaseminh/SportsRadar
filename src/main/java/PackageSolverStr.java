import Entity.FileParser;
import java.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PackageSolverStr {
    private static final Logger logger = LogManager.getLogger(PackageSolverStr.class);
    public static void main(String[] args) {
        String filePath = "src/main/resources/input.txt"; // your file location
        //Read File
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String fileContent;
            while ((fileContent = br.readLine()) != null) {
               // trim() is used to remove spaces from the beginning and end of a string.
                fileContent = fileContent.trim();
                if (!fileContent.isEmpty()) {
                    try {
                        String result = FileParser.solve(fileContent);
                        System.out.println(result);
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                }
            }
            // Write summary log after all process is finished
            logger.info("All input lines processed successfully.");
        } catch (Exception e) {
            logger.error("Error reading file '{}': {}", filePath, e.getMessage());
        }
    }
}
