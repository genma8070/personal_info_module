package com.example.personal_info_module.service.ifs;

import com.example.personal_info_module.vo.request.EmployeeInfoRequest;
import com.example.personal_info_module.vo.response.EmployeeInfoResponse;

public interface EmployeeInfoService {
	
	public EmployeeInfoResponse addInfo(EmployeeInfoRequest req);

	public EmployeeInfoResponse updateInfo(EmployeeInfoRequest req);
	
}
