package alumDTO;

public class alumDTO {
    private String name;
    private Character sex;
    private Byte edad;
    private String city;
    private String bDate;
    private Double prom;
    private String curs;
    private Character croom;
    private String Status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Byte getEdad() {
        return edad;
    }

    public void setEdad(Byte edad) {
        this.edad = edad;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public Double getProm() {
        return prom;
    }

    public void setProm(Double prom) {
        this.prom = prom;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    public Character getCroom() {
        return croom;
    }

    public void setCroom(Character croom) {
        this.croom = croom;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "\n Nombre=" + name + "\n Sexo=" + sex + "\n Edad=" + edad + "\n Ciudad=" + city + "\n FechaNacimiento=" + bDate + "\n Promedio=" + prom + "\n Curso=" + curs + "\n Salon=" + croom + "\n Estado=" + Status ;
    }
    
}
