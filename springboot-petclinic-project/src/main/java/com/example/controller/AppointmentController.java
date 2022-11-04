package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.exception.AppointmentServiceException;
import com.example.exception.CustomException;
import com.example.model.Appointment;
import com.example.model.PetDetails;
import com.example.model.Veterinarian;
import com.example.service.AppointmentService;
import com.example.service.PetDetailsService;
import com.example.service.VeterinarianService;


@Controller
public class AppointmentController {
	
	@Autowired
	AppointmentService appSer;
	
	/*
	 * @GetMapping("/getApp") public void message(@PathVariable(name = "id") int id)
	 * throws CustomException {
	 * 
	 * throw new CustomException();
	 * 
	 * }
	 */
	
	@GetMapping("/getApp/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") int id)
    {
        if(true) throw new AppointmentServiceException(" No appointment maps to this id, please check ! ");

       
            Appointment  app = appSer.get(id);
            if (app == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(app));
      
    }
}
