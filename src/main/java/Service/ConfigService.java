package Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public static String getIndex(){
        return parserConfig("VISIT_RESULT");
    }

    public static String getSourceFileName(){
        return parserConfig("SOURCE_FILE_NAME");
    }

    private static String parserConfig(String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        String value = null;
        try {
            File file = new File("src/main/resources/config.json");
            JsonNode jsonNode = objectMapper.readTree(file);
            value = jsonNode.get(key).asText();
        } catch (IOException e) {
            System.out.println(e);
        }
        return value;
    }

    public static void imageComparison(){

        //load images to be compared:
        String sourcePath = "src/main/resources/" + ConfigService.getSourceFileName();
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources(sourcePath);
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("src/main/resources/screenshot.png");

        ImageComparison imageComparison = new ImageComparison(actualImage, expectedImage);
        ImageComparisonResult result = imageComparison.compareImages();
        float similarityPercentage = 100 - result.getDifferencePercent();
        System.out.println("Calculating the similarity by 3rd party lib: image-comparison...");
        System.out.println("The similarity percentage is: " + similarityPercentage + "%");

    }

}

