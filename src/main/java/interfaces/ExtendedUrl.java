package interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtendedUrl implements Url{
    @Override
    public String getParam(String name, String url) {
        Pattern pattern = Pattern.compile(name + "\\.([^\\/]+)");
        Matcher m = pattern.matcher(url);

        if (m.find()) {
            return m.group(1);
        }
        return "";
    }
}
