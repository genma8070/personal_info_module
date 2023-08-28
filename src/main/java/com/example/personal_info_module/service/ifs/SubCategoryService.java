package com.example.personal_info_module.service.ifs;

import com.example.personal_info_module.vo.request.SubCategoryRequest;
import com.example.personal_info_module.vo.response.SubCategoryResponse;

public interface SubCategoryService {

	public SubCategoryResponse findSubCategory(SubCategoryRequest req);
	
}
