package biblioteca;

import java.sql.*;

public class directorio extends libro{
    libro info = new libro();//espacio para 10 Libros
    libro prestamo = new libro();
    int entradas = 0;
    String PalabraClave;
    int seleccion;
    String seleccionc;
    
     String user = "rra_moviles";//db4free
     String password = "1036moviles";//db4free.net
     String url = "jdbc:mysql://db4free.net/contactosrra";
     String nombre, apellido, tel;
     Connection con;
     ResultSet resultado; 
     

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    public String getPalabraClave() {
        return PalabraClave;
    }

    public void setPalabraClave(String PalabraClave) {
        this.PalabraClave = PalabraClave;
    }
    
    public void conectar(){
        
        try{
            //Prueba de conexion
            System.out.println("Conectando a base de datos...");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            System.out.println("Conexión exitosa...");
        } catch (SQLException ex) {
            System.out.println("Error de mysql");
        } catch (Exception e) {
            System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
        }
    }
    
    
     public void IngresarLibroNuevo(){
         
        try{
            Statement estado = con.createStatement();
            
         //Insertar un contacto
            System.out.println("REGISTRO DE NUEVO LIBRO");
            System.out.println("Nombre: ");
            info.nombre = teclado.next();
            System.out.println("Autor: ");
            info.autor = teclado.next();
            System.out.println("Año de publicacion; ");
            info.AñoDePublicacion = teclado.nextInt();
            System.out.println("Código: ");
            info.codigo = teclado.next();
            System.out.println("Cantidad: ");
            info.cantidad = teclado.nextInt();
            Menu4();
            info.area = seleccionc;
            entradas++;
            estado.executeUpdate("INSERT INTO `libro` VALUES ('"+info.nombre+"', '"+info.autor+"', '"+info.AñoDePublicacion+"', '"+info.AñoDePublicacion+"', '"+info.codigo+"', '"+info.cantidad+"', '"+info.area+"' )");
                       
        } catch (SQLException ex) {
            System.out.println("Error de mysql");
        } catch (Exception e) {
            System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
        }  
    }
     
     
        public void ActualizarLibro(){
            int id;
            
            System.out.println("ACTUALIZAR LIBRO");
            id=buscar();
            if(id!=1){
            System.out.println("No encontrado");
            }
            else{
                try{
                Statement estado = con.createStatement();
                
                System.out.println("Nombre: ");     
                info.nombre = teclado.next();
                System.out.println("Autor: ");
                info.autor = teclado.next();
                System.out.println("Año de publicacion; ");
                info.AñoDePublicacion = teclado.nextInt();
                System.out.println("Código: ");
                info.codigo = teclado.next();
                System.out.println("Cantidad: ");
                info.cantidad = teclado.nextInt();
                System.out.println("Area: ");
                info.area = teclado.next();
                
                estado.executeUpdate("INSERT INTO `libro` VALUES ('"+info.nombre+"', '"+info.autor+"', '"+info.AñoDePublicacion+"', '"+info.AñoDePublicacion+"', '"+info.codigo+"', '"+info.cantidad+"', '"+info.area+"' )");
                } catch (SQLException ex) {
                System.out.println("Error de mysql");
                } catch (Exception e) {
                System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
                }
            }
                
    }
               
        public int buscar (){
            int indice=0;
            
            try{
            Statement estado = con.createStatement();
            System.out.println("Ingrese Palabra Clace");
            PalabraClave = teclado.next();
            
            //Buscar por nombre
            resultado = estado.executeQuery("SELECT * FROM `libro` WHERE `nombre` LIKE '"+PalabraClave+"'");
            while (resultado.next()){
                indice=1;
            }
            } catch (SQLException ex) {
            System.out.println("Error de mysql");
            } catch (Exception e) {
            System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
            }  
            
             return indice;
        }
        
        public void ImprimirInfo(){
            int id;
            id=buscar();
            if(id!=1){
            System.out.println("No encontrado");
            }
            else{
                try{
                Statement estado = con.createStatement();
                while (resultado.next()){
                System.out.println(resultado.getString("nombre") +"\t"+ resultado.getString("autor")
                        +"\t"+ resultado.getInt("año de publicacion") +"\t"+ resultado.getString("código")
                +"\t"+ resultado.getInt("cantidad") +"\t"+ resultado.getString("area"));
                }
                } catch (SQLException ex) {
                System.out.println("Error de mysql");
                } catch (Exception e) {
                System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
                }  
            }
        }
                
