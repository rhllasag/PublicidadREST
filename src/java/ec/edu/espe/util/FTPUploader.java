/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Vicho
 */
public class FTPUploader {
        FTPClient ftp = null;
        String host = "52.34.202.157";
        String user = "hitchus";
        String pwd = "hitchus";
        Integer max = 4096;
     
    public FTPUploader() throws Exception{
        ftp = new FTPClient();
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(host);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(user, pwd);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
    }
    public String uploadFile(File f, String fileName, String hostDir)
            throws Exception {
        try(InputStream input = new FileInputStream(f)){
        this.ftp.storeFile(hostDir + fileName, input);
        }
        return hostDir + fileName;
    }
    
    public boolean removeFile(String file) throws IOException{    
    return ftp.deleteFile(file);
    }
    
    public byte[] downloadFile(String path) throws Exception {      
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();        
        InputStream is = ftp.retrieveFileStream(path);     
        return IOUtils.toByteArray(is);
    }    
  

    public byte[] toBytes(File file){
        byte[] b = new byte[(int) file.length()];
         try {
            b = FileUtils.readFileToByteArray(file);
          } catch (FileNotFoundException e) {
                      System.out.println("File Not Found.");
                      e.printStackTrace();
          }
          catch (IOException e1) {
                   System.out.println("Error Reading The File.");
                    e1.printStackTrace();
          }  
         return b;
    }
    
    public File toFile(String nombre, byte[] b){
        File f = new File(nombre);        
            try {
                FileUtils.writeByteArrayToFile(f, b);
           }
          catch(FileNotFoundException ex)   {
                 System.out.println("FileNotFoundException : " + ex);
          }
         catch(IOException ioe)  {
                 System.out.println("IOException : " + ioe);
          }  
            return f;
    }
 
    public void disconnect(){
        if (this.ftp.isConnected()) {
            try {
                this.ftp.logout();
                this.ftp.disconnect();
            } catch (IOException f) {
                // do nothing as file is already saved to server
            }
        }
    }

    public byte[] toArray(ArrayList<Byte> content) {
        byte[] arr = new byte[content.size()];
        for (int i = 0; i < content.size(); i++) {
            arr[i]=content.get(i);
        }
        return arr;
    }
}
