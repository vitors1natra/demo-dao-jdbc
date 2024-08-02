package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model_entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmenteDao();

		System.out.println("\n=== Test 1: departmente findById ====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== Test 2: departmente findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n=== Test 3: departmente insert ====");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
		
		System.out.println("\n=== Test 4: departmente update ====");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("FOOD");
		departmentDao.update(dep2);
		System.err.println("Update completed");
		
		
		System.out.println("\n=== Test 5: departmente delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
