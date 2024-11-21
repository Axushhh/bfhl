package com.example.bfhl.service;

import com.example.bfhl.model.BFHLRequest;
import com.example.bfhl.model.BFHLResponse;
import com.example.bfhl.model.FileResponse;
import com.example.bfhl.util.FileUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BFHLService {

    public BFHLResponse processRequest(BFHLRequest request) {
        BFHLResponse response = new BFHLResponse();
        response.setUserId("john_doe_17091999");
        response.setEmail("john@xyz.com");
        response.setRollNumber("ABCD123");

        // Separating the numbers and alphabets
        List<String> numbers = request.getData().stream()
                .filter(s -> s.matches("\\d+"))
                .collect(Collectors.toList());
        List<String> alphabets = request.getData().stream()
                .filter(s -> s.matches("[a-zA-Z]"))
                .collect(Collectors.toList());
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);

        // Get the highest lowercase alphabet
        Optional<String> highestLowercase = alphabets.stream()
                .filter(s -> s.matches("[a-z]"))
                .max(Comparator.naturalOrder());
        response.setHighestLowercaseAlphabet(highestLowercase.map(Collections::singletonList).orElse(Collections.emptyList()));

        // Check for prime numbers
        boolean isPrimeFound = numbers.stream().anyMatch(this::isPrime);
        response.setPrimeFound(isPrimeFound);

        // File processing
        FileResponse fileResponse = FileUtils.processFile(request.getFile_b64());
        response.setFileResponse(fileResponse);

        response.setSuccess(true);
        return response;
    }

    private boolean isPrime(String numberStr) {
        int num = Integer.parseInt(numberStr);
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
