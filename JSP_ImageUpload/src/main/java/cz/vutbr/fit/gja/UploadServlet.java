package cz.vutbr.fit.gja;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *  Servlet processing uploading image from form in index.jsp and redirecting back with error or to image.jsp where uploaded image will be shown.
 */
@WebServlet(name = "Upload", urlPatterns = {"/upload"})
public class UploadServlet extends HttpServlet
{
    /** Temporary directory path */
    private static final String TMP_DIR_PATH = System.getProperty("java.io.tmpdir");
    /** Destination directory path */
    public static final String DEST_DIR_PATH = ".";
    /** Temporary directory file */
    private File tmpDir;
    /** Destination directory file */
    private File destDir;

    /**
     * Called after construct servlet
     *
     * @param config Configuration of servlet
     * @throws ServletException When directories are missing
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext context = getServletContext();

        // Create File object for temporary and destination directories
        tmpDir = new File(TMP_DIR_PATH);
        destDir = new File(context.getRealPath(DEST_DIR_PATH)); // Convert relative path to absolute

        // Check if directories are really directories
        if (!tmpDir.isDirectory())
            throw new ServletException(TMP_DIR_PATH + " is not a directory!");
        if (!destDir.isDirectory())
            throw new ServletException(DEST_DIR_PATH + " is not a directory!");
    }

    /**
     * Redirects back to the form and show error messages
     *
     * @param request Request object
     * @param response Response object
     * @param errorString Error string which will be inserted to GET parameter and in the form error message will by shown
     *
     * @throws IOException By method sendRedirect of object HttpServletResponse
     */
    private void errorRedirect(HttpServletRequest request, HttpServletResponse response, String errorString) throws IOException {
        response.sendRedirect(request.getContextPath() + "/index.jsp?error=" + errorString);
    }

    /**
     * Redirects to page which show uploaded image
     *
     * @param request Request object
     * @param response Response object
     * @param imageFilename Filename of uploaded image
     *
     * @throws IOException By method sendRedirect of object HttpServletResponse
     */
    private void successRedirect(HttpServletRequest request, HttpServletResponse response, String imageFilename) throws IOException {
        response.sendRedirect(request.getContextPath() + "/image.jsp?filename=" + imageFilename);
    }

    /**
     * Called on HTTP method POST
     *
     * @param request Request object
     * @param response Response object
     *
     * @throws IOException By method sendRedirect of object HttpServletResponse
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        // Set file size limit to 1 MiB
        fileFactory.setSizeThreshold(1024 * 1024);
        // Set directory for store files which size is above than size limit
        fileFactory.setRepository(tmpDir);

        ServletFileUpload uploadHandler = new ServletFileUpload(fileFactory);

        try {
            // Get list of form items
            List<FileItem> items = uploadHandler.parseRequest(request);

            for (FileItem item : items) {
                // Skip form fields and files with different name (attribute name in tag input)
                if (item.isFormField() || !item.getFieldName().equals("image"))
                    continue;

                // Check if any file is uploading
                if (item.getName().isEmpty())
                    break; // Skip loop to error redirect

                // Check if file is image by MIME type
                if (!item.getContentType().startsWith("image/"))
                {
                    errorRedirect(request, response, "type");
                    return;
                }

                // Get filename of uploading file
                String filename = item.getName();

                // Create destination file
                File file = new File(destDir, filename);

                // Check if destination file already exists
                if (file.exists())
                {
                    errorRedirect(request, response, "exists");
                    return;
                }

                // Write file to destination directory
                item.write(file);

                // Redirect to uploaded image
                successRedirect(request, response, filename);
                return;
            }

            // File not found
            errorRedirect(request, response, "missing");
        }
        catch (Exception e) {
            errorRedirect(request, response, "failed");
        }
    }
}
