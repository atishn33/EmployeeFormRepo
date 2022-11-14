package np.edu.persidential.model;

public class Contact {

  private int id;

  private String firstName;

  private String lastName;

  private String address;

  private Long phoneNumber;

  private String Email;

  private String Post;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public Long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() { return Email; }

  public void setEmail(String Email) { this.Email = Email; }

  public String getPost() { return Post; }

  public void setPost(String Post) { this.Post = Post; }

}
