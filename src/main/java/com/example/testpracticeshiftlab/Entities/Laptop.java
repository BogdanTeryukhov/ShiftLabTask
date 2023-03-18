package com.example.testpracticeshiftlab.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String serialVersionID;
    private String producer;
    private int price;
    private int amount;

    @Range(min = 13, max = 19, message = "Should be 13, 15, 17 or 19")
    private int laptopsSize;

    @Override
    public String toString() {
        return "Laptop{" +
                "serialVersionID='" + serialVersionID + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", LaptopsSize=" + laptopsSize +
                '}';
    }
}
