package services;

import entities.Employee;

public class SalaryService {

	
	//FORMA ERRADA
	//TaxService taxService = new TaxService();
	//PensionService pensionService = new PensionService();
	
	
	// Inversão de controle - analogia da bateria e motor
	
	private TaxService taxService ;
	private PensionService pensionService;
	
	public SalaryService(TaxService taxService, PensionService pensionService) {
		this.taxService = taxService;
		this.pensionService = pensionService;
	}

	public double netSalary(Employee employee) {
		return employee.getGrossSalary() - 
				taxService.tax(employee.getGrossSalary()) - 
				pensionService.discount(employee.getGrossSalary());
	}
}
