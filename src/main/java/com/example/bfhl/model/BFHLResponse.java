package com.example.bfhl.model;

import lombok.Data;
import java.util.List;

@Data
public class BFHLResponse {
    private boolean isSuccess;
    private String userId;
    private String email;
    private String rollNumber;
    private List<String> numbers;
    private List<String> alphabets;
    private List<String> highestLowercaseAlphabet;
    private boolean isPrimeFound;
    private FileResponse fileResponse;
}
