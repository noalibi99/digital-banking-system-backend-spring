package me.noalibi99.digitalbankingsystembackend.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TransferRequestDTO {
    private String sourceAccountId;
    private String destinationAccountId;
    private double amount;
}
