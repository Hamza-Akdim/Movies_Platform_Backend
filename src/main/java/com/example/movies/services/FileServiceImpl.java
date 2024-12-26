package com.example.movies.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileServiceImpl implements FileService{
    //UPLOAD A FILE
    @Override
    public String uploadFile(String path_dest, MultipartFile file) throws IOException {  //IOException :  If there is an error during the file Input/Output operations.
        //Get name of the file
        String fileName = file.getOriginalFilename();

        //Set the file path
        String filePath = path_dest + File.pathSeparator + fileName;

        //Test if the directory of the path_dest exist or not.
        File f = new File(path_dest);  //create file or directory object. In this context "f" is a directory which we test if it exists or not.
        if (!f.exists()) {
            f.mkdir(); //create directory
        }

        //copy the file(upload file) to the path
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING); //store the file; specifically its stream (byte array of the file); into the filePath. "StandardCopyOption.REPLACE_EXISTING" serves that if the user upload a file which its name already exist, in this case the old file that got the same name will be replaced with the new one

        return fileName;
    }

    //DOWLOAD A FILE
    @Override
    public InputStream getResourcesFile(String path_dest, String fileName) throws FileNotFoundException {
        String filePath = path_dest + File.separator + fileName;

        return new FileInputStream(filePath); //return the object that contains the byte array of the file
    }
}
