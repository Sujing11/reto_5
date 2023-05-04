package com.usa.reto_3.dbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportStatusDbo {

    private Integer completed;
    private Integer cancelled;
}
