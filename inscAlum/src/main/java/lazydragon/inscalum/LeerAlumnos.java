package lazydragon.inscalum;

import alumDTO.alumDTO;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LeerAlumnos {
    static alumDTO Student;
    static Scanner in = new Scanner(System.in);
    static int count=0;
    public static void main (String[] args) throws ParseException{
        
        ArrayList<alumDTO> Students = new ArrayList<>();
               
        ingreso();
        in.nextLine();
        
        for (int i=0;i<count;i++){
            Student = new alumDTO();
            
            setNombre();
            setSexo();            
            setNacimiento(); 
            setCiudad();
            setPromedio();
                        
            in.nextLine();
            Students.add(Student);
        }
        printStudents(Students);
        
    }
   
    public static void ingreso(){
        try{
        System.out.println("Ingrese el numero de alumnos que inscribira: ");
        count = in.nextInt();
        }catch(InputMismatchException e){
                 System.out.println("Valor no valido"); in.nextLine(); }
        finally{
            //System.out.println(count);
            if (count<=0){
             ingreso();
            }
        } 
    }
    
    public static void setNombre(){
     do{
         System.out.println("Nombre: ");
         Student.setName(in.nextLine());   
     }while (!Student.getName().matches("[a-zA-Z\\s]*"));
    }
    
    public static void setSexo(){
     do{
            System.out.println("Sexo (M,F): ");
            Student.setSex(in.next().charAt(0));
            in.nextLine();
     }while(Student.getSex()!='M' && Student.getSex()!='F');
    }
    
    public static void setCiudad(){
     do{
         System.out.println("Ciudad: ");
         Student.setCity(in.nextLine());   
     }while (!Student.getCity().matches("[a-zA-Z\\s]*"));
    }
    
    public static void setNacimiento(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
        LocalDate ahora = LocalDate.now();
        System.out.println("Fecha de Nacimiento (DD-MM-AAAA): ");
        String dBirth = in.nextLine();
        if (dBirth.matches("[0-9]{2}-"+"[0-9]{2}-"+"[0-9]{4}")){
            Student.setbDate(dBirth);
            LocalDate fechaComp = LocalDate.parse(Student.getbDate(),formato);
            Period periodo = Period.between(fechaComp, ahora);
            //System.out.printf("Tu edad es: %s años \n", periodo.getYears());
            Student.setEdad((byte)periodo.getYears());
            switch(Student.getEdad()){
                case 6: Student.setCurs("Primer Grado"); break;
                case 7: Student.setCurs("Segundo Grado"); break;
                case 8: Student.setCurs("Tercer Grado"); break;
                case 9: Student.setCurs("Cuarto Grado"); break;
                case 10: Student.setCurs("Quinto Grado"); break;
                case 11: Student.setCurs("Sexto Grado"); break;
                
                default: System.out.println("Edad no permitida"); setNacimiento(); break;
            }
        }
        else{
            System.out.println("Formato de fecha no permitida");
            setNacimiento();
        }
    }
    
    public static void setPromedio(){
     try{
     System.out.println("Promedio: ");
     Student.setProm(in.nextDouble());
     if ((Student.getProm()>=0) && (Student.getProm()<=10)){
             if ((Student.getProm()>=0) && (Student.getProm()<6)){
              Student.setStatus("... En proceso...");
             }   
             if ((Student.getProm()>=6) && (Student.getProm()<7)){
                 Student.setCroom('C');
                 Student.setStatus("Inscrito");
             }
             if ((Student.getProm()>=7) && (Student.getProm()<9)){
                 Student.setCroom('B');
                 Student.setStatus("Inscrito");
             }
             if ((Student.getProm()>=9) && (Student.getProm()<=10)){
                 Student.setCroom('A');
                 Student.setStatus("Inscrito");
            }
     }
     else{System.out.println("Valor no valido");setPromedio();}    
        }catch(InputMismatchException e){
                 System.out.println("Valor no valido"); in.nextLine();}
     finally{
         //System.out.println(Student.getProm());
         if (Student.getProm()==null){
             System.out.println("Favor de escribir valores validos entre 0 a 10");
          setPromedio();
         }
     }
    }

    public static void printStudents(ArrayList<alumDTO> Students){
        Students.forEach(studenDTO -> {
            System.out.println("===============================");
            System.out.println(studenDTO);          
            System.out.println("===============================");
        });
    }
}
