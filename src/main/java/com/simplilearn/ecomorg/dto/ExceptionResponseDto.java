package com.simplilearn.ecomorg.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDto {

	private String message;
	private Date timestamp = new Date();
	private String status;
	private String error;
}
