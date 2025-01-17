package com.callor.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoVO {

	private long t_seq;
	private String t_author;
	private String t_sdate;
	private String t_stime;
	private String t_content;
	private String t_edate;
	private String t_etime;
}
