package com.example.bfhl.controller;

import com.example.bfhl.model.BFHLRequest;
import com.example.bfhl.model.BFHLResponse;
import com.example.bfhl.service.BFHLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class BFHLController {

    @Autowired
    private BFHLService bfhlService;

    @GetMapping
    public Object getOperationCode() {
        return new Object() {
            public final int operation_code = 1;
        };
    }

    @PostMapping
    public BFHLResponse handlePostRequest(@RequestBody BFHLRequest request) {
        return bfhlService.processRequest(request);
    }
}
