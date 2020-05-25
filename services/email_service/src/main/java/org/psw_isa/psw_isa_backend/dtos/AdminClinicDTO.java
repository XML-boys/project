package org.psw_isa.psw_isa_backend.dtos;

import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;

public class AdminClinicDTO {
	
	private Long Admin_Id;
	private Long Clinic_Id;
	
	
	
	
	public AdminClinicDTO(Long Admin_Id, Long Clinic_Id) {
		super();
		this.Admin_Id=Admin_Id;
		this.Clinic_Id=Clinic_Id;
	}
	
	public AdminClinicDTO(ClinicAdministrator clinicAdministrator) {
		this(clinicAdministrator.getId(), clinicAdministrator.getClinic().getId());
	}
	
	public Long getAdmin_Id() {
		return Admin_Id;
	}
	public void setAdmin_Id(Long admin_Id) {
		Admin_Id = admin_Id;
	}
	public Long getClinic_Id() {
		return Clinic_Id;
	}
	public void setClinic_Id(Long clinic_Id) {
		Clinic_Id = clinic_Id;
	}
	
}
