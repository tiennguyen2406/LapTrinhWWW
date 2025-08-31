package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet(name = "fileUploadServlet", urlPatterns = {"/file-upload"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class UploadServlet extends HttpServlet {
    private String uploadPathToSource;
    private String uploadPathToTarget;

    @Override
    public void init() throws ServletException {
        // Tạo đường dẫn tới thư mục /src/main/webapp/uploads
        String userDir = System.getProperty("user.dir");
        if (userDir.contains("tomcat") && userDir.endsWith("bin")) {
            userDir = new File(userDir).getParent();
            userDir = new File(userDir).getParent();
        }
        uploadPathToSource = userDir + "/ThucHanhWWW/src/main/webapp/uploads";
        File sourceDir = new File(uploadPathToSource);
        if (!sourceDir.exists()) {
            sourceDir.mkdirs();
        }

        uploadPathToTarget = "T:\\LapTrinhWWW\\Tuan02\\ThucHanhWWW\\src\\main\\webapp\\uploads";

        File targetDir = new File(uploadPathToTarget);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part part : req.getParts()) {
            if (part.getName().equals("file")) {  // Tên input file
                String fileName = part.getSubmittedFileName();
                if (fileName == null || fileName.isEmpty()) continue;

                try (InputStream input1 = part.getInputStream();
                     InputStream input2 = part.getInputStream()) {

                    Files.copy(input1, Paths.get(uploadPathToSource, fileName), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(input2, Paths.get(uploadPathToTarget, fileName), StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("Uploaded: " + fileName);
                }
            }
        }

        resp.setContentType("text/html");
        resp.getWriter().println("<h3>Upload successful!</h3>");
    }
}
