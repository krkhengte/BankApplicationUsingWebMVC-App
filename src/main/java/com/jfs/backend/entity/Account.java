package com.jfs.backend.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "accountDetails")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SrNo")
	private Integer srno;
	@Column(name = "holderName")
	private String holdername;
	@Column(name = "accountNumber")
//	@NotEmpty(message = "Account Number Should Not Be Empty")
	private String accountnumber; 
	@Column(name = "accountBalance")
	private Float accountbalance;
	@Column(name = "userName")
	@NotEmpty(message = "User Name Should Not Be Empty")
	@Email(message = "User Name Should Only Email Id")
	private String username;
	@Column(name = "password")
	@NotEmpty(message = "Password Should Not Be Empty")
	private String password;
	@Column(name = "holderEmailId")
	@Email(message = "Enter Valid Email ID")
	private String holderemailid;
	@Column(name = "holderGender")
	private String holdergender;
	@Column(name = "holderMobile")
	@Size(min= 10, max = 10,message = "Mobile Number Should Be 10 Digit")
	private String holdermobile;
	@CreationTimestamp
	@Column(name = "Created_Date", updatable = false)
	private LocalDateTime createdDate;
	@UpdateTimestamp
	@Column(name = "Updated_Date", insertable = false)
	private LocalDateTime updatedDate;

}
