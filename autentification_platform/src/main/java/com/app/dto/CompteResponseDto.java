package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteResponseDto {
	private Integer Id;
	private String mail;
	private String motPass;
	private String userName;
}
