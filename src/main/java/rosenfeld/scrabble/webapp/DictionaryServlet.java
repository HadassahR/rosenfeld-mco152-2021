package rosenfeld.scrabble.webapp;
import rosenfeld.scrabble.DictionaryService;
import rosenfeld.scrabble.Scrabble;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DictionaryServlet extends HttpServlet {
    private final DictionaryService service;
    private final Scrabble scrabble;

    public DictionaryServlet() throws IOException {
        service = new DictionaryService();
        scrabble = new Scrabble();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String word = request.getParameter("inputWord");
        String definition = service.getDefinition(word);

        out.println(definition);
    }
}
