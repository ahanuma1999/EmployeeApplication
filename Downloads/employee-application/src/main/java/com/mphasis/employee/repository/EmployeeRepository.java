package com.mphasis.employee.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.mphasis.employee.model.*;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
	

	@Query(value="update employees e set e.is_Deleted=true where e.sap_Id= ?1 ",nativeQuery = true)
	@Modifying
	void softDeleteById(long sapId);

	@Query(value="select * from employees e where e.is_Deleted=true",nativeQuery = true)
	@Modifying
	Iterable<EmployeeEntity> findAllIsDeleted();

	@Query(value="select * from employees where sap_Id = ?1 and is_Deleted=false",nativeQuery = true)
	//@Modifying
	Optional<EmployeeEntity> searchSapId(Long id);
	
	@Query(value="select * from employees where ldap_Id = ?1 and is_Deleted=false",nativeQuery = true)
	//@Modifying
	Optional<EmployeeEntity> searchLdapId(Long id);
	
	@Query(value="select * from employees where firstname=? and is_Deleted=false",nativeQuery = true)
	boolean existsByFirstname(String name);


}
