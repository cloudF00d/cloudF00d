package com.ohgiraffers.semiproject.project.projectMake.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OptionMakeDTO {

    String oName;
    char oType;
    int oPrice;
    String oConfigure;
    int oSCode;
    int proCode;

    public OptionMakeDTO(String oName, char oType, int oPrice, String oConfigure, int oSCode) {
        this.oName = oName;
        this.oType = oType;
        this.oPrice = oPrice;
        this.oConfigure = oConfigure;
        this.oSCode = oSCode;
    }
}
