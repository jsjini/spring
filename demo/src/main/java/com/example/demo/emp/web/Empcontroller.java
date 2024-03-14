package com.example.demo.emp.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller	// 컨테이너 빈 등록 + 사용자요청처리할 수 있는 커맨드 핸들러 변환
public class Empcontroller {
	
	final EmpMapper mapper; // 의존성주입(DI Dependency Injection)
	
	@RequestMapping("/empResult") 
	public String result() { 
		return "result";
	}
	
	@PostMapping("/insert3")
	public String insert3(EmpVO vo, RedirectAttributes rttr) {
		System.out.println("등록 : " + vo);
		rttr.addAttribute("insertResult", "success");
		rttr.addFlashAttribute("flashResult", "한번만 사용가능");
		return "redirect:empResult";
	}
	
	@PostMapping("/insert2")
	public ResponseEntity<EmpVO> insert2(EmpVO vo) {
		return new ResponseEntity<>(vo ,HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ModelAndView insert(@ModelAttribute("emp") EmpVO vo) {
		System.out.println(vo);
//		mapper.insertEmp(vo);
		// 커맨드객체는 model에 자동으로 추가
		// model.addAttribute("empVO", vo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("insertResult","success");
		mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return mv;
	}
	
	@GetMapping("/")
	public String test() {
		return "index";
	}
	
	@RequestMapping("/ajaxEmp")
	@ResponseBody
	public List<EmpVO> ajaxEmp() {
		return mapper.getEmpList(null, null);
	}
	
	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("empList", mapper.getEmpList(null, null));
		return "empList";
	}
}
