package gr.hua.dit.dao;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import gr.hua.dit.models.User;

//CRUD operations
public interface UserDAO {

	// Create
	public void save(User user);

	// Read
	public User getById(int id);

	public User getByName(String name);
	// Update

	public void update(User user);

	// Delete
	public boolean deleteById(int id);

	// Get All
	public List<User> getAll();
}
