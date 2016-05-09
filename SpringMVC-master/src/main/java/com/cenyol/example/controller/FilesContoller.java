package com.cenyol.example.controller;

import com.cenyol.example.Services.FilesService;
import com.cenyol.example.model.Files;
import com.cenyol.example.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by fours on 07.04.2016.
 */
@Controller
public class FilesContoller {

    private static final int BUFFER_SIZE = 4096;
    private String filePath = "Text.txt";
    private static final String INTERNAL_FILE="E://Text.txt";
    private static final String EXTERNAL_FILE_PATH="E://Text.txt";
    @Autowired
    private FilesRepository filesRepository;

    private FilesService filesService;

    @RequestMapping(value = "/filesList", method = RequestMethod.GET)
    public String filesList(ModelMap modelMap) {
        List<Files> listOfFile = filesRepository.getFiles();
        modelMap.addAttribute("filesList", listOfFile);
        return "filesList";
    }

    @RequestMapping(value = "fileShow/{Id}", method = RequestMethod.GET)
    public String showFile(@PathVariable("Id") Long Id, ModelMap modelMap) {
        Files files = filesRepository.findOne(Id);
        modelMap.addAttribute("file", files);
        return "fileDetail";
    }

    @RequestMapping(method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request,
                           HttpServletResponse response, String filepath) throws IOException {

        // get absolute path of the application
        ServletContext context = request.getSession().getServletContext();
        String appPath = context.getRealPath("");
        System.out.println("appPath = " + appPath);

        // construct the complete absolute path of the file
        String fullPath = appPath + filepath;
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        // get MIME type of the file
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // get output stream of the response
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();

    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileHandler(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + "1k.PNG");
                Files files = new Files();
                files.setName(serverFile.getName());
                files.setPathToFile(serverFile.getPath());
                files.setExt(serverFile.getAbsolutePath());
                files.setStatus("check");
                filesRepository.save(files);

                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();


                return "Success";
            } catch (Exception e) {
                return "Error";
            }
        } else {
            return "File is empty";
        }
    }




}
