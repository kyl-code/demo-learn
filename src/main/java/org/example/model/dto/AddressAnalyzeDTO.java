package org.example.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author adam.guo
 * @date:2020/11/26
 */
@Data
public class AddressAnalyzeDTO {

    @ApiModelProperty(value = "联系人")
    private String contacts;

    @ApiModelProperty(value = "联系电话")
    private String contactsPhone;

    @ApiModelProperty(value = "详细地址")
    private String particular;
}
