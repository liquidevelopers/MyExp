package com.yaniv.appsserver.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yaniv.appsserver.entity.Employee;
import com.yaniv.appsserver.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/api/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeService.retrieveEmployees();
		return employees;
	}

	@GetMapping("/api/employees/{employeeId}")
	public Employee getEmployee(
			@PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@PostMapping("/api/employees")
	public void saveEmployee(Employee employee) {
		SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
		//Setting the time zone
		dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
		employee.setDepartment(dateTimeInGMT.format(new Date()).toString());
		employeeService.saveEmployee(employee);
		
		try {
			   String androidFcmKey="AAAAHI-wgqU:APA91bE1wPx7AWDcVhMShZp131fRLf_fEPWevtwkIJaU7iWrVuDvCZSrS9PFOIIpLFTV_Io92V7wYonyp6a5tsgQ8uZH2V2Z4ImJ_LfrLDC-nei-omiq8VpoqmmooPB194rIM9dM-qDa";
			   String androidFcmUrl="https://fcm.googleapis.com/fcm/send";

			   RestTemplate restTemplate = new RestTemplate();
			   HttpHeaders httpHeaders = new HttpHeaders();
			   httpHeaders.set("Authorization", "key=" + androidFcmKey);
			   httpHeaders.set("Content-Type", "application/json");
			   JSONObject msg = new JSONObject();
			   JSONObject json = new JSONObject();

			   msg.put("title", "Incoming Call..");
			   msg.put("body", employee.getSalary());

			   json.put("data", msg);
			   json.put("to", "fnxQfA7XjjE:APA91bEdkK_OgxapWzZWHfUAFR4QoDVAMezE3_c9KkBwa_M4FhqvjeMMB3XgFdhFn-9but5BAHbqAzbbMjzSN7SsFq0KA9Cab9IDpzIEc3Moos63_SMaMf5uSZhZifeVBBaCuRKqvuIl");

			   HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(),httpHeaders);
			   String response = restTemplate.postForObject(androidFcmUrl,httpEntity,String.class);
			   System.out.println(httpEntity.toString());
			   System.out.println(response);
			} catch (JSONException e) {
			   e.printStackTrace();
			}
		System.out.println("Employee Saved Successfully");
	}

	@DeleteMapping("/api/employees/{employeeId}")
	public void deleteEmployee(
			@PathVariable(name = "employeeId") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		System.out.println("Employee Deleted Successfully");
	}

	@PutMapping("/api/employees/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee,
			@PathVariable(name = "employeeId") Long employeeId) {
		Employee emp = employeeService.getEmployee(employeeId);
		if (emp != null) {
			employeeService.updateEmployee(employee);
		}

	}
	@Scheduled(cron = "0 0 * * * ?")
	public void deleteEmployee() {
		List<Employee> allemployees = employeeService.retrieveEmployees();
		for(Employee emp : allemployees){
			employeeService.deleteEmployee(emp.getId());
		}
		System.out.println("All Employees Deleted Successfully");
	}

}