        public void Borrar(){
            int id;
            id=buscar();
            if(id!=1){}
            else{
            try{
            Statement estado = con.createStatement();  
            
            //Delete o eliminar dato
            estado.executeUpdate("DELETE FROM `libro` WHERE `nombre` LIKE '"+PalabraClave+"'");
            resultado = estado.executeQuery("SELECT * FROM `clientes`");
            System.out.println(resultado.getString("nombre") +"\t"+ resultado.getString("autor")
                        +"\t"+ resultado.getInt("año de publicacion") +"\t"+ resultado.getString("código")
                +"\t"+ resultado.getInt("cantidad") +"\t"+ resultado.getString("area"));
            } catch (SQLException ex) {
                System.out.println("Error de mysql");
            } catch (Exception e) {
                System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
            }  
     
            }
        }
        
        public void Menu1(){
            info = new directorio();
            System.out.println("Seleccione la accion a realizar");
            System.out.println("1. Ajustes Datos Libros");
            System.out.println("2. Prestamos");
            seleccion = teclado.nextInt();
                       
        }
        
        public void Menu2(){
            System.out.println("Seleccione la accion a realizar");
            System.out.println("1. Ingresar Libro");
            System.out.println("2. Actualizar Libro");
            System.out.println("3. Eliminar Libro");
            System.out.println("4. Buscar Libro");
            seleccion = teclado.nextInt();
                       
        }
        
        public void Menu3(){
            System.out.println("Seleccione la accion a realizar");
            System.out.println("1. Prestar Libro");
            System.out.println("2. Devolver Libro");
            System.out.println("3. Libros prestados");
            seleccion = teclado.nextInt();                       
        }
        
        public void Menu4(){
            System.out.println("eliga el numero de la asignatura");
            System.out.println("1. Química");
            System.out.println("2. Física");
            System.out.println("3. Tecnologia");
            System.out.println("4. Cálculo");
            System.out.println("5. Programación");
            seleccion = teclado.nextInt();                       
        }
        
        public void Prestamos(){
            int id;
            id=buscar();
            if(id!=1){
                System.out.println("No encontrado");
            }
            else{
                try{
                System.out.println("Ingrese cedula");
                seleccion = teclado.nextInt();
                Statement estado = con.createStatement();
                
                resultado = estado.executeQuery("SELECT * FROM `libro` WHERE `nombre` LIKE '"+PalabraClave+"'");
                
                
                    if(resultado.getInt("cantidad")==0){
                        System.out.println("No hay mas de este libro");
                    }
                    else{
                        info.cantidad=resultado.getInt("cantidad");
                        info.cantidad= info.cantidad-1;
                        prestamo.cedula = seleccion;
                        prestamo.nombre = resultado.getString("nombre");
                        prestamo.cantidad = prestamo.cantidad+1;
                         estado.executeUpdate("INSERT INTO `libro` VALUES ('"+prestamo.cedula+"', '"+prestamo.nombre+"', '"+prestamo.cantidad+"' )");
                    }
                } catch (SQLException ex) {
                System.out.println("Error de mysql");
                } catch (Exception e) {
                System.out.println("Se ha encontrado un error de tipo: "
                    + e.getMessage());
                }  
                
            }
        }
        
        public void Devolver(){
            int id;
            id=buscar();
            if(id==-1){
                System.out.println("No encontrado");
            }
            else{
                info.cantidad= info[id].cantidad+1;
                prestamo.cantidad = prestamo[id].cantidad-1;
            }
        }
        
        public void LibrosPrestados(){
            for(int i=0; i<10;i++){
                if(prestamo[i].cantidad==0){
                    
                }
                else{
                System.out.println("Nombre: "+prestamo[i].nombre);
                System.out.println("Autor: "+prestamo[i].autor);
                System.out.println("Año de publicacion; "+prestamo[i].AñoDePublicacion);
                System.out.println("Código: "+prestamo[i].codigo);
                System.out.println("Cantidad: "+prestamo[i].cantidad);
                System.out.println("Area: "+prestamo[i].area);
                System.out.println();
                }
            }
        }
        
        public void Llenar(){
            for(int i=0; i<10;i++){
                prestamo[i] = new directorio();
                prestamo[i].nombre = "null";
                prestamo[i].autor = "null";
                prestamo[i].AñoDePublicacion = 0;
                prestamo[i].codigo = "null";
                prestamo[i].cantidad = 0;
                prestamo[i].area = "null";
            }
        }
}
