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

@ApiModel(description = "All details about the Person. ")
public class Person {
    @ApiModelProperty(notes = "The id of the person")
    private Long id;
    @ApiModelProperty(notes = "The first name of the person")
    private String firstName;
    @ApiModelProperty(notes = "The last name of the person")
    private String lastName;
}
