package com.gdu.app15.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GoodDTO {
	private int userNo;
	private int blogNo;
	private Date markDate;
}
