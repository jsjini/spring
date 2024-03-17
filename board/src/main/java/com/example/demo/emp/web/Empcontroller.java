package com.example.demo.emp.web;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller	// 컨테이너 빈 등록 + 사용자요청처리할 수 있는 커맨드 핸들러 변환
public class Empcontroller {
	
	final EmpMapper mapper; // 의존성주입(DI Dependency Injection)
	
	// 등록페이지 이동
	@GetMapping("/emp/insert")
	public void insert() { }
	
	// 등록 처리 --> photo  employees 테이블에 photo 컬럼 추가
	@PostMapping("/insert")
	public String insert(@ModelAttribute("emp") EmpVO vo, MultipartFile photoFile) throws IllegalStateException, IOException {
		System.out.println("photoFile : " + photoFile);
		if(!photoFile.isEmpty()) {
			// 파일 업로드...
			File file = new File("d:/upload", photoFile.getOriginalFilename());
			photoFile.transferTo(file);
			vo.setPhoto(photoFile.getOriginalFilename());
		}
		System.out.println(vo);
		mapper.insertEmp(vo);
		return "redirect:/emp/list";
	}	
	
	// 수정페이지 이동
	@GetMapping("/emp/update/{employeeId}")
	public String update(Model model, @PathVariable int employeeId) {
		model.addAttribute("empVO", mapper.getEmpInfo(employeeId));
		return "/emp/update";
	}
	// 수정처리
	@PostMapping("/update")
	public String update(EmpVO vo) {
		System.out.println(vo);
		mapper.updateEmp(vo);
		return "redirect:/emp/list";
	}	
	
	// 상세조회
	@GetMapping("/emp/info/{employeeId}")
	public String getEmpInfo(Model model, @PathVariable int employeeId) {
		
		EmpVO emp = mapper.getEmpInfo(employeeId);
		model.addAttribute("emp", emp);
		System.out.println(emp);
		return "/emp/info";
	}	
	
	// 삭제처리
	@PostMapping("/emp/delete")
	public String delete(int employeeId) {
		System.out.println(employeeId);
		mapper.deleteEmp(employeeId);
		return "redirect:/emp/list";
	}	
	
	
	// 목록페이지 이동
	@RequestMapping("/emp/list")
	public String empList(Model model, EmpVO vo, SearchVO svo) {
		model.addAttribute("empList", mapper.getEmpList(vo, svo));
		return "emp/list";
	}
	


}
