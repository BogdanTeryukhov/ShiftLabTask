package com.example.testpracticeshiftlab.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String serialVersionID;
    private String producer;
    private int price;
    private int amount;

    private String formFactor;

    @Override
    public String toString() {
        return "Computer{" +
                "Id=" + Id +
                ", serialVersionID='" + serialVersionID + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", formFactor='" + formFactor + '\'' +
                '}';
    }
}
