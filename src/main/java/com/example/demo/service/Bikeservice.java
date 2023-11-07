package com.example.demo.service;

import com.example.demo.model.Bike;
import com.example.demo.repository.BikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class Bikeservice {
    private BikeRepository bikeRepository;
    public void saveCustomersToDatabase(MultipartFile file){
        if(Exceluplod.isValidExcelFile(file)){
            try {
                List<Bike> customers = Exceluplod.getCustomersDataFromExcel(file.getInputStream());
                this.bikeRepository.saveAll(customers);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public List<Bike> getCustomers(){
        return bikeRepository.findAll();
    }
}
