package com.app.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteResponseDto implements Serializable{
	
	private Integer Id;
	private String mail;
	private String motPass;
	private String userName;
}
