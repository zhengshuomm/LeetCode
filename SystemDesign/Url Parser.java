/*
 3 - Web Crawler & Google Suggestion

 Url Parser



Given the following html page:

<html>
  <body>
    <div>
      <a href="http://www.google.com" class="text-lg">Google</a>
      <a href="http://www.facebook.com" style="display:none">Facebook</a>
    </div>
    <div>
      <a href="https://www.linkedin.com">Linkedin</a>
      <a href = "http://github.io">LintCode</a>
    </div>
  </body>
</html>
You should return the Urls in it:

[
  "http://www.google.com",
  "http://www.facebook.com",
  "https://www.linkedin.com",
  "http://github.io"
]
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HtmlParser {
    /**
     * @param content source code
     * @return a list of links
     */
    private static final String HREF_PATTERN = "href\\s*=\\s*([\"']?)([^\"'>\\s]*)\\1";
    
    public List<String> parseUrls(String content) {
        // Write your code here
        List<String> links= new ArrayList<String>();
        Pattern pattern = Pattern.compile(HREF_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            String url = matcher.group(2);
            if(url.length() == 0 || url.startsWith("#"))
                continue;
            links.add(url);
        }
        
        return links;
    }
}
