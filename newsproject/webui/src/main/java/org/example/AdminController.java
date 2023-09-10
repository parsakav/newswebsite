package org.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize =
        1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)
@WebServlet(name = "AdminController", value = "/AdminController")
public class AdminController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "img";
private NewsService newsService=new NewsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("news");
        HttpSession session=request.getSession();
       User user= (User) session.getAttribute("loggedinuser");
        if (user!=null&&title != null && !title.isEmpty() && user.getRole_id()==1) {
            String uploadPath = getServletContext().getRealPath("")+ UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String fileName;
            for (Part part : request.getParts()) {
                if(part.getContentType()!=null) {
                    fileName = part.getSubmittedFileName();
                    String rpath = uploadPath + File.separator + fileName;
                    part.write(rpath);
                    newsService.addNews("img/"+fileName, title);
                }
            }


response.sendRedirect("index.jsp");
        }
    }
}
