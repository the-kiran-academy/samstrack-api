import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

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
import com.ram.samstrack.service.branch.Branch_Service;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SamsTrackApiApplication.class)
@SpringBootTest
public class BranchTestController {
	
	@Autowired
	private Branch_Service branch_Service;
	
	@Test
	public void testAddBranch() {
		
		Serializable savedBId=branch_Service.addBranch(getBranch());
		//int id=(int) savedBId;
		assertThat(savedBId);

	}
	@Test
	public void testGetAllBranch() {
		List<Branch> list = branch_Service.getAllBranch();
		assertFalse(list.isEmpty());
	}
	
	public Branch getBranch() {
		Branch branch=new Branch();
		branch.setBranch_Code(1013l);
		branch.setBranch_Name("Mech Engg");
		
		return branch;
	}

}
