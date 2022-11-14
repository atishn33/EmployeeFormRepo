package np.edu.persidential.dao.impl;

import np.edu.persidential.connectionfactory.ConnectionFactory;
import np.edu.persidential.dao.ContactDao;
import np.edu.persidential.model.Contact;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactDaoImpl implements ContactDao {

  private static PreparedStatement preparedStatement;

  private static ResultSet resultSet;

  private final ConnectionFactory connectionFactory;

  private Connection connection;

  public ContactDaoImpl(ConnectionFactory connectionFactory) {
    this.connectionFactory = connectionFactory;
  }

  /**
   * We're going to insert a new row into the contacts table, and we're going to set the first_name,
   * last_name, address, and phone_number columns to the values of the firstName, lastName, address,
   * and phoneNumber properties of the contact object that was passed into the function.
   *
   * @param contact The contact object that we want to save to the database.
   */
  @Override
  public void save(Contact contact) throws SQLException {
    final String QUERY =
        "INSERT INTO contacts (firstName, lastName, address, phoneNumber, Email, Post) VALUES (?,?,?,?,?,?)";
    connection = connectionFactory.getConnection();
    preparedStatement = connection.prepareStatement(QUERY);
    preparedStatement.setString(1, contact.getFirstName());
    preparedStatement.setString(2, contact.getLastName());
    preparedStatement.setString(3, contact.getAddress());
    preparedStatement.setLong(4, contact.getPhoneNumber());
    preparedStatement.setString(5, contact.getEmail());
    preparedStatement.setString(6, contact.getPost());
    preparedStatement.executeUpdate();
  }

  /**
   * It updates the contact with the given id with the given contact
   *
   * @param contact The contact object that we want to update.
   */
  @Override
  public void update(Contact contact) throws SQLException {
    final String QUERY =
        "UPDATE contacts set firstName = ?, lastName = ?, address = ?, phoneNumber = ?, Email = ?, Post = ? WHERE id = ?";
    connection = connectionFactory.getConnection();
    preparedStatement = connection.prepareStatement(QUERY);
    preparedStatement.setString(1, contact.getFirstName());
    preparedStatement.setString(2, contact.getLastName());
    preparedStatement.setString(3, contact.getAddress());
    preparedStatement.setLong(4, contact.getPhoneNumber());
    preparedStatement.setString(5, contact.getEmail());
    preparedStatement.setString(6, contact.getPost());
    preparedStatement.setInt(7, contact.getId());
    preparedStatement.executeUpdate();
  }

  /**
   * Delete a contact from the database by id.
   *
   * @param id The id of the contact to be deleted.
   */
  @Override
  public void delete(int id) throws SQLException {
    final String QUERY = "DELETE FROM contacts where id = ?";
    connection = connectionFactory.getConnection();
    preparedStatement = connection.prepareStatement(QUERY);
    preparedStatement.setInt(1, id);
    preparedStatement.executeUpdate();
  }

  /**
   * It creates a list of contacts, executes a query to get all the contacts from the database, and
   * then adds each contact to the list
   *
   * @return A list of contacts
   */
  @Override
  public List<Contact> findAll() throws SQLException {
    final List<Contact> contacts = new ArrayList<>();
    final String QUERY = "SELECT *FROM contacts";
    connection = connectionFactory.getConnection();
    resultSet = connection.prepareStatement(QUERY).executeQuery();
    while (resultSet.next()) {
      Contact contact = new Contact();
      contact.setId(resultSet.getInt("id"));
      contact.setFirstName(resultSet.getString("firstName"));
      contact.setLastName(resultSet.getString("lastName"));
      contact.setAddress(resultSet.getString("address"));
      contact.setPhoneNumber(resultSet.getLong("phoneNumber"));
      contact.setEmail(resultSet.getString("Email"));
      contact.setPost(resultSet.getString("Post"));
      contacts.add(contact);
    }
    return contacts;
  }

  /**
   * It takes an id as a parameter, creates a connection to the database, creates a prepared
   * statement, sets the id as a parameter, executes the query, and returns the result
   *
   * @param id The id of the contact you want to find.
   * @return A contact object.
   */
  @Override
  public Contact findOne(int id) throws SQLException {
    final String QUERY = "SELECT *FROM contacts where id = ?";
    connection = connectionFactory.getConnection();
    preparedStatement = connection.prepareStatement(QUERY);
    preparedStatement.setInt(1, id);
    resultSet = preparedStatement.executeQuery();
    Contact contact = new Contact();
    while (resultSet.next()) {
      contact.setId(resultSet.getInt("id"));
      contact.setFirstName(resultSet.getString("firstName"));
      contact.setLastName(resultSet.getString("lastName"));
      contact.setAddress(resultSet.getString("address"));
      contact.setPhoneNumber(resultSet.getLong("phoneNumber"));
      contact.setEmail(resultSet.getString("Email"));
      contact.setPost(resultSet.getString("Post"));
    }
    return contact;
  }
}
