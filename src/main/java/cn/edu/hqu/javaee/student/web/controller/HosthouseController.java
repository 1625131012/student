package cn.edu.hqu.javaee.student.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hqu.javaee.student.domain.entity.Hosthouse;
import cn.edu.hqu.javaee.student.service.HosthouseService;

@Controller
@RequestMapping("/host_house")
public class HosthouseController {
	@Autowired
	HosthouseService hosthouseService;
	@RequestMapping(value="/{userNameid}",method=RequestMethod.GET)
	public String getMessageList(@PathVariable String userNameid,Model model) {
		List<Hosthouse> houseList=hosthouseService.getMessageByUserName(userNameid);
		model.addAttribute("houseList", houseList);
		model.addAttribute("userNameid",userNameid);
		return "host_house";
	}

}
