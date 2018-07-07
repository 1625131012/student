package cn.edu.hqu.javaee.student.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hqu.javaee.student.domain.entity.Studenthouse;
import cn.edu.hqu.javaee.student.service.StudenthouseService;

@Controller
@RequestMapping("/stu_house")
public class MessageController {
	@Autowired
	StudenthouseService studenthouseService;
	@RequestMapping(value="/{userNameid}",method=RequestMethod.GET)
	public String getMessageList(@PathVariable String userNameid,Model model) {
		List<Studenthouse> msgList=studenthouseService.getMessageByUserName(userNameid);
		model.addAttribute("houseList", houseList);
		model.addAttribute("userNameid",userNameid);
		return "stu_house";
	}

}
