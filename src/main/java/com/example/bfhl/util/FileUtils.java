package com.example.bfhl.util;

import com.example.bfhl.model.FileResponse;

import java.util.Base64;

public class FileUtils {

    public static FileResponse processFile(String base64String) {
        FileResponse response = new FileResponse();

        if (base64String == null || base64String.isEmpty()) {
            response.setFileValid(false);
            return response;
        }

        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            response.setFileValid(true);
            response.setMimeType("application/octet-stream"); // Placeholder for MIME type
            response.setFileSizeKB(decodedBytes.length / 1024.0);
        } catch (IllegalArgumentException e) {
            response.setFileValid(false);
        }

        return response;
    }
}
