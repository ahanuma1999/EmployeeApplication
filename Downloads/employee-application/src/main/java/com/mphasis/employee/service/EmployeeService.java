package com.mphasis.employee.service;

import java.util.Optional;


import com.mphasis.employee.model.EmployeeEntity;



public interface EmployeeService {
	Iterable<EmployeeEntity> getAllEmployee();


	void saveEmployee(EmployeeEntity employee);

	 void updateEmployee(EmployeeEntity employee);
	 
	 
	Optional<EmployeeEntity> getEmployeeById(Long sapid);
	
	boolean isEmployeeExist(Long sapid);

	void deleteEmployee(long sapId);

	Iterable<EmployeeEntity> getDeletedEmployee();
	Optional<EmployeeEntity> searchSapID(Long id);
	
	Optional<EmployeeEntity> searchId(int type, Long id);
	
	 
	 
	 
	
	/*
	 * 
	{	"sapId":1,
	    "ldapId": 222,
	    "firstName": "eee",
	    "middleName": "ff",
	    "lastName": "fff",
	    "offShorePM": "",
	    "offShoreDM": "ddd",
	    "onSitePM": "",
	    "onSiteDM": "",
	    "fedexMgr": "ddd",
	    "clientMD": "1",
	    "fedexVP": "vvv",
	    "fedexSVP": "ffff",
	    "mphasisEmail": "prasana4599@gmail.com",
	    "fedexEmail": "prasana4599@gmail.com",
	    "personalEmail": "",
	    "contactNumber": 7373118898,
	    "contractNumber": 33333,
	    "projectName": "",
	    "projectID": "",
	    "idDeleted": false
	   
	}
	
			*/
}

		