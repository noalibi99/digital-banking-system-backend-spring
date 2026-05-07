package me.noalibi99.digitalbankingsystembackend.dtos;

import jakarta.persistence.*;
import lombok.*;
import me.noalibi99.digitalbankingsystembackend.entities.BankAccount;
import me.noalibi99.digitalbankingsystembackend.enums.OperationType;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
}
