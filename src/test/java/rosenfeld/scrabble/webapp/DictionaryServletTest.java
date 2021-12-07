package rosenfeld.scrabble.webapp;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class DictionaryServletTest {

    @Test
    public void valid_doGet() throws IOException {

        // given
        DictionaryServlet servlet = new DictionaryServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        String expectedDefinition = "a trodden way or track [n -S]";

        doReturn(out).when(response).getWriter();
        doReturn("PATH").when(request).getParameter("inputWord");

        // when
        servlet.doGet(request, response);

        // then
        verify(out).println(expectedDefinition);
    }

    public void invalid_doGet() throws IOException {

        // given
        DictionaryServlet servlet = new DictionaryServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        String expectedDefinition = "Invalid word";

        doReturn(out).when(response).getWriter();
        doReturn("LKSJFOIE").when(request).getParameter("inputWord");

        // when
        servlet.doGet(request, response);

        // then
        verify(out).println(expectedDefinition);
    }
}
