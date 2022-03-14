package com.mphasis.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "Employees")
@SQLDelete(sql = "UPDATE Employees SET Is_Deleted = true WHERE Sap_Id=?")
public class EmployeeEntity {

	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SapId", unique = true, nullable = false)
	private long sapId;

	@Column(name = "LdapId", unique = true, nullable = false)
	private long ldapId;

	@Column(name = "FirstName", nullable = false)
	private String firstName;

	@Column(name = "MiddleName")
	private String middleName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "OffShorePM")
	private String offShorePM;

	@Column(name = "OffShoreDM")
	private String offShoreDM;

	@Column(name = "OnSitePM")
	private String onSitePM;

	@Column(name = "OnSiteDM")
	private String onSiteDM;

	@Column(name = "FedexMgr")
	private String fedexMgr;

	@Column(name = "ClientMD")
	private String clientMD;

	@Column(name = "FedexVP")
	private String fedexVP;

	@Column(name = "FedexSVP")
	private String fedexSVP;

	@Column(name = "MphasisEmail", unique = true, nullable = false)
	private String mphasisEmail;

	@Column(name = "FedexEmail", unique = true, nullable = false)
	private String fedexEmail;

	@Column(name = "PersonalEmail", unique = true, nullable = false)

	private String personalEmail;

	@Column(name = "ContactNumber", unique = true, nullable = false, length = 10)
	private long contactNumber;

	@Column(name = "ContractNumber")
	private long contractNumber;

	@Column(name = "ProjectName")
	private String projectName;

	@Column(name = "ProjectID")
	private String projectID;

	@Column(name = "IsDeleted")
	private Boolean isDeleted = false;

	public EmployeeEntity() {
	}

	public EmployeeEntity(long sapId, long ldapId, String firstName, String middleName, String lastName,
			String offShorePM, String offShoreDM, String onSitePM, String onSiteDM, String fedexMgr, String clientMD,
			String fedexVP, String fedexSVP, String mphasisEmail, String fedexEmail, String personalEmail,
			long contactNumber, long contractNumber, String projectName, String projectID, Boolean isDeleted) {
		super();
		this.sapId = sapId;
		this.ldapId = ldapId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.offShorePM = offShorePM;
		this.offShoreDM = offShoreDM;
		this.onSitePM = onSitePM;
		this.onSiteDM = onSiteDM;
		this.fedexMgr = fedexMgr;
		this.clientMD = clientMD;
		this.fedexVP = fedexVP;
		this.fedexSVP = fedexSVP;
		this.mphasisEmail = mphasisEmail;
		this.fedexEmail = fedexEmail;
		this.personalEmail = personalEmail;
		this.contactNumber = contactNumber;
		this.contractNumber = contractNumber;
		this.projectName = projectName;
		this.projectID = projectID;
		this.isDeleted = isDeleted;
	}

	public long getSapId() {
		return sapId;
	}

	public void setSapId(long sapId) {
		this.sapId = sapId;
	}

	public long getLdapId() {
		return ldapId;
	}

	public void setLdapId(long ldapId) {
		this.ldapId = ldapId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOffShorePM() {
		return offShorePM;
	}

	public void setOffShorePM(String offShorePM) {
		this.offShorePM = offShorePM;
	}

	public String getOffShoreDM() {
		return offShoreDM;
	}

	public void setOffShoreDM(String offShoreDM) {
		this.offShoreDM = offShoreDM;
	}

	public String getOnSitePM() {
		return onSitePM;
	}

	public void setOnSitePM(String onSitePM) {
		this.onSitePM = onSitePM;
	}

	public String getOnSiteDM() {
		return onSiteDM;
	}

	public void setOnSiteDM(String onSiteDM) {
		this.onSiteDM = onSiteDM;
	}

	public String getFedexMgr() {
		return fedexMgr;
	}

	public void setFedexMgr(String fedexMgr) {
		this.fedexMgr = fedexMgr;
	}

	public String getClientMD() {
		return clientMD;
	}

	public void setClientMD(String clientMD) {
		this.clientMD = clientMD;
	}

	public String getFedexVP() {
		return fedexVP;
	}

	public void setFedexVP(String fedexVP) {
		this.fedexVP = fedexVP;
	}

	public String getFedexSVP() {
		return fedexSVP;
	}

	public void setFedexSVP(String fedexSVP) {
		this.fedexSVP = fedexSVP;
	}

	public String getMphasisEmail() {
		return mphasisEmail;
	}

	public void setMphasisEmail(String mphasisEmail) {
		this.mphasisEmail = mphasisEmail;
	}

	public String getFedexEmail() {
		return fedexEmail;
	}

	public void setFedexEmail(String fedexEmail) {
		this.fedexEmail = fedexEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(long contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [sapId=" + sapId + ", ldapId=" + ldapId + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", offShorePM=" + offShorePM + ", offShoreDM=" + offShoreDM
				+ ", onSitePM=" + onSitePM + ", onSiteDM=" + onSiteDM + ", fedexMgr=" + fedexMgr + ", clientMD="
				+ clientMD + ", fedexVP=" + fedexVP + ", fedexSVP=" + fedexSVP + ", mphasisEmail=" + mphasisEmail
				+ ", fedexEmail=" + fedexEmail + ", personalEmail=" + personalEmail + ", contactNumber=" + contactNumber
				+ ", contractNumber=" + contractNumber + ", projectName=" + projectName + ", projectID=" + projectID
				+ ", isDeleted=" + isDeleted + "]";
	}

}
