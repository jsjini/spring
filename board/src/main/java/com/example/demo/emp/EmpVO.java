package com.example.demo.emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@ToString
//@AllArgsConstructor // 모든필드 생성자
//@RequiredArgsConstructor
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	int employeeId;
	String firstName;
	String lastName;
	String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	Date hireDate;
	Integer salary;
	String jobId;
	String departmentId;
	String managerId;
	String phone;
	String photo;
}
