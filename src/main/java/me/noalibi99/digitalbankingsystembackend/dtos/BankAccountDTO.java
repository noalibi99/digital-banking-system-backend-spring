package me.noalibi99.digitalbankingsystembackend.dtos;

import jakarta.persistence.*;
import lombok.*;
import me.noalibi99.digitalbankingsystembackend.entities.AccountOperation;
import me.noalibi99.digitalbankingsystembackend.entities.Customer;
import me.noalibi99.digitalbankingsystembackend.enums.AccountStatus;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class BankAccountDTO {
    private String type;
}
