package com.example.personal_info_module.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.personal_info_module.repository.EmployeeInfoDao;
import com.example.personal_info_module.repository.PersonalInfoDao;
import com.example.personal_info_module.service.ifs.EmployeeInfoService;
import com.example.personal_info_module.service.ifs.PersonalInfoService;
import com.example.personal_info_module.vo.request.EmployeeInfoRequest;
import com.example.personal_info_module.vo.request.PersonalInfoRequest;
import com.example.personal_info_module.vo.response.FullInfoResponse;

@Controller
public class ModuleController {
	@Autowired
	private PersonalInfoService personalInfoService;
	@Autowired
	private PersonalInfoDao personalInfoDao;
	@Autowired
	private EmployeeInfoService employeeInfoService;
	@Autowired
	private EmployeeInfoDao employeeInfoDao;

	@RequestMapping(value = "/info/home", method = RequestMethod.GET)
	public String goHome(Model model) {

		FullInfoResponse target = personalInfoService.getAllInfo();
		List<FullInfoResponse> res = target.getList();
		model.addAttribute("infoList", res);

		PersonalInfoRequest req = new PersonalInfoRequest();
		model.addAttribute("searchRequest", req);

		return "infoMenu";
	}

	@RequestMapping(value = "/info/search", method = RequestMethod.GET)
	public String search(@ModelAttribute PersonalInfoRequest searchRequest, Model model) {

		FullInfoResponse target = personalInfoService.search(searchRequest);
		List<FullInfoResponse> res = target.getList();
		model.addAttribute("infoList", res);

		PersonalInfoRequest req = new PersonalInfoRequest();
		model.addAttribute("searchRequest", req);

		return "infoMenu";
	}

	@RequestMapping(value = "/infoMenu", method = RequestMethod.GET)
	public String getAll(Model model) {

		FullInfoResponse target = personalInfoService.getAllInfo();
		List<FullInfoResponse> res = target.getList();
		model.addAttribute("infoList", res);

		return "infoMenu";
	}

	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public String moreInfo(@PathVariable Integer id, Model model) {

		FullInfoResponse target = personalInfoService.findInfoById(id);
		model.addAttribute("allInfo", target);
		model.addAttribute("category", 0);

		return "allInfo";
	}

	@RequestMapping(value = "/info/{id}/delete", method = RequestMethod.GET)
	public String deleteInfo(@PathVariable Integer id, Model model) {

		PersonalInfoRequest req = new PersonalInfoRequest();
		req.setId(id);
		personalInfoService.deleteInfo(req);

		FullInfoResponse target = personalInfoService.findInfoById(id);

		model.addAttribute("allInfo", target);
		model.addAttribute("category", 0);

		return "allInfo";
	}

	@RequestMapping(value = "/info/{id}/category/{num}", method = RequestMethod.GET)
	public String getInfo(@PathVariable Integer id, @PathVariable Integer num, Model model) {

		PersonalInfoRequest req = new PersonalInfoRequest();
		req.setId(id);
		FullInfoResponse target = personalInfoService.findInfoById(id);

		model.addAttribute("allInfo", target);
		model.addAttribute("category", num);

		return "allInfo";
	}

	@RequestMapping(value = "/info/add", method = RequestMethod.GET)
	public String addInfo(Model model) {
		PersonalInfoRequest req = new PersonalInfoRequest();
		req.setAvailable(false);

		model.addAttribute("personalInfoRequest", req);
		model.addAttribute("employeeInfoRequest", new EmployeeInfoRequest());

		return "addInfo";
	}

	@RequestMapping(value = "/info/new", method = RequestMethod.POST)
	public String newInfo(@ModelAttribute PersonalInfoRequest personalInfoRequest,
			@ModelAttribute EmployeeInfoRequest employeeInfoRequest, RedirectAttributes redirectAttributes,
			Model model) {
		if (personalInfoRequest.getMyNumber().isEmpty()) {

			personalInfoService.addInfo(personalInfoRequest);
			employeeInfoService.addInfo(employeeInfoRequest);
			PersonalInfoRequest req = new PersonalInfoRequest();
			model.addAttribute("searchRequest", req);
			return "redirect:/info/home";
		} else {

			personalInfoService.addInfo(personalInfoRequest);
			employeeInfoService.addInfo(employeeInfoRequest);
			personalInfoRequest.setAvailable(true);

			FullInfoResponse target = personalInfoService.getNewstInfo();
			personalInfoRequest.setId(target.getRes().getId());
			employeeInfoRequest.setId(target.getRes().getId());
			redirectAttributes.addFlashAttribute("personalInfoRequest", personalInfoRequest);
			redirectAttributes.addFlashAttribute("employeeInfoRequest", employeeInfoRequest);
			return "redirect:/info/add/more/" + target.getRes().getId();
		}
	}

	@RequestMapping(value = "/info/add/more/{id}", method = RequestMethod.GET)
	public String addMoreInfo(@PathVariable Integer id, Model model) {

		return "addInfo";
	}

	@RequestMapping(value = "/info/{id}/edit", method = RequestMethod.GET)
	public String eidtInfo(RedirectAttributes redirectAttributes,@PathVariable Integer id, Model model) {

		PersonalInfoRequest infoP = personalInfoService.findInfoP(id).getReqP();
		EmployeeInfoRequest infoE = employeeInfoService.findInfoF(id).getReqE();

		model.addAttribute("personalInfo", infoP);
		model.addAttribute("employeeInfo", infoE);
		redirectAttributes.addFlashAttribute("personalInfo", infoP);
		redirectAttributes.addFlashAttribute("employeeInfo", infoE);
		return "editInfo";
	}

	@RequestMapping(value = "/info/{id}/edit/more", method = RequestMethod.GET)
	public String editMoreInfo(@PathVariable Integer id, Model model) {
		PersonalInfoRequest infoP = personalInfoService.findInfoP(id).getReqP();
		EmployeeInfoRequest infoE = employeeInfoService.findInfoF(id).getReqE();

		model.addAttribute("personalInfo", infoP);
		model.addAttribute("employeeInfo", infoE);
		System.out.println(infoP.getMyNumber());
		System.out.println(infoP.getAvailable());

		return "editInfo";
	}

	@RequestMapping(value = "/info/{id}/edit/update", method = RequestMethod.POST)
	public String updateInfo(@ModelAttribute PersonalInfoRequest personalInfo,@ModelAttribute EmployeeInfoRequest employeeInfo, RedirectAttributes redirectAttributes,
			@PathVariable Integer id, Model model) {
		
		if (personalInfo.getMyNumber().isEmpty()) {
			personalInfoService.updateInfo(personalInfo);

			redirectAttributes.addFlashAttribute("searchRequest", new PersonalInfoRequest());
			return "redirect:/info/home";
			
		} else if(!(personalInfo.getMyNumber().isEmpty()) && !(personalInfo.getAvailable())){

			personalInfoService.updateInfo(personalInfo);
			employeeInfoService.updateInfo(employeeInfo);
			personalInfo.setAvailable(true);

			redirectAttributes.addFlashAttribute("personalInfo", personalInfo);
			redirectAttributes.addFlashAttribute("employeeInfo", employeeInfo);
			return "redirect:/info/" + id + "/edit/more";
		} else {
			personalInfoService.updateInfo(personalInfo);
			employeeInfoService.updateInfo(employeeInfo);
			
			redirectAttributes.addFlashAttribute("searchRequest", new PersonalInfoRequest());
			return "redirect:/info/home" ;
		}
		
	}
}
