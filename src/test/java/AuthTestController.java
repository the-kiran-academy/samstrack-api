

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ram.samstrack.SamsTrackApiApplication;

import com.ram.samstrack.model.Branch;
import com.ram.samstrack.model.User;
import com.ram.samstrack.service.auth.Auth_Service;
import com.ram.samstrack.service.branch.Branch_Service;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes=SamsTrackApiApplication.class)
@SpringBootTest

public class AuthTestController {

	@Autowired
	private Auth_Service auth_Service;
	
	@Autowired
	private Branch_Service branch_Service;
	
	@Test
	public void testLogin() {
		User user=getUser();
		String u;
		User logedInUser=auth_Service.login(user);
		if(logedInUser==null)
			u="not logedin";
		else
			u="loggedin";
		assertEquals("loggedin", u);
	}
	
	@Test
	public void testLoginWrongData() {
		User user=getUser();
		user.setUsername("xyz");
		User logedInUser=auth_Service.login(user);
		assertFalse("Login Failed Check username password", logedInUser==null);
	}
	
	@Test
	public void getAllBranch() {
		List<Branch> branches=branch_Service.getAllBranch();
		String branch = null;
		if(!branches.isEmpty())
			 branch="found";
		else
			branch="not found";
		assertEquals("found", branch);
	}
	
	private User getUser() {
		
		
		User user=new User();
		user.setUsername("ram");
		user.setPassword("ram123");
		return user;
	}
}
