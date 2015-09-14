package biblioteca;

public class Biblioteca {

    public static void main(String[] args) {
        
        int opcion;
        int ciclo=1;
        directorio persona1;
        persona1 = new directorio();
        persona1.Llenar();
        persona1.conectar();
        while(ciclo==1){
            persona1.Menu1();
            opcion = persona1.getSeleccion();
            switch(opcion){
                case 1:
                    persona1.Menu2();
                    opcion = persona1.getSeleccion();
                    switch(opcion){
                        case 1:
                            persona1.IngresarLibroNuevo();
                        break;
                        case 2:
                            persona1.ActualizarLibro();
                        break;
                        case 3:
                            persona1.Borrar();
                        break;
                        case 4:
                            persona1.ImprimirInfo();
                        break;
                    }
                break;
                case 2:
                    persona1.Menu3();
                    opcion = persona1.getSeleccion();
                    switch(opcion){
                        case 1:
                            persona1.Prestamos();
                        break;
                        case 2:
                            persona1.Devolver();
                        break;
                        case 3:
                            persona1.LibrosPrestados();
                        break;
                    }
                    
                break;
            }
        }
    }
    
}
