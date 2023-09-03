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
import com.example.personal_info_module.vo.response.EmployeeInfoResponse;
import com.example.personal_info_module.vo.response.FullInfoResponse;
import com.example.personal_info_module.vo.response.PersonalInfoResponse;

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

		model.addAttribute("personalInfoRequest", req);
		model.addAttribute("employeeInfoRequest", new EmployeeInfoRequest());

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
	public String moreInfo(@ModelAttribute PersonalInfoResponse personalInfoResponse, @PathVariable Integer id,
			Model model) {

		FullInfoResponse target = personalInfoService.findInfoById(id);
		model.addAttribute("allInfo", target);
		model.addAttribute("category", 0);
		if (personalInfoResponse != null) {
			model.addAttribute("PersonalInfoResponse", personalInfoResponse);
		}
		return "allInfo";
	}

	@RequestMapping(value = "/info/{id}/delete", method = RequestMethod.GET)
	public String deleteInfo(RedirectAttributes redirectAttributes, @PathVariable Integer id, Model model) {

		PersonalInfoRequest req = new PersonalInfoRequest();
		req.setId(id);
		PersonalInfoResponse p = personalInfoService.deleteInfo(req);
		if (!p.getMessageType()) {
			redirectAttributes.addFlashAttribute("personalInfoResponse", p);
			return "redirect:/info/{id}";
		}

		FullInfoResponse target = personalInfoService.findInfoById(id);

		model.addAttribute("allInfo", target);
		model.addAttribute("category", 0);
		model.addAttribute("personalInfoResponse", p);
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
	public String addInfo(RedirectAttributes redirectAttributes,
			@ModelAttribute PersonalInfoRequest personalInfoRequest,
			@ModelAttribute EmployeeInfoRequest employeeInfoRequest, Model model) {

		if (personalInfoRequest.getName() != null) {
			model.addAttribute("personalInfoRequest", personalInfoRequest);
			if (employeeInfoRequest.getPostCode() != null) {
				model.addAttribute("employeeInfoRequest", employeeInfoRequest);
			}
			return "addInfo";
		} else {
			PersonalInfoRequest req = new PersonalInfoRequest();
			req.setAvailable(false);

			model.addAttribute("personalInfoRequest", req);
			model.addAttribute("employeeInfoRequest", new EmployeeInfoRequest());
		}

		return "addInfo";
	}

	@RequestMapping(value = "/info/new", method = RequestMethod.POST)
	public String newInfo(@ModelAttribute PersonalInfoRequest personalInfoRequest,
			@ModelAttribute EmployeeInfoRequest employeeInfoRequest, RedirectAttributes redirectAttributes,
			Model model) {
		if (personalInfoRequest.getMyNumber().isEmpty()) {

			PersonalInfoResponse p = personalInfoService.addInfo(personalInfoRequest);
			if (!p.getMessageType()) {
				redirectAttributes.addFlashAttribute("personalInfoResponse", p);
				redirectAttributes.addFlashAttribute("personalInfoRequest", personalInfoRequest);
				redirectAttributes.addFlashAttribute("employeeInfoRequest", employeeInfoRequest);

				return "redirect:/info/add";
			}

			employeeInfoService.addInfo(employeeInfoRequest);
			model.addAttribute("searchRequest", new PersonalInfoRequest());
			return "redirect:/info/home";
		} else {
			PersonalInfoResponse p = personalInfoService.addInfo(personalInfoRequest);

			if (!p.getMessageType()) {
				redirectAttributes.addFlashAttribute("personalInfoResponse", p);
				redirectAttributes.addFlashAttribute("personalInfoRequest", personalInfoRequest);
				redirectAttributes.addFlashAttribute("employeeInfoRequest", employeeInfoRequest);

				return "redirect:/info/add";
			}
			EmployeeInfoResponse e = employeeInfoService.addInfo(employeeInfoRequest);
			if (!e.getMessageType()) {
				redirectAttributes.addFlashAttribute("employeeInfoResponse", e);
				redirectAttributes.addFlashAttribute("personalInfoRequest", personalInfoRequest);
				redirectAttributes.addFlashAttribute("employeeInfoRequest", employeeInfoRequest);

				return "redirect:/info/add";
			}
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
	public String eidtInfo(@ModelAttribute PersonalInfoRequest personalInfoRequest,
			@ModelAttribute EmployeeInfoRequest employeeInfoRequest, RedirectAttributes redirectAttributes,
			@PathVariable Integer id, Model model) {
		System.out.println(personalInfoRequest.getAvailable());
		if (personalInfoRequest.getName() != null) {
			model.addAttribute("personalInfoRequest", personalInfoRequest);
			model.addAttribute("employeeInfoRequest", employeeInfoRequest);
			return "editInfo";
		} else {
			PersonalInfoRequest infoP = personalInfoService.findInfoP(id).getReqP();
			EmployeeInfoRequest infoE = employeeInfoService.findInfoF(id).getReqE();
			model.addAttribute("personalInfoRequest", infoP);
			model.addAttribute("employeeInfoRequest", infoE);
			redirectAttributes.addFlashAttribute("personalInfoRequest", infoP);
			redirectAttributes.addFlashAttribute("employeeInfoRequest", infoE);
			System.out.println(((PersonalInfoRequest) model.getAttribute("personalInfoRequest")).getAvailable());
			return "editInfo";
		}
	}

//	@RequestMapping(value = "/info/{id}/edit/more", method = RequestMethod.GET)
//	public String editMoreInfo(@ModelAttribute PersonalInfoRequest personalInfoRequest,
//			@ModelAttribute EmployeeInfoRequest employeeInfoRequest, RedirectAttributes redirectAttributes,
//			@PathVariable Integer id, Model model) {
//		System.out.println(personalInfoRequest.getAvailable());
//		if (personalInfoRequest.getName() != null) {
//			System.out.println(4);
//			
//			model.addAttribute("personalInfoRequest", personalInfoRequest);
//			model.addAttribute("employeeInfoRequest", employeeInfoRequest);
//			redirectAttributes.addFlashAttribute("personalInfoRequest", personalInfoRequest);
//			redirectAttributes.addFlashAttribute("employeeInfoRequest", employeeInfoRequest);
//			return "editInfo";
//		} else {
//			PersonalInfoRequest infoP = personalInfoService.findInfoP(id).getReqP();
//			EmployeeInfoRequest infoE = employeeInfoService.findInfoF(id).getReqE();
//			model.addAttribute("personalInfoRequest", infoP);
//			model.addAttribute("employeeInfoRequest", infoE);
//			redirectAttributes.addFlashAttribute("personalInfoRequest", infoP);
//			redirectAttributes.addFlashAttribute("employeeInfoRequest", infoE);
//			
//			return "editInfo";
//		}
//	}

	@RequestMapping(value = "/info/{id}/edit/update", method = RequestMethod.POST)
	public String updateInfo(@ModelAttribute PersonalInfoRequest personalInfoRequest,
			@ModelAttribute EmployeeInfoRequest employeeInfoRequest, RedirectAttributes redirectAttributes,
			@PathVariable Integer id, Model model) {
		System.out.println(personalInfoRequest.getAvailable());
		PersonalInfoResponse p = personalInfoService.updateInfo(personalInfoRequest);
		if (!p.getMessageType()) {
			
			redirectAttributes.addFlashAttribute("personalInfoResponse", p);
			redirectAttributes.addFlashAttribute("personalInfoRequest", personalInfoRequest);
			EmployeeInfoRequest infoE = employeeInfoService.findInfoF(id).getReqE();
			redirectAttributes.addFlashAttribute("employeeInfoRequest", infoE);
			return "redirect:/info/" + id + "/edit";
		}
		personalInfoRequest.setAvailable(true);
		EmployeeInfoResponse e = employeeInfoService.updateInfo(employeeInfoRequest);
		if (!e.getMessageType()) {
			PersonalInfoRequest infoP = personalInfoService.findInfoP(id).getReqP();
			EmployeeInfoRequest infoE = employeeInfoService.findInfoF(id).getReqE();
			model.addAttribute("personalInfoRequest", infoP);
			model.addAttribute("employeeInfoRequest", infoE);
			redirectAttributes.addFlashAttribute("employeeInfoResponse", e);
			redirectAttributes.addFlashAttribute("personalInfoRequest", personalInfoRequest);
			redirectAttributes.addFlashAttribute("employeeInfoRequest", employeeInfoRequest);
			return "redirect:/info/" + id + "/edit";
		}

		redirectAttributes.addFlashAttribute("searchRequest", new PersonalInfoRequest());
		return "redirect:/info/home";

	}
}
