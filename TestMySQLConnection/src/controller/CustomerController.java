package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Customer;

public class CustomerController {

	public static Customer GetCustomerByID(int customerID) throws SQLException {
		Connection connection;
		connection = utils.ConnectionUtils.getMyConnection();
		String sql = "select id, name, age, address, salary from customers where id = " + customerID;
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		if (rs.next()) {
			Customer customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
					rs.getString("address"), rs.getDouble("salary"));
			rs.close();
			statement.close();
			connection.close();
			return customer;
		} else {
			rs.close();
			statement.close();
			connection.close();
			return null;
		}

	}

	public static void AddNewCustomer(Customer customer) throws SQLException {
		Connection connection;
		connection = utils.ConnectionUtils.getMyConnection();
		String sql = "insert into customers(name, age, address, salary) values(" + "'" + customer.getName() + "'" + ","
				+ customer.getAge() + "," + "'" + customer.getAddress() + "'" + "," + customer.getSalary() + ")";
		Statement statement = connection.createStatement();
		int rowCount = statement.executeUpdate(sql);
		statement.close();
		connection.close();
	}

	public static void DeleteTheCustomer(int customerID) throws SQLException {
		Connection connection;
		connection = utils.ConnectionUtils.getMyConnection();
		String sql = "delete from customers where id = " + customerID;
		Statement statement = connection.createStatement();
		int rowCount = statement.executeUpdate(sql);
		statement.close();
		connection.close();
	}

	public static void UpdateTheCustomer(Customer customer, int customerID) throws SQLException {
		Connection connection;
		connection = utils.ConnectionUtils.getMyConnection();
		String sql = "update customers set name = '" + customer.getName() + "', age = " + customer.getAge()
				+ ", address = '" + customer.getAddress() + "', salary = " + customer.getSalary() + " where id = "
				+ customerID;
		Statement statement = connection.createStatement();
		int rowCount = statement.executeUpdate(sql);
		statement.close();
		connection.close();
	}

	public static ArrayList<Customer> FindCustomerByName(String name) throws SQLException {
		Connection connection;
		ArrayList<Customer> listCustomer = new ArrayList<>();
		String sql = "select id, name, age, address, salary from customers where name like '%" + name + "%'";
		connection = utils.ConnectionUtils.getMyConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Customer customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
					rs.getString("address"), rs.getDouble("salary"));
			listCustomer.add(customer);
		}
		statement.close();
		connection.close();
		return listCustomer;
	}

	public static ArrayList<Customer> getAllCustomer() throws SQLException {
		ArrayList<Customer> listCustomer = new ArrayList<>();
		String sql = "select id, name, age, address, salary from customers";
		Connection connection;
		connection = utils.ConnectionUtils.getMyConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Customer customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
					rs.getString("address"), rs.getDouble("salary"));
			listCustomer.add(customer);
		}
		rs.close();
		statement.close();
		connection.close();
		return listCustomer;
	}

}
