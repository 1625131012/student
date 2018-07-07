package cn.edu.hqu.javaee.student.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.edu.hqu.javaee.student.StudentApplication;
import cn.edu.hqu.javaee.student.domain.entity.Student;
import cn.edu.hqu.javaee.student.service.StudentService;
import cn.edu.hqu.javaee.student.web.controller.FormEntity.Userstudent;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired 
	StudentService studentService;
	@RequestMapping(value="/registerstudent",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new Student());
		return "registerstudent";
	}
	@RequestMapping(value="/registerstudent",method=RequestMethod.POST)
	public String processRegister(@Valid Student student,Errors errors,RedirectAttributes model) throws IOException {
		if(errors.hasErrors())
			return "registerstudent";
		else if(!studentService.register(student)) {
			errors.rejectValue("userNamestu", "用户已存在");
			return "registerstudent";
		}
		else {
			Files.copy(Paths.get(StudentApplication.ROOT, student.getUserNamestu()),StandardCopyOption.REPLACE_EXISTING);
			model.addFlashAttribute(student);
			return "redirect:/student/"+student.getUserName();
		}
	}
	
	@RequestMapping(value="/{userNamestu}",method=RequestMethod.GET)
	public String hquerProfile(@PathVariable String userNamestu,Model model) {
		if(!model.containsAttribute("student")) {
			Student student=studentService.getUserDetail(userNamestu);
			model.addAttribute(student);
		}
		return "stu_house";
	}
	
	@RequestMapping(value="/loginstu",method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new Userstudent());
		return "loginstu";
		
	}
	
	@RequestMapping(value="/loginstu",method=RequestMethod.POST)
	public String processLogin(@Valid Student student,Errors erros,RedirectAttributes model) {
		Student student;
		if((student=studentService.login(student.getUserNamestu(), student.getPasswordstu()))==null)
			return "loginstu";
		
		model.addFlashAttribute(student);
		return "redirect:/student/"+student.getUserNamestu();
		
	}
}