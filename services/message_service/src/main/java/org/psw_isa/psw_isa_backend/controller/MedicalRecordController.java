package org.psw_isa.psw_isa_backend.controller;



import org.psw_isa.psw_isa_backend.dtos.MedicalRecordDTO;
import org.psw_isa.psw_isa_backend.dtos.PatientInfoDTO;
import org.psw_isa.psw_isa_backend.models.MedicalRecord;
import org.psw_isa.psw_isa_backend.service.MedicalRecordService;
import org.psw_isa.psw_isa_backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "medicalRecord")
public class MedicalRecordController {

	@Autowired 
	MedicalRecordService medicalRecordService;
	
	@Autowired
	PatientService patientService;

	 @GetMapping(value = "/{id}")
		public ResponseEntity<MedicalRecordDTO> findOneById(@PathVariable("id") Long id){
	
		return new ResponseEntity<MedicalRecordDTO>(medicalRecordService.findOneMedicalById(id), HttpStatus.OK);
	 }
	 
	 @GetMapping(value = "")
		public ResponseEntity<PatientInfoDTO> findOneBySession(){
		 	PatientInfoDTO patientInfoDTO = medicalRecordService.getOneBySession();
		 	if(patientInfoDTO != null) {
		 		return new ResponseEntity<PatientInfoDTO>(patientInfoDTO, HttpStatus.OK);
		 	} else {
		 		return new ResponseEntity<PatientInfoDTO>(patientInfoDTO, HttpStatus.FORBIDDEN);
		 	}
	 }
	 
	 @PostMapping(value="/change", consumes = "application/json")
		public ResponseEntity<Long> changeRecord(@RequestBody  MedicalRecordDTO medicalRecordDTO){
			
			medicalRecordService.updateMedicalRecord(medicalRecordDTO);
			
			
			return new ResponseEntity<>(medicalRecordDTO.getId(),HttpStatus.OK);
		}
}
