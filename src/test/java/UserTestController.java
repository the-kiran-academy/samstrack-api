
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;
import java.util.List;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ram.samstrack.SamsTrackApiApplication;

import com.ram.samstrack.model.Branch;
import com.ram.samstrack.model.User;

import com.ram.samstrack.service.user.User_Service;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SamsTrackApiApplication.class)
@SpringBootTest

public class UserTestController {

	@Autowired
	private User_Service user_Service;

	//@Test
	public void testAddUser() {
		User user = getUser();

		Serializable savedUser = user_Service.addUser(user);
		int id = (int) savedUser;

		User getFromDb = user_Service.getUser(id);
		assertThat(getFromDb.getUser_Id()).isEqualTo(id);

	}

	@Test
	public void testGetAllUser() {
		List<User> list = user_Service.getAllUser();
		assertFalse(list.isEmpty());
	}

	@Test
	public void testGetUser() {
		User user = user_Service.getUser(452);
		assertFalse(user == null);
	}

	@Test
	public void testUpdateUser() {

		User user = getUser();
		user.setUser_Id(502);
		user.setPassword("zxcvbnm");
		String status = user_Service.updateUser(user);
		assertEquals("updated", status);

	}

	@Test
	public void testDeleteUser() {

		User user = getUser();
		user.setUser_Id(502);
		
		boolean b=user_Service.deleteUser(2);
		assertEquals(true, b);

	}

	
	private User getUser() {

		Branch branch = new Branch();
		branch.setBranch_Id(1);

		User user = new User();
		
		user.setAnswer("ramtest21");
		user.setBranch(branch);
		user.setMail("ram@gmail.com");
		user.setQuestion("what is your nick name ?");
		user.setUser_Type("Teacher");
		user.setUsername("ram");
		user.setPassword("ram123");
		return user;
	}
}
