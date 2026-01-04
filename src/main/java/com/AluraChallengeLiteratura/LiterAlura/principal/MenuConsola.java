package com.AluraChallengeLiteratura.LiterAlura.principal;

import com.AluraChallengeLiteratura.LiterAlura.service.LibroService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuConsola {
    private final LibroService libroService;
    private final Scanner input=new Scanner(System.in);

    public MenuConsola(LibroService libroService){
        this.libroService=libroService;
    }

    public void iniciar(){
        int opcion=0;

        while(opcion!=5){
            System.out.println("""
                   ******************
                    Menu de opciones
                   ******************
                   1-Buscar libro en la API y guardarlo.
                   2-Buscar libro por ID.
                   5-Salir del programa.
                   """);

            System.out.println("Ingrese una opcion:");
            opcion=input.nextInt();
            input.nextLine();

            if(opcion==1){
                System.out.println("Titulo del libro: ");
                String titulo=input.nextLine();
                libroService.buscarYGuardar(titulo);
            } else if(opcion==2){
                System.out.println("Id del libro: ");
                int id=input.nextInt();
                libroService.buscarYGuardarPorId(id);

            } else if(opcion==5){

            }else{
                System.out.println("Opcion incorrecta,digite un numero del 1 al 5");
            }
        }
    }
}
