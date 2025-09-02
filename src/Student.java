public class Student {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String dob; // "YYYY-MM-DD" format

    public Student() { }

    public Student(int id, String name, String email, String phone, String dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    public Student(String name, String email, String phone, String dob) {
        this(0, name, email, phone, dob);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', email='%s', phone='%s', dob=%s}",
                id, name, email, phone, dob);
    }
}
