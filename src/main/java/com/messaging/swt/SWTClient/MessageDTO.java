package com.messaging.swt.SWTClient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
	
	private String content;
	private int idUser;
	private String location;
	private String subject;
	private Long duration;
	
}
