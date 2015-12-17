package LEMS.data.orderdata;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LEMS.data.Connect;
import LEMS.dataservice.orderdataservice.IdDataService;

public class CreateID implements IdDataService {

	private Connect connect;
	
	public CreateID(){
		connect = new Connect();
	}
	@Override
	public ArrayList<String> findAll(String table, String pre) {

		ArrayList<String> orders = new ArrayList<String>();

		String sql = "SELECT * FROM " + table;

		ResultSet result = connect.getResultSet(sql);
		
		try {
			while (result.next()) {
				if (result.getString(1).substring(0, pre.length()).equals(pre)) {
					orders.add(result.getString(1));
				}
			}
			
			connect.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public String createID(String table, int length, String pre) {
		String id = "";

		ArrayList<String> orders = this.findAll(table, pre);
		
		for (String string : orders) {
			if (string.compareTo(id) > 0) {
				id = string;
			}
		}
		
		if (orders.isEmpty()) {
			id = pre;
			while (id.length() != length) {
				id += "0";
			}
		}
		
		//id+1
		BigInteger temp = new BigInteger(id);
		temp = temp.add(new BigInteger("1"));
		
		if (id.charAt(0) == '0') {
			id = "0" + temp.toString();
		} else {
			id = temp.toString();
		}

		return id;
	}
	public static void main(String[] args){
		CreateID i=new CreateID();
		System.out.println(i.createID("arrivalnote", 20,"025010120151208"));
		
	}
}
