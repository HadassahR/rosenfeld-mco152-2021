package rosenfeld.scrabble.webapp;
import rosenfeld.scrabble.DictionaryService;
import rosenfeld.scrabble.Dictionary;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DictionaryServlet extends HttpServlet {
    private final DictionaryService service;
    private final Dictionary dictionary;

    public DictionaryServlet() throws IOException {
        service = new DictionaryService();
        dictionary = service.getDictionary();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String word = request.getParameter("inputWord");
        String definition = dictionary.checkForWord(word) ? dictionary.getDefinition(word) : "Invalid word";
        out.println(definition);
    }
}
