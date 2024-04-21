import java.io.*;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JSONvalidate {
    public static void main(String[] args) {
        String filePath = "src/resources/sample.json";
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject policyDocument = (JSONObject) jsonObject.get("PolicyDocument");
        JSONArray statements = (JSONArray) policyDocument.get("Statement");
        for (Object statement : statements) {
            JSONObject statementObj = (JSONObject) statement;
            String resource = (String) statementObj.get("Resource");
            System.out.println(containsSingleAsterisk(resource));
        }
    }

    private static boolean containsSingleAsterisk(String resource) {
        return !Objects.equals(resource, "*");
    }
}


