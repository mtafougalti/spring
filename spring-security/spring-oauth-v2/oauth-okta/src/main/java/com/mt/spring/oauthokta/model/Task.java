package com.mt.spring.oauthokta.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "All details about the Task. ")
public class Task {
    @ApiModelProperty(notes = "The id of the task")
    private Long id;
    @ApiModelProperty(notes = "The name of the task")
    private String name;
}
