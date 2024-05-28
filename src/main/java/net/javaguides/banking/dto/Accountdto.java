package net.javaguides.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Accountdto {
    private Long id;
    private String AccountHolderName;
    private double balance;
}
