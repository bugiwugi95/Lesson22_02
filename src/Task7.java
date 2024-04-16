import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task7 {
    public static void main(String[] args) throws IOException {
        //7.Сохраняйте снимки NASA с1 января того момента, пока в поле Explanation нет слова “Earth”.

        int month = 1;
        int day = 1;
        int current = 0;
        for (int i = month; i < 12; i++) {
            for (int j = day; j < 31; j++) {
                String strMonth = i < 10 ? "0" + i : String.valueOf(i);
                String strDay = j < 10 ? "0" + j : String.valueOf(j);
                String httpsApiNasa = "https://api.nasa.gov/planetary/apod?";
                String apiKey = "api_key=UWdG6RWeGaiYfvP8gypQbeoHaYcNTQLhXNo4AY2e";
                String dateStart = "&start_date=2024-" + strMonth + "-" + strDay;
                String dateEnd = "&end_date=2024-" + strMonth + "-" + strDay;
                String str = httpsApiNasa + apiKey + dateStart + dateEnd;
                String strPage = downloadWebPage(str);
                int urlStartExplanation = strPage.lastIndexOf("explanation");
                int urlEndExplanation = strPage.lastIndexOf("hdurl");
                if (urlStartExplanation < urlEndExplanation) {
                    String exp = strPage.substring(urlStartExplanation + 14, urlEndExplanation - 3);
                    current++;
                    if (exp.equals("Earth")) {
                        System.out.println("Найдено слово" + current);
                        break;
                    } else {
                        int urlStart = strPage.lastIndexOf("url");
                        int urlEnd = strPage.lastIndexOf("}");
                        String urlImage = strPage.substring(urlStart + 6, urlEnd - 1);
                        try (InputStream in = new URL(urlImage).openStream()) {
                            Files.copy(in, Paths.get("nasa.jpg" + current));
                        }

                        System.out.println("Файлы сохранены!" + current);
                    }
                }

            }
        }


    }


    private static String downloadWebPage(String url) throws IOException {

        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();


        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }

        return result.toString();

    }
}