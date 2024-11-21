package com.example.bfhl.model;

import lombok.Data;
import java.util.List;


@Data
public class BFHLRequest {
    private List<String> data;
    private String file_b64;
}
