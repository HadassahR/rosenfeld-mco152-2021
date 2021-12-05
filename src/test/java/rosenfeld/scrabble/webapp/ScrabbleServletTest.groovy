import org.junit.Test
import rosenfeld.scrabble.webapp.DictionaryServlet

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static org.mockito.Mockito.*

class ScrabbleServletTest {

    @Test
    public void doGet() throws IOException {

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
}