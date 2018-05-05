import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetServlet", urlPatterns = "/userpage")
public class GetServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if(cookies.length>0){
            String val = cookies[1].getValue();
            if(!(val.equals(""))){
                ArrayList<String> result = DBHandler.initGet("SELECT name, email FROM users WHERE id='"+val+"'");
                req.setAttribute("name", result.get(0));
                req.setAttribute("email",result.get(1));
                this.getServletContext().getRequestDispatcher("/WEB-INF/user_page.jsp").forward(req, resp);
            }else {
                resp.sendRedirect("/sign_page.jsp");
            }
        }else {
            resp.sendRedirect("/sign_page.jsp");
        }
    }
}