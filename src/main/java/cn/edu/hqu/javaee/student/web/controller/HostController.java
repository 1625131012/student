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
import cn.edu.hqu.javaee.student.domain.entity.Host;
import cn.edu.hqu.javaee.student.service.HostService;
import cn.edu.hqu.javaee.student.web.controller.FormEntity.Userhost;

@Controller
@RequestMapping("/host")
public class HostController {
	@Autowired 
	HostService hostService;
	@RequestMapping(value="/registerhost",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new Host());
		return "registerhost";
	}
	@RequestMapping(value="/registerhost",method=RequestMethod.POST)
	public String processRegister(@Valid Host host,Errors errors,RedirectAttributes model) throws IOException {
		if(errors.hasErrors())
			return "registerhost";
		else if(!hostService.register(host)) {
			errors.rejectValue("userNamehou", "用户已存在");
			return "registerhost";
		}
		else {
			Files.copy(Paths.get(StudentApplication.ROOT, host.getUserNamehou()),StandardCopyOption.REPLACE_EXISTING);
			model.addFlashAttribute(host);
			return "redirect:/host/"+host.getUserNamehou();
		}
	}
	
	@RequestMapping(value="/{userNamehou}",method=RequestMethod.GET)
	public String hquerProfile(@PathVariable String userName,Model model) {
		if(!model.containsAttribute("host")) {
			Host host=hostService.getUserDetail(userNamehou);
			model.addAttribute(host);
		}
		return "host_house";
	}
	
	@RequestMapping(value="/loginhost",method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new Userhost());
		return "loginhost";
		
	}
	
	@RequestMapping(value="/loginhost",method=RequestMethod.POST)
	public String processLogin(@Valid Userhost user,Errors erros,RedirectAttributes model) {
		Host host;
		if((host=hostService.login(user.getUserNamehou(), user.getPasswordhou()))==null)
			return "loginhost";
		
		model.addFlashAttribute(host);
		return "redirect:/host/"+host.getUserNamehou();
		
	}
}