package controllers;

import com.mysql.cj.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
//        File uploads = new File("../../");
        File uploads = new File("Desktop/");
//        System.out.println(System.getProperty("catalina.base"));
//        System.out.println(uploads.toPath());
//        System.out.println(fileContent);
//        System.out.println(fileName);
//        File file = new File(uploads, fileName);
//        Files.copy(fileContent, file.toPath());


//        Files.copy(fileContent, uploads.toPath());



//        File uploads = new File();




    }
}