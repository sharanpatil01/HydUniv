package com.indg.univ.stud;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/student")
public class StudentService {

	@Autowired
	StudentUtil stUtil;

	private static String firstRestServiceURL = "";

	// i) http://localhost:8080/HydUniv/student/create/{studId}/{fn}/{ln}
	@RequestMapping(value = "/create/{studid}/{fn}/{ln}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student createStudentPost(@PathVariable("studid") String studid,
			@PathVariable("fn") String fn, @PathVariable("ln") String ln) {
		Student student = stUtil.createStudent(studid, fn, ln);
		return student;
	}

	// ii)http://localhost:8080/HydUniv/student/update/{studId}/{fn}/{ln}
	@RequestMapping(value = "/update/{studid}/{fn}/{ln}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudentPost(@PathVariable("studid") String studid,
			@PathVariable("fn") String fn, @PathVariable("ln") String ln) {
		Student student = stUtil.updateStudent(studid, fn, ln);
		return student;
	}

	// iii)http://localhost:8080/HydUniv/student/delete/{studId}
	@RequestMapping(value = "/delete/{studid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student deleteStudent(@PathVariable("studid") String studid) {
		Student student = stUtil.removeStudent(studid);
		return student;
	}

	// iv)http://localhost:8080/HydUniv/student/list
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Student> getStudents() {
		return stUtil.getStudents();
	}

	// v) http://localhost:8080/HydUniv/student/find/{studId}
	@RequestMapping(value = "/find/{studId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudent(@PathVariable(value = "studId") String studId) {
		// vi) /HydUniv/student/find/{regId}
		return stUtil.getStudent(studId);
	}

	// vi) http://localhost:9080/HydUniv/student/getdetails/{studid}
	@RequestMapping(value = "/getdetails/{studid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentsPastDetails(
			@PathVariable(value = "studid") String studid) {

		String url = "/goi/edu/student/find/";
		if (firstRestServiceURL.isEmpty() || firstRestServiceURL == null) {
			setFirstRestServiceURL("http://localhost:9080/GOIEducationDept");
		}
		String fullURL = firstRestServiceURL + url + studid;

		System.out.println("200: Before Calling HydUniv.StudentService.getStudDetails() method!!");
		RestTemplate restTemplate = new RestTemplate();
		Student stud = restTemplate.getForObject(fullURL, Student.class, 200);
		System.out.println("220: After Calling HydUniv.StudentService.getStudDetails() method!!");
		stud.setCitizenship("American");
		stud.setLastName(stud.getLastName() + " !!!!");
		return stud;

	}

	// http://localhost:8080/HydUniv/seturl?url=http://host:port/GOIEducationDept
	@RequestMapping(value = "/seturl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String setBaseURLForFirstRestService(@RequestParam(value = "url") String baseurl) {
		if (baseurl == null || baseurl.isEmpty()) {
			setFirstRestServiceURL("http://localhost:9080/GOIEducationDept");
		} else {
			setFirstRestServiceURL(baseurl);
		}
		return getFirstRestServiceURL();
	}

	// http://localhost:8080/HydUniv/seturl?url=http://host:port/GOIEducationDept
	@RequestMapping(value = "/geturl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getBaseURLForFirstRestService() {
		return getFirstRestServiceURL();
	}

	public static String getFirstRestServiceURL() {
		return firstRestServiceURL;
	}

	public static void setFirstRestServiceURL(String firstRestServiceURL) {
		StudentService.firstRestServiceURL = firstRestServiceURL;
	}

}
