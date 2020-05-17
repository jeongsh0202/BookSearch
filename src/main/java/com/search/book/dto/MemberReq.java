package com.search.book.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberReq implements Serializable {
	
	private static final long serialVersionUID = 8800985387371121441L;

	private String id;
	
	private String password;
}
