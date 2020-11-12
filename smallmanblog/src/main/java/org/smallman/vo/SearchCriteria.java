package org.smallman.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@Data
@EqualsAndHashCode (callSuper = false)
public class SearchCriteria extends Criteria{
	
	private String searchType  = "";
	private String keyword = "";

}
