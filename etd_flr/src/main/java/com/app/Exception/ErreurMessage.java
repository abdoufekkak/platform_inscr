package com.app.Exception;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErreurMessage {
	private Date date;
	private String message;
	private Integer code;
}
