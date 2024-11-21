package com.example.bfhl.model;

import lombok.Data;

@Data
public class FileResponse {
    private boolean fileValid;
    private String mimeType;
    private double fileSizeKB;
}
