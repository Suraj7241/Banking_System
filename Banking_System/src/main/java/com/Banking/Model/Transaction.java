package com.Banking.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    
    @ManyToOne
    @JoinColumn(name="account_id",nullable= false)
    private Account account;
    
    private LocalDateTime transactionDate;
    
    private double amount;
    
    private String description;
}

