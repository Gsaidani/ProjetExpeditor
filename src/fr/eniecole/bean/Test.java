package fr.eniecole.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import fr.eniecole.dal.EmployeDAO;

public class Test {

	public static void main(String[] args) {
		EmployeDAO dao = new EmployeDAO();
		ArrayList<Employe> liste = new ArrayList<>();
		
		try {
			System.out.println(dao.lister());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
