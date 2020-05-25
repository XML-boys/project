package org.psw_isa.psw_isa_backend.controller;


import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Prescription;
import org.psw_isa.psw_isa_backend.service.CheckRoleService;
import org.psw_isa.psw_isa_backend.service.PrescriptionService;
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
@RequestMapping(value = "prescription")
public class PrescriptionController {
	
		
		@Autowired
		private PrescriptionService prescriptionService;
		
		@Autowired
		private CheckRoleService checkRoleService;
		
		@GetMapping(value="/notApproved")
		public ResponseEntity<ArrayList<Prescription>> findAllNotApproved() {
			ArrayList<Prescription> notApproved=new ArrayList<Prescription>();
			
			List<Prescription> svi=prescriptionService.findAll();
			
			for (int i=0; i<svi.size();i++) {
				if(svi.get(i).isApproved()==false ) {
					notApproved.add(svi.get(i));
				}
			}
			
			return new ResponseEntity<ArrayList<Prescription>>(notApproved, HttpStatus.OK);
		}
		
		@PutMapping(value="/authenticatePrescription/{id}")
		public ResponseEntity<Long> approvePrescription (@PathVariable("id") Long id){
			
			Long NurseId=checkRoleService.getUser().getId();
			
			prescriptionService.updateApprovePrescription(true,NurseId, id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		
		@PostMapping(consumes = "application/json")
		public ResponseEntity<Long> save(@RequestBody Prescription prescription){
			
			prescription.setApproved(false);
			prescriptionService.save(prescription);
			
			return new ResponseEntity<>(prescription.getId(),HttpStatus.OK);
		}
		
		@PostMapping(value="/changePrescription", consumes = "application/json")
		public ResponseEntity<Long> updatePrescription(@RequestBody Prescription prescription){
			
		
			
			prescriptionService.save(prescription);
			
			return new ResponseEntity<>(prescription.getId(),HttpStatus.OK);
		}
		
		
		
		
}
