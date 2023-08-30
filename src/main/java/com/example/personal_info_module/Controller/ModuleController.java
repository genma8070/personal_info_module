package com.example.personal_info_module.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.personal_info_module.service.ifs.PersonalInfoService;
import com.example.personal_info_module.vo.request.EmployeeInfoRequest;
import com.example.personal_info_module.vo.request.PersonalInfoRequest;
import com.example.personal_info_module.vo.response.FullInfoResponse;

@Controller
public class ModuleController {
	@Autowired
	private PersonalInfoService personalInfoService;
	
	@RequestMapping(value = "/info/home", method = RequestMethod.GET)
	public String goHome(Model model) {
		FullInfoResponse target = personalInfoService.getAllInfo();
		List<FullInfoResponse> res = target.getList();
		model.addAttribute("infoList", res);
		return "infoMeanu";
	}

	@RequestMapping(value = "/infoMeanu", method = RequestMethod.GET)
	public String getAll(Model model) {
		FullInfoResponse target = personalInfoService.getAllInfo();
		List<FullInfoResponse> res = target.getList();
		model.addAttribute("infoList", res);
		return "infoMeanu";
	}
	
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public String moreInfo(@PathVariable Integer id,Model model) {
		PersonalInfoRequest req = new PersonalInfoRequest();
		req.setId(id);
		FullInfoResponse target = personalInfoService.findInfoById(req);
		model.addAttribute("allInfo", target);
		model.addAttribute("category", 0);
		return "allInfo";
	}
	
	@RequestMapping(value = "/info/{id}/category/{num}", method = RequestMethod.GET)
	public String getInfo(@PathVariable Integer id,@PathVariable Integer num,Model model) {
		PersonalInfoRequest req = new PersonalInfoRequest();
		req.setId(id);
		FullInfoResponse target = personalInfoService.findInfoById(req);
		model.addAttribute("allInfo", target);
		model.addAttribute("category", num);
	
		return "allInfo";
	}
	
	@RequestMapping(value = "/info/add", method = RequestMethod.GET)
	public String addInfo(Model model) {
		model.addAttribute("personalInfoRequest", new PersonalInfoRequest());
		model.addAttribute("employeeInfoRequest", new EmployeeInfoRequest());
		return "addInfo";
	}
	
	@RequestMapping(value = "/info/new", method = RequestMethod.POST)
	public String newInfo(@ModelAttribute PersonalInfoRequest personalInfoRequest,@ModelAttribute EmployeeInfoRequest employeeInfoRequest,Model model) {
		
		return "addInfo";
	}

}
