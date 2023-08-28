package com.example.personal_info_module.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.personal_info_module.service.ifs.SubCategoryService;
import com.example.personal_info_module.vo.request.SubCategoryRequest;
import com.example.personal_info_module.vo.response.SubCategoryResponse;

@CrossOrigin
@RestController
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@PostMapping("/find_subC")
	public SubCategoryResponse findSubCategory(@RequestBody SubCategoryRequest req) {
		return subCategoryService.findSubCategory(req);

	};

}
