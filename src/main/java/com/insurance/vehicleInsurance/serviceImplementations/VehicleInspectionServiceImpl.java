package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.VehicleInspectionRepository;
import com.insurance.vehicleInsurance.dao.VehicleRepository;
import com.insurance.vehicleInsurance.entity.Vehicle;
import com.insurance.vehicleInsurance.entity.VehicleInspection;
import com.insurance.vehicleInsurance.exception.VehicleInspectionException;
import com.insurance.vehicleInsurance.service.VehicleInspectionService;

@Service
public class VehicleInspectionServiceImpl implements VehicleInspectionService{

	@Autowired
	VehicleInspectionRepository vehicleInspectionRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public VehicleInspection addInspection(VehicleInspection newInspection) throws VehicleInspectionException {
		Optional<Vehicle> vehicleOpt = this.vehicleRepository.findById(newInspection.getVehicleId());
		if(!vehicleOpt.isPresent()) {
			throw new VehicleInspectionException("Vehicle for that id does not exist.");
		}
		this.vehicleInspectionRepository.save(newInspection);
		Vehicle vehicle = vehicleOpt.get();
		List<VehicleInspection> vehicleInspections = new ArrayList<VehicleInspection>();
		vehicleInspections.add(newInspection);
		vehicle.setVehicleInspections(vehicleInspections);
		this.vehicleRepository.save(vehicle);
	    return newInspection;
	}

	@Override
	public VehicleInspection getInspectionById(Integer id) throws VehicleInspectionException {
		Optional<VehicleInspection> vehicleInspectionOpt = this.vehicleInspectionRepository.findById(id);
		if(vehicleInspectionOpt==null) {
			throw new VehicleInspectionException("Vehicle Inspection not found for id: "+id);
		}
		return vehicleInspectionOpt.get();
	}

//	@Override
//	public VehicleInspection updateInspection(VehicleInspection newInspection) throws VehicleInspectionException {
//		if(newInspection == null) {
//			throw new VehicleInspectionException("please enter valid values.");
//		}
//		return this.vehicleInspectionRepository.save(newInspection);
//	}

//	@Override
//	public VehicleInspection deleteInspectionById(Integer id) throws VehicleInspectionException {
//		Optional<VehicleInspection> vehicleInspectionOpt = this.vehicleInspectionRepository.findById(id);
//		if(vehicleInspectionOpt==null) {
//			throw new VehicleInspectionException("Vehicle Inspection not found to delete for id: "+id);
//		}
//		VehicleInspection vehicleInspection = vehicleInspectionOpt.get();
//		this.vehicleInspectionRepository.delete(vehicleInspection);
//		return vehicleInspection;
//	}

	@Override
	public List<VehicleInspection> getAllInspections() {
		return this.vehicleInspectionRepository.findAll();
	}

}
