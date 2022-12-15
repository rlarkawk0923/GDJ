package com.gdu.app15.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {
	private long userNo;
	private String id;
	private String pw;
	private String name;
}
