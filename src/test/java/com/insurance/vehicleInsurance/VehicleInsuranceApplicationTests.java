package com.insurance.vehicleInsurance;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest; 
import com.insurance.vehicleInsurance.dao.ClaimRepository;
import com.insurance.vehicleInsurance.dao.DocumentsRepository;
import com.insurance.vehicleInsurance.dao.InsuranceRepository;
import com.insurance.vehicleInsurance.dao.PaymentRepository;
import com.insurance.vehicleInsurance.dao.VehicleRepository;
import com.insurance.vehicleInsurance.dto.VehicleDto;
import com.insurance.vehicleInsurance.entity.Claim;
import com.insurance.vehicleInsurance.entity.Documents;
import com.insurance.vehicleInsurance.entity.Insurance;
import com.insurance.vehicleInsurance.entity.Payment;
import com.insurance.vehicleInsurance.entity.Vehicle;
import com.insurance.vehicleInsurance.exception.ClaimException;
import com.insurance.vehicleInsurance.exception.DocumentException;
import com.insurance.vehicleInsurance.exception.InsuranceException;
import com.insurance.vehicleInsurance.exception.PaymentException;
import com.insurance.vehicleInsurance.exception.VehicleException;
import com.insurance.vehicleInsurance.service.ClaimService;
import com.insurance.vehicleInsurance.service.DocumentService;
import com.insurance.vehicleInsurance.service.PaymentService;
import com.insurance.vehicleInsurance.service.VehicleService;

@SpringBootTest
class VehicleInsuranceApplicationTests {

	@Autowired
    private ClaimService ClaimService;

    @Autowired
    private ClaimRepository ClaimRepository;

	@Autowired
	private DocumentService documentService;

	@Autowired
	private DocumentsRepository documentsRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private InsuranceRepository insuranceRepository;

	@Autowired
	private PaymentService paymentService;
	
	@Autowired 
	private PaymentRepository paymentRepository;

	@Test
	public void testCreateClaim() throws ClaimException {

		Claim sampleClaim = new Claim();
		sampleClaim.setClaimAmount("2000");
		String dateString = "2023-05-03";
        LocalDate localDate = LocalDate.parse(dateString);
		sampleClaim.setClaimDate(localDate);
		sampleClaim.setClaimDescription("Accident");
		sampleClaim.setClaimId(1);
		sampleClaim.setClaimStatus("Pending");
		sampleClaim.setEndUserId(2);;
		sampleClaim.setInsuranceId(3);

		Claim createdClaim = ClaimService.addClaim(sampleClaim);
		
		// Assert that the createdClaim is not null
        assertNotNull(createdClaim);

		Claim retrievedClaim = ClaimRepository.findById(createdClaim.getClaimId()).orElse(null);
        assertNotNull(retrievedClaim);
	}


    @Test
    public void testAddDocument() throws DocumentException {

        Documents sampleDocument = new Documents();
        sampleDocument.setDocumentDescription("E-Aadhar");
        sampleDocument.setDocumentId(123);
        sampleDocument.setDocumentNumber("12345678");
        sampleDocument.setDocumentType("Aadhar Card");
        sampleDocument.setEndUserId(2);
        Documents addedDocument = documentService.addDocument(sampleDocument);
        assertNotNull(addedDocument);
        Documents retrivedDocuments = documentsRepository.findById(addedDocument.getDocumentId()).orElse(null); 
		assertNotNull(retrivedDocuments);
    }

	@Test
	public void testAddVehicle() throws VehicleException{

		VehicleDto sampleVehicle = new VehicleDto ();

		sampleVehicle.setVehicleName("Aura");
		sampleVehicle.setVehicleRegNumber("1234");
		sampleVehicle.setVehicleType("Sedan");
		sampleVehicle.setEndUserId(6);
		Vehicle addedVehicle = vehicleService.addVehicle(sampleVehicle);
		assertNotNull(addedVehicle);
		Vehicle retrivedVehicle = vehicleRepository.findByVehicleRegNumber(addedVehicle.getVehicleRegNumber()).orElse(null);
		assertNotNull(retrivedVehicle);
	}

	@Test
	public void testAddInsurance() throws InsuranceException{

		Insurance sampleInsurance = new Insurance();
		
		sampleInsurance.setInsuranceId(null);
	}

	@Test
	public void testAddPayment() throws PaymentException{

		Payment samplePayment = new Payment();
		
		samplePayment.setAmount(2000.0);
		String dateString = "2023-05-03";
        LocalDate localDate = LocalDate.parse(dateString);
		samplePayment.setDate(localDate);
		samplePayment.setDescription("online payment");
		samplePayment.setEndUserId(2);
		samplePayment.setId(6);
		samplePayment.setInsuranceId(3);
		Payment createdPayment = paymentService.createPaymentByInsuranceId(samplePayment);
		assertNotNull(createdPayment);
		Payment retrivedPayment = paymentRepository.findById(createdPayment.getInsuranceId()).orElse(null);
		assertNotNull(retrivedPayment);
		
	}
}
