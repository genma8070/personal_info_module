package com.example.personal_info_module.service.ifs;

import com.example.personal_info_module.vo.request.PersonalInfoRequest;
import com.example.personal_info_module.vo.response.FullInfoResponse;
import com.example.personal_info_module.vo.response.PersonalInfoResponse;


public interface PersonalInfoService {

	public PersonalInfoResponse addInfo(PersonalInfoRequest req);

	public PersonalInfoResponse updateInfo(PersonalInfoRequest req);
	
	public PersonalInfoResponse deleteInfo(PersonalInfoRequest req);
	
	public FullInfoResponse getAllInfo();
	
	public FullInfoResponse findInfoById(PersonalInfoRequest req);
}
