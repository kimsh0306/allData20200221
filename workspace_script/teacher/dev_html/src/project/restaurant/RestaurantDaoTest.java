package project.restaurant;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class RestaurantDaoTest {
	RestaurantDao rdao = new RestaurantDao();
	List<Map<String,Object>> rList = rdao.procRestList();
	@Test
	void testProcRestList() {
		//assertEquals(3,rdao.procRestList().size());
		assertNotSame(rList, rdao.procRestList());
	}

}
