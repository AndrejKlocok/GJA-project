package cz.vutbr.fit.bean.PrimeFaces;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.*;

import static com.mysql.cj.conf.PropertyKey.PATH;
/**
 * Managed bean for Files and imagespage
 *
 * @author  Andrej Klocok
 * @version 1.0
 * @since   2018-12-11
 */
@ManagedBean(name = "FileImagesBean")
public class File_ImagesBean {
    //files
    private UploadedFile uploadedFile;
    private StreamedContent downloadFile;

    /**
     * Post construct initialize download image from resources
     */
    @PostConstruct
    public void Load() {
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pictures/jayZ.jpg");
        downloadFile = new DefaultStreamedContent(stream, "image/jpg", "jayZ.jpg");
    }

    /**
     * Method hadnles image upload event and saves image to /tmp directory
     * @param event upload event
     */
    public void handleFileUpload(FileUploadEvent event) {
        uploadedFile = event.getFile();

        //if chosen file is null return
        if (uploadedFile == null) {
            return;
        }
        //create default faces message
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        //output directory for file
        String filePath = "/tmp/" + uploadedFile.getFileName();

        try {
            //save desired file to /tmp directory
            FileOutputStream out = new FileOutputStream(new File(filePath));
            out.write(uploadedFile.getContents());
            //flush content
            out.flush();
            //close file
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            msg = new FacesMessage("Failure", "File not found");

        } catch (IOException e) {
            e.printStackTrace();
            msg = new FacesMessage("Failure", "Error during write");
        }
        finally {
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    //Getters and setters
    public StreamedContent getDownloadFile() {
        return downloadFile;
    }

    public void setDownloadFile(StreamedContent downloadFile) {
        this.downloadFile = downloadFile;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
}
