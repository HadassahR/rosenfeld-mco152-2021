package rosenfeld.scrabble.webapp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rosenfeld.scrabble.Scrabble;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class DictionaryServlet extends HttpServlet {
    private final Gson gson;
    private final Map<String, String> dictionary;
    private final Scrabble scrabble;

    public DictionaryServlet() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        scrabble = new Scrabble();
        dictionary = scrabble.getWordsToDefinitions();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String word = request.getParameter("inputWord");
        String definition = scrabble.getDefinition(word);

        out.println(definition);
    }
}
