package com.haritonov.spring.enterprise_doc.document.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProxyResponse {
    private Integer id;

    private String organizationName;
    private String customerName;
    private String employeeName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfIssue;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate isValidUntil;

    private List<ProxyItemResponse> bodyItems;
}
