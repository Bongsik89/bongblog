package org.smallman.vo;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReplyVO {
	
	private int bno;
	private int rno;
	private String content;
	private String writer;
	private Date regdate;

}
