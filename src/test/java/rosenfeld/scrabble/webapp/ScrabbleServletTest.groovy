import org.junit.Test

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.*

class ScrabbleServletTest {

    @Test
    public void doGet() throws IOException {

        // given
        DicationaryServlet servlet = new DictionaryServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);

        doReturn(out).when(response).getWriter();
        doReturn("PATH").when(request).getParameter("inputWord");

        // when
        servlet.doGet(request, response);

        // then
        verify(out).println("a trodden way or track [n -S]");
    }
}