package com.mphasis.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.employee.model.EmployeeEntity;
import com.mphasis.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(EmployeeEntity employee) {

		employeeRepository.save(employee);

	}

	@Override
	public void updateEmployee(EmployeeEntity employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Optional<EmployeeEntity> getEmployeeById(Long sapid) {
		//employeeRepository.findById(sapid);
		return employeeRepository.findById(sapid);
	}

	@Override
	public boolean isEmployeeExist(Long sapid) {
		//employeeRepository.existsById(sapid);
		return employeeRepository.existsById(sapid);
	}

	@Override
	public void deleteEmployee(long sapId) {
		
		employeeRepository.deleteById(sapId);

	}

	@Override
	public Iterable<EmployeeEntity> getAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Iterable<EmployeeEntity> getDeletedEmployee() {

		return employeeRepository.findAllIsDeleted();
	}

	@Override
	public Optional<EmployeeEntity> searchId(int type, Long id) {
		Optional<EmployeeEntity> e = null;
		if (type == 1) {
			e = employeeRepository.searchSapId(id);
		} else if (type == 2) {

			e = employeeRepository.searchLdapId(id);
		}

		return e;
	}

	@Override
	public Optional<EmployeeEntity> searchSapID(Long id) {

		return employeeRepository.searchSapId(id);
	}

}
