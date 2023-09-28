package com.the.simone.model.response;

import com.the.simone.model.entity.MmCreation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MmCreationResponse {

    private String msg;
    private MmCreation creation;
    private String note;
}
