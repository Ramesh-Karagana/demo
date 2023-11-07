package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bike")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bike {
    @Id
    int model_id;
    int make_id;
    String make_name;
    String model_name;
    String variance;
    int wheels;
    String oil;
    int cc;
    int seat;
    int driver;
    int vt_id;
    String vt_name;
}
