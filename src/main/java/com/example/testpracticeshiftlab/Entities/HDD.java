package com.example.testpracticeshiftlab.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HDD {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String serialVersionID;
    private String producer;
    private int price;
    private int amount;

    private int volume;

    @Override
    public String toString() {
        return "HDD{" +
                "Id=" + Id +
                ", serialVersionID='" + serialVersionID + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", volume=" + volume +
                '}';
    }
}
