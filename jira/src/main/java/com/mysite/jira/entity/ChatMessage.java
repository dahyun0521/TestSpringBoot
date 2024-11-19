package com.mysite.jira.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_message_seq")
	@SequenceGenerator(name = "chat_message_seq", sequenceName = "chat_message_seq", allocationSize = 1)
	private Integer idx; 
	
	@Column(columnDefinition = "VARCHAR2(4000)")
	@NotNull
	private String content;
	
	@Column
	private LocalDateTime sendDate;
	
	@ManyToOne
	private Account account;
	
	@ManyToOne
	private ChatRoom chatRoom;
	
	@OneToMany(mappedBy = "chatMessage", cascade = CascadeType.REMOVE) 
	private List<ChatEmojiRecord> chatEmojiList;
}
