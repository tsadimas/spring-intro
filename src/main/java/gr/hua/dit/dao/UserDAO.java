package gr.hua.dit.dao;

import java.util.List;
import gr.hua.dit.models.User;

//CRUD operations
public interface UserDAO {
   
  //Create
  public void save(User user);
  //Read
  public User getById(int id);
  //Update
  public void update(User user);
  //Delete
  public void deleteById(int id);
  //Get Allφ
  public List<User> getAll();
}
