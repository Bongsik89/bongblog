package org.smallman.vo;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardVO {
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int hit;

}
