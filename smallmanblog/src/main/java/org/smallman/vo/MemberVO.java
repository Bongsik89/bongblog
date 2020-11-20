package org.smallman.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberVO {
	
	private String userId;
	private String userPass;
	private String userName;
	private String userMail;
	private String regDate;

}
