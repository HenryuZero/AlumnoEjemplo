package lazydragon.inscalum;

import alumDTO.alumDTO;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LeerAlumnos {
    public static void main (String[] args){
        boolean ban=false;
        alumDTO stud;
        ArrayList<alumDTO> studs = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el numero de alumnos que inscribira: ");
        int count = in.nextInt();
        String text =in.nextLine();
        
        for (int i=0;i<count;i++){
            stud = new alumDTO();
            do{
            System.out.println("Nombre: ");
            stud.setName(in.nextLine());
            } while(!validarLetras(stud.getName()));
            
            do{
            //try{
            System.out.println("Sexo (M,F): ");
            stud.setSex(in.next().charAt(0));
            in.nextLine();
            //}catch(InputMismatchException e){
              //  System.out.println("Valor no valido"); in.nextLine();}
            }while(stud.getSex()!='M' && stud.getSex()!='F');
            
            //Edad 6-11, primar grado a sexto
            do{
            try{
             System.out.println("Edad: ");
             stud.setEdad(in.nextByte());
             in.nextLine();            
             switch(stud.getEdad()){
                case 6: stud.setCurs("Primer Grado");ban=true; break;
                case 7: stud.setCurs("Segundo Grado");ban=true; break;
                case 8: stud.setCurs("Tercer Grado");ban=true; break;
                case 9: stud.setCurs("Cuarto Grado");ban=true; break;
                case 10: stud.setCurs("Quinto Grado");ban=true; break;
                case 11: stud.setCurs("Sexto Grado");ban=true; break;
                
                default: System.out.println("Edad no permitida"); break;
             }
             }catch(InputMismatchException e){
                 System.out.println("Valor no valido"); in.nextLine(); }
            }while(ban==false);
            
            do{
            System.out.println("Ciudad: ");
            stud.setCity(in.nextLine());
            } while(!validarLetras(stud.getCity()));
            
            do{
            System.out.println("Fecha de Nacimiento (DD-MM-AAAA): ");
            stud.setbDate(in.nextLine());
            }while(!validarFecha(stud.getbDate()));
            
            do{
                try{
             System.out.println("Promedio: ");
             stud.setProm(in.nextDouble());
            //if (prom>0 && prom<5.9) estado= pendiente;
            // 6<prom<6.9// 7<prom<8.9// 9<prom<10
            //if ((stud.getProm()>0) || (stud.getProm()<10)){
             if ((stud.getProm()>=0) && (stud.getProm()<6)){
              stud.setStatus("... En proceso...");
             }   
             if ((stud.getProm()>=6) && (stud.getProm()<7)){
                 stud.setCroom('C');
                 stud.setStatus("Inscrito");
                 ban=true;
             }
             if ((stud.getProm()>=7) && (stud.getProm()<9)){
                 stud.setCroom('B');
                 stud.setStatus("Inscrito");
                 ban=true;
             }
             if ((stud.getProm()>=9) && (stud.getProm()<=10)){
                 stud.setCroom('A');
                 stud.setStatus("Inscrito");
                 ban=true;
             }
            }catch(InputMismatchException e){
                 System.out.println("Valor no valido"); in.nextLine();ban=false;}
            //}while((stud.getProm()<0) || (stud.getProm()>10));
            }while(ban==false);
            
            in.nextLine();
            studs.add(stud);
        }
        studs.forEach(studenDTO -> {
            //System.out.println(studenDTO);
            System.out.println("===============================");
            System.out.println("Nombre: "+ studenDTO.getName());
            System.out.println("Sexo: "+ studenDTO.getSex());
            System.out.println("Edad: "+ studenDTO.getEdad());
            System.out.println("Ciudad: "+ studenDTO.getCity());
            System.out.println("Fecha de Nacimiento: "+ studenDTO.getbDate());
            System.out.println("Promedio: "+ studenDTO.getProm());
            System.out.println("Curso: "+ studenDTO.getCurs());
            System.out.println("Salon: "+ studenDTO.getCroom());
            System.out.println("Estado: "+ studenDTO.getStatus());
            
            System.out.println("===============================");
        });
    }
    
    public static boolean validarFecha(String fecha) {
    return fecha.matches("[0-9]{2}-"+"[0-9]{2}-"+"[0-9]{4}");
  }
    public static boolean validarLetras(String datos) {
    return datos.matches("[a-zA-Z\\s]*");
  }
    /*public static boolean validarGenero(Character gen){
     return if (gen)
    }*/
    
    /*public static boolean validarPromedio(double promedio){
     return promedio>0 ? true : false ;
    }*/
}
