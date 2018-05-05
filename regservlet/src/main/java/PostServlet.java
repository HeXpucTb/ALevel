import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import validators.EmailValidator;
import validators.NameValidator;
import validators.PasswordValidator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

@WebServlet(name = "PostServlet", urlPatterns = "/processuser")
public class PostServlet extends HttpServlet{
    private static class RequestUser {
        private final String name;
        private final String email;
        private final String password;
        private final String password2;
        private RequestUser(String name, String email, String password, String password2){
            this.name = name;
            this.email = email;
            this.password = password;
            this.password2 = password2;
        }

        public String getName() {
            return name;
        }

        public static RequestUser fromRequestParameters(HttpServletRequest request){
            return new RequestUser(
                    request.getParameter("name"),
                    request.getParameter("email"),
                    request.getParameter("password"),
                    request.getParameter("password2"));
        }
        public void setAsRequestAttributes(HttpServletRequest request){
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("password2", password2);
        }
        public List validate(){
            List<String> violations = new ArrayList<>();
            if(!NameValidator.validate(name)){
                violations.add("Имя обязательное поле");
            }
            if(!EmailValidator.validate(email)){
                violations.add("Мыло обязательно к заполнению");
            }
            if(!PasswordValidator.validate(password)){
                violations.add("Некорректный пасс");
            }
            if(!password.equals(password2)){
                violations.add("Некорректный повтор");
            }
            return violations;
        }
        public void addToJDBC() throws SQLException {

            String quer = "INSERT INTO users (name, email, password) VALUES ('"
                    +name+"','"+email+"','"+password+"');";
            DBHandler.initPost(quer);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException{
        RequestUser user = RequestUser.fromRequestParameters(request);
        user.setAsRequestAttributes(request);
        List violations = user.validate();
        if(violations.isEmpty()){
            try {
                user.addToJDBC();
            }catch (MySQLIntegrityConstraintViolationException e){
                resp.sendRedirect("/sign_page.jsp");
            }catch (SQLException e) {
                e.printStackTrace();
            }


            String quer = "SELECT id FROM users WHERE name='"+user.getName()+"';";
            Cookie userId = new Cookie("user_id", DBHandler.initGet(quer).get(0));
            resp.addCookie(userId);
            request.setAttribute("violations", violations);
            this.getServletContext().getRequestDispatcher(determineUrl(violations)).forward(request, resp);
        }
    }
    private String determineUrl(List violations){
        if(!violations.isEmpty()){
            return "/sign_page.jsp";
        }else {
            return "/WEB-INF/user_page.jsp";
        }

    }
}
