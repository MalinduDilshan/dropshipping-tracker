package com.fedolab.dropshipping.components.common.exception;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDefault {
    private String responseCode;
    private String description;
    private List<String> responseValues;
}
