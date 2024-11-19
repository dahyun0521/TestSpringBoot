package com.mysite.jira.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ChatEmojiRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jira_seq")
	@SequenceGenerator(name = "jira_seq", sequenceName = "jira_seq", allocationSize = 1)
	private Integer idx; 
	
	@Column(columnDefinition = "VARCHAR2(40)")
	@NotNull
	private String charcode;
	
	@ManyToOne
	private ChatRoom chatRoom;
	
	@ManyToOne
	private ChatMessage chatMessage;
}
