package com.example.demo.controller;

import com.example.demo.model.Bike;
import com.example.demo.service.Bikeservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/bikes")
public class BikeController {
    private Bikeservice bikeservice;
    @PostMapping("/upload-customers-data")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file") MultipartFile file){
        this.bikeservice.saveCustomersToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message" , " Customers data uploaded and saved to database successfully"));
    }

    @GetMapping
    public ResponseEntity<List<Bike>> getCustomers(){
        return new ResponseEntity<>(bikeservice.getCustomers(), HttpStatus.FOUND);
    }

}
