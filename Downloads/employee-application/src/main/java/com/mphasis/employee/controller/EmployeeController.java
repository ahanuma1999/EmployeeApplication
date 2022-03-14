package com.mphasis.employee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.employee.model.EmployeeEntity;
import com.mphasis.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<?> saveEmployee(@RequestBody EmployeeEntity employee) {

		ResponseEntity<?> resp = null;
		try {

			long sapId = employee.getSapId();
			Optional<EmployeeEntity> opt = employeeService.searchSapID(sapId);
			if (employee.getClass() == null) {
				resp = new ResponseEntity<>( HttpStatus.BAD_REQUEST);
			} else if (opt.isEmpty()) {
				employeeService.saveEmployee(employee);
				resp = new ResponseEntity<>( HttpStatus.CREATED);

			} else if (opt.isPresent()) {

				resp = new ResponseEntity<>( HttpStatus.BAD_REQUEST);
			}
		} catch (Exception ex) {
			resp = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			ex.printStackTrace();
		}

		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeEntity employee) {

		ResponseEntity<?> resp = null;
		try {
			long sapId = employee.getSapId();
			Optional<EmployeeEntity> opt = employeeService.searchSapID(sapId);

			if (employee.getClass() == null) {
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST,HttpStatus.METHOD_NOT_ALLOWED);
			} else if (opt.isPresent()) {
				employeeService.updateEmployee(employee);
				resp = new ResponseEntity<>(HttpStatus.OK);
			}else {
				employeeService.updateEmployee(employee);
				resp = new  ResponseEntity<>(HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			resp = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			ex.printStackTrace();
		}

		return resp;
	}

	@GetMapping("/search/{type}/{id}")
	public ResponseEntity<?> findEmployee(@PathVariable int type, @PathVariable Long id) {
		ResponseEntity<?> resp = null;
		try {

			Optional<EmployeeEntity> opt = employeeService.searchId(type, id);
			if (opt.isPresent()) {

				resp = new ResponseEntity<EmployeeEntity>(opt.get(), HttpStatus.OK);

			} else {

				resp = new ResponseEntity<String>("Employee '" + id + "'does not exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception ex) {
			resp = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			ex.printStackTrace();
		}

		return resp;
	}

	@DeleteMapping("/delete/{sapId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable long sapId) {
		ResponseEntity<?> resp = null;
		try {

			Optional<EmployeeEntity> opt = employeeService.searchSapID(sapId);
			if (opt.isPresent()) {
				employeeService.deleteEmployee(sapId);
				resp = new ResponseEntity<String>("Employee '" + sapId + "'deleted successfully", HttpStatus.OK);

			} else {

				resp = new ResponseEntity<String>("Employee '" + sapId + "'does not exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception ex) {
			resp = new ResponseEntity<String>("Unable to process request", HttpStatus.INTERNAL_SERVER_ERROR);
			ex.printStackTrace();
		}

		return resp;
	}

	@GetMapping("/employees")
	public Iterable<EmployeeEntity> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/deleted")
	public Iterable<EmployeeEntity> getDeletedEmployee() {
		return employeeService.getDeletedEmployee();
	}

}
