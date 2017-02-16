/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;
import java.util.*;
/**
 *
 * @author alumno
 */
public class Dibujar_mapa {
    
    public static String[][] mapa;
    
    public static int minas = 0;
    public static int minasFijo = 0;
    public static List<int[]> casillasDescubiertas = new ArrayList<int[]>();
    
    public static void main(String[] args) {
        
    Dibujar_mapa();
    
    }

    public static void Dibujar_mapa() {
    
        Scanner lector = new Scanner (System.in);
        
        int filas=0;
        int columnas=0;             
        
        while(minas <= 0 || minas>20){
            
        System.out.println("Cuantas minas quieres? (max 20) :");
        
        while (!lector.hasNextInt()){
            System.out.println("Te he pillado Nacho, dame un número de verdad...");
            lector.next();
        }
        minas = lector.nextInt();
        minasFijo = minas;
      
        if(minas>20){
            System.out.println("No pidas tantas anda...");
        }
        else if (minas<=5 && minas > 0){
            filas = 4;
            columnas = 4;
        }
        
        else if (minas>5 && minas<=10){
            filas = 5;
            columnas = 5;
        }
        
        else{
            filas=7;
            columnas=7;
        }
    }
    mapa = crearMapa(filas, columnas);
    imprimirMapa(mapa);
}  
       
    public static String[][] crearMapa(int filas, int columnas){
        String [][] mapaoculto = new String[filas][columnas];    
        
        int NumaX;
        int NumaY;
        int contadorMina;
        
        for(int i = 0; i<mapaoculto.length;i++){
        
            for(int j = 0;j<mapaoculto[0].length;j++){
            mapaoculto[i][j] = "*";
            }
            
        }
        while (minas > 0){
        
            NumaX = (int) (Math.random()*columnas);       
            NumaY = (int) (Math.random()*filas);
            
            if (mapaoculto[NumaX][NumaY].equals("*")){//Si cae en una mina no lo hace
            
                mapaoculto[NumaX][NumaY] = "M";
                minas -= 1;
            }
        }
        for(int y = 0; y<mapaoculto.length;y++){
        
            for(int x = 0;x<mapaoculto[0].length;x++){
                
                if(!mapaoculto[y][x].equals("M")&&!mapaoculto[y][x].equals("10")){//esquina superior derecha
                    
                    if (y == 0 && x == 0){
                        
                        contadorMina = 0;

                        for (int i = 0; i<=1;i++){
                            
                            for(int j = 0; j<=1;j++){

                                if (mapaoculto[i][j].equals("M")||mapaoculto[i][j].equals("10")){

                                    contadorMina += 1;
                                }
                            }                            
                        }
                        mapaoculto[y][x] = ""+contadorMina;
                        
                    }
                    else if (y == 0 && x == mapaoculto[x].length-1){//esquina superior izquierda
                        
                        contadorMina = 0;

                        for (int i = y; i<=y+1;i++){
                            
                            for(int j = x; j>=x-1;j--){

                                if (mapaoculto[i][j].equals("M")||mapaoculto[i][j].equals("10")){

                                    contadorMina += 1;
                                }
                            }                            
                        }
                        mapaoculto[y][x] = ""+contadorMina;
                    }
                        
                    else if (y == mapaoculto[y].length-1 && x == 0){//esquina inferior derecha
                                                       
                        contadorMina = 0;

                        for (int i = y; i>=y-1;i--){
                            
                            for(int j = x; j<=x+1;j++){

                                if (mapaoculto[i][j].equals("M")||mapaoculto[i][j].equals("10")){

                                    contadorMina += 1;
                                }
                            }                           
                        }
                        mapaoculto[y][x] = ""+contadorMina;
                    }
                    else if (y == mapaoculto[y].length-1 && x == mapaoculto[x].length-1){//esquina inferior izquierda
                        
                        contadorMina = 0;

                        for (int i = y; i>=y-1;i--){
                            
                            for(int j = x; j>=x-1;j--){

                                if (mapaoculto[i][j].equals("M")||mapaoculto[i][j].equals("10")){

                                    contadorMina += 1;
                                }
                            }                            
                        }
                        mapaoculto[y][x] = ""+contadorMina;
                    }
                    else if (x == 0 && y >0 && y < mapaoculto[y].length-1){//primera columna
                        
                        contadorMina = 0;

                        for (int i = y-1; i<=y+1 ;i++){
                            
                            for(int j =0 ; j<=1;j++){

                                if (mapaoculto[i][j].equals("M")||mapaoculto[i][j].equals("10")){

                                    contadorMina += 1;
                                }
                            }                            
                        }
                        mapaoculto[y][x] = ""+contadorMina;
                    }
                    else if (y == 0 && x >0 && y < mapaoculto[x].length-1){//primera linea
                        
                        contadorMina = 0;

                        for (int j = x-1; j<=x+1 ;j++){
                            
                            for(int i =0 ; i<=1;i++){

                                if (mapaoculto[i][j].equals("M")||mapaoculto[i][j].equals("10")){

                                    contadorMina += 1;
                                }
                            }                            
                        }
                        mapaoculto[y][x] = ""+contadorMina;
                    }
                    else if (x == mapaoculto[x].length-1 && y >0 && y < mapaoculto[y].length-1){//ultima columna
                        
                       contadorMina = 0;

                        for (int i = y-1; i<=y+1 ;i++){
                            
                            for(int j = x-1 ; j<=x ;j++){

                                if (mapaoculto[i][j].equals("M")||mapaoculto[i][j].equals("10")){

                                    contadorMina += 1;
                                }
                            }                            
                        }
                        mapaoculto[y][x] = ""+contadorMina;
                    }
                    else if (y == mapaoculto[y].length-1 && x >0 && x < mapaoculto[x].length-1){//ultima fila
                        
                       contadorMina = 0;

                        for (int j = x-1; j<=x+1 ;j++){
                            
                            for(int i = y-1 ; i<=y ;i++){

                                if (mapaoculto[i][j].equals("M")||mapaoculto[i][j].equals("10")){

                                    contadorMina += 1;
                                }
                            }                            
                        }
                        mapaoculto[y][x] = ""+contadorMina;
                    }
                     else if (y < mapaoculto[y].length-1 && y>0 && x >0 && x < mapaoculto[x].length-1){//centro
                         
                       contadorMina = 0;

                        for(int i = y-1 ; i<=y+1 ;i++){
                            
                                for (int j = x-1; j<=x+1 ;j++){                                                      

                                if (mapaoculto[i][j].equals("M")||mapaoculto[i][j].equals("10")){

                                    contadorMina += 1;
                                }
                            }                            
                        }
                        mapaoculto[y][x] = ""+contadorMina;
                    }
                }
            }
            
        }
        return mapaoculto;
    }
       
    public static void imprimirMapa(String[][] mapa){
        
        int asterisco = 0;
        
        System.out.print(" "+ "\t");
        
        for (int i = 0; i<mapa.length; i++){
            System.out.print (i+1+"\t" );
        }
        
        System.out.println();
        System.out.println();
        
        
        
        for (int y=0; y<mapa.length; y++){
            
            System.out.print(y+1+"\t");
            
            for (int x = 0; x < mapa.length; x++){
                
                if (mapa[x][y].equals("M")){//Mina
                   
                   System.out.print("*");
                   asterisco += 1;
                   
               }else if(mapa[x][y].equals("10")){//mina marcada
                   
                   System.out.print("P");
                  
                }else if (mapa[x][y].equals("1")||mapa[x][y].equals("2")||mapa[x][y].equals("3")||mapa[x][y].equals("4")||mapa[x][y].equals("5")||mapa[x][y].equals("6")||mapa[x][y].equals("7")||mapa[x][y].equals("8")){//numero
                   
                   System.out.print("*");
                   asterisco += 1;
               }else if (mapa[x][y].equals("11")||mapa[x][y].equals("21")||mapa[x][y].equals("22")||mapa[x][y].equals("23")||mapa[x][y].equals("24")||mapa[x][y].equals("25")||mapa[x][y].equals("26")||mapa[x][y].equals("27")||mapa[x][y].equals("28")){//numero
                   
                   System.out.print("P");
                   asterisco += 1;
                   
               }else if (mapa[x][y].equals("0")){//Espacio vacio marcado
                   
                   System.out.print("*");
                   asterisco += 1;
               }else {
                   System.out.print(mapa[x][y]);
                }
                if (y !=mapa[y].length){
               
                   System.out.print("\t");
                }
            }
            System.out.println();
        }
        if (asterisco > minasFijo){
        System.out.println();
        System.out.println();
        menu();
        } else{
        
            System.out.println("You win");
            
        }
    }
    
    public static void menu(){
        Scanner lector = new Scanner (System.in);
        
        int respuesta;
        
        System.out.println("1. Descubrir casilla");
        System.out.println("2. Marcar casilla");
        System.out.println("3. Desmarcar casilla");
        
        while (!lector.hasNextInt()){
            System.out.println("Te he pillado Nacho, dame un número de verdad...");
            lector.next();
        }
        respuesta= lector.nextInt();
        
        if(respuesta == 1){
        
            descubrirCasilla();  
        }else if(respuesta == 2){
        
            marcarCasilla();
        }else if(respuesta == 3){
        
            desmarcarCasilla();      
        } else{
            System.out.println("Dame una variable valida");
            menu();
        }
    }
    
    public static void marcarCasilla(){
        Scanner lector = new Scanner (System.in);
        
        int x;
        int y;
        
        System.out.println("Que casilla quieres marcar?");   
        
        while (!lector.hasNextInt()){
            System.out.println("Te he pillado Nacho, dame un número de verdad...");
            lector.next();
        }
        x = lector.nextInt()-1;
        while (!lector.hasNextInt()){
            System.out.println("Te he pillado Nacho, dame un número de verdad...");
            lector.next();
        }
        y = lector.nextInt()-1;
        if(x < 0 || y < 0){
            System.out.println("Te has quedado corto");
            imprimirMapa(mapa);
        }else if (x >= mapa.length || y >= mapa.length){
        
            System.out.println("Te has pasado");     
            imprimirMapa(mapa);
        }
        if (mapa[x][y].equals("10")||mapa[x][y].equals("11")||mapa[x][y].equals("21")||mapa[x][y].equals("22")||mapa[x][y].equals("23")||mapa[x][y].equals("24")||mapa[x][y].equals("25")||mapa[x][y].equals("26")||mapa[x][y].equals("27")||mapa[x][y].equals("28")){
            
            System.out.println("Casilla ya marcada");     
            marcarCasilla();
            
        }else if (mapa[x][y].equals("M")){//mina marcada
        
            mapa[x][y] =("10");                     
        }else if (mapa[x][y].equals("1")){//1 alrededor marcada
        
            mapa[x][y] =("21");                     
        }else if (mapa[x][y].equals("2")){//2 alrededor marcada
        
            mapa[x][y] =("22");                     
        }else if (mapa[x][y].equals("3")){//3 alrededor marcada
        
            mapa[x][y] =("23");     
        }else if (mapa[x][y].equals("4")){//4 alrededor marcada
        
            mapa[x][y] =("24");     
        }else if (mapa[x][y].equals("5")){//5 alrededor marcada
        
            mapa[x][y] =("25");     
        }else if (mapa[x][y].equals("6")){//6 alrededor marcada
        
            mapa[x][y] =("26");     
        }else if (mapa[x][y].equals("7")){//7 alrededor marcada
        
            mapa[x][y] =("27");     
        }else if (mapa[x][y].equals("8")){//8 alrededor marcada
        
            mapa[x][y] =("28");     
        }else if (mapa[x][y].equals("0")){//espacio marcada
        
            mapa[x][y] = "11";
        }   
        imprimirMapa(mapa);
    }
    
    public static void desmarcarCasilla(){
    
        Scanner lector = new Scanner (System.in);
        
        int x;
        int y;
        
        System.out.println("Que casilla quieres desmarcar?");     
        
        while (!lector.hasNextInt()){
            System.out.println("Te he pillado Nacho, dame un número de verdad...");
            lector.next();
        }
        x = lector.nextInt()-1;
        while (!lector.hasNextInt()){
            System.out.println("Te he pillado Nacho, dame un número de verdad...");
            lector.next();
        }
        y = lector.nextInt()-1;
       
        if(estaFuera(x, y)){
            
            System.out.println("Fuera de rango");
            imprimirMapa(mapa);
        }else if (mapa[x][y].equals("11")){
        
            mapa[x][y]= "0";
        }else if (mapa[x][y].equals("10")){
        
            mapa[x][y]= "M";
        }else if (mapa[x][y].equals("21")){
        
            mapa[x][y]= "1";
        }else if (mapa[x][y].equals("22")){
        
            mapa[x][y]= "2";
        }else if (mapa[x][y].equals("23")){
        
            mapa[x][y]= "3";
        }else if (mapa[x][y].equals("24")){
        
            mapa[x][y]= "4";
        }else if (mapa[x][y].equals("25")){
        
            mapa[x][y]= "5";
        }else if (mapa[x][y].equals("26")){
        
            mapa[x][y]= "6";
        }else if (mapa[x][y].equals("27")){
        
            mapa[x][y]= "7";
        }else if (mapa[x][y].equals("28")){
        
            mapa[x][y]= "8";
        }else{
        
            System.out.println("Casilla no marcada");
            menu();  
        }
        imprimirMapa(mapa);
    }
    
    public static void descubrirCasilla(){
        
        Scanner lector = new Scanner (System.in);
        
        int x;
        int y;
        
        System.out.println("Que casilla quieres descubrir?");  
        
        while (!lector.hasNextInt()){
            System.out.println("Te he pillado Nacho, dame un número de verdad...");
            lector.next();
        }
        
        x = lector.nextInt()-1;
        
        while (!lector.hasNextInt()){
            System.out.println("Te he pillado Nacho, dame un número de verdad...");
            lector.next();
        }
        
        y = lector.nextInt()-1;
        
        if(estaFuera(x, y)){
            System.out.println("Te has salido de rango");
            imprimirMapa(mapa);
            return;
        }
       
        int pos[]={x,y};
        
        for (int i = 0; i<casillasDescubiertas.size();i++){

            int[] casilla = casillasDescubiertas.get(i);

            if (casilla[0] == x && casilla[1] == y){                

                System.out.println("Casilla ya descubierta");
                System.out.println("");
                imprimirMapa(mapa);
                return;

            }
        }
        mapa[x][y]= mapa[x][y].trim();
        
        if (mapa[x][y].equals("M")||mapa[x][y].equals("10")){
        
            System.out.println("Has perdido");     
        }else if (mapa[x][y].equals("11")){
        
            mapa[x][y]= "0";
            quitarCasilla(x, y);
            imprimirMapa(mapa);

        }else if (mapa[x][y].equals("21")){
        
            mapa[x][y]= "1 ";
            quitarCasilla(x, y);
            imprimirMapa(mapa);

        }else if (mapa[x][y].equals("22")){
        
            mapa[x][y]= "2 ";
            quitarCasilla(x, y);
            imprimirMapa(mapa);
            
        }else if (mapa[x][y].equals("23")){
        
            mapa[x][y]= "3 ";
            quitarCasilla(x, y);
            imprimirMapa(mapa);

        }else if (mapa[x][y].equals("24")){
        
            mapa[x][y]= "4 ";
            quitarCasilla(x, y);
            imprimirMapa(mapa);

        }else if (mapa[x][y].equals("25")){
        
            mapa[x][y]= "5 ";
            quitarCasilla(x, y);
            imprimirMapa(mapa);

        }else if (mapa[x][y].equals("26")){
        
            mapa[x][y]= "6 ";
            quitarCasilla(x, y);
            imprimirMapa(mapa);

        }else if (mapa[x][y].equals("27")){
        
            mapa[x][y]= "7 ";
            quitarCasilla(x, y);
            imprimirMapa(mapa);

        }else if (mapa[x][y].equals("28")){
        
            mapa[x][y]= "8 ";
            quitarCasilla(x, y);
            imprimirMapa(mapa);

        }else if (mapa[x][y].equals("1")){
            
             mapa[x][y]= "1 ";
             System.out.println("Casilla ya descubierta");
             imprimirMapa(mapa);
             
        }else if (mapa[x][y].equals("2")){
            
             mapa[x][y]= "2 ";
             System.out.println("Casilla ya descubierta");
             imprimirMapa(mapa);
             
        }else if (mapa[x][y].equals("3")){
            
             mapa[x][y]= "3 ";
             System.out.println("Casilla ya descubierta");
             imprimirMapa(mapa);
             
        }else if (mapa[x][y].equals("4")){
            
             mapa[x][y]= "4 ";
             System.out.println("Casilla ya descubierta");
             imprimirMapa(mapa);
             
        }else if (mapa[x][y].equals("5")){
            
             mapa[x][y]= "5 ";
             System.out.println("Casilla ya descubierta");
             imprimirMapa(mapa);
             
        }else if (mapa[x][y].equals("6")){
            
             mapa[x][y]= "6 ";
             System.out.println("Casilla ya descubierta");
             imprimirMapa(mapa);
             
        }else if (mapa[x][y].equals("7")){

            mapa[x][y]= "7 ";
             System.out.println("Casilla ya descubierta");
             imprimirMapa(mapa);
             
        }else if (mapa[x][y].equals("8")){
            
             mapa[x][y]= "8 ";
             System.out.println("Casilla ya descubierta");
             imprimirMapa(mapa);
             
        }
        else {
            
            String numeroString = mapa[x][y];
            int numero = Integer.parseInt(numeroString);
            
            
            if (esNumero(numero,x,y)){
               
                mapa[x][y] = numero+" ";
                quitarCasilla(x, y);
                
            }else {

                quitarCasilla(x, y);
            }
            imprimirMapa(mapa);
        }
    }
        
    public static void quitarCasilla(int x, int y){
        
       
        if (estaFuera(x, y)) {        
            return;
        }
            
       
        
        if (mapa[x][y].equals("0")){
            
            int[][] casillas = arround(x,y);
            
            for( int i = 0; i<8;i++){
                
                if(casillas[i][0] <= -1 || casillas[i][1] >= mapa.length){
                    continue;
                    
                }else{
                int pos[]={x,y};
                casillasDescubiertas.add(pos);
                mapa[x][y] = "O";
                quitarCasilla(casillas[i][0],casillas[i][1]);
                
                }
            }
        }else if(!mapa[x][y].equals("0")||!mapa[x][y].equals("O"))
            mapa[x][y] = mapa[x][y]+" ";
    
       
}
    
    private static int[][] arround(int x, int y){
    
        int[] upLeft = {x-1,y-1},
        up = {x,y-1},
        upRight = {x+1,y-1},
        left = {x-1,y},
        right = {x+1,y},
        downLeft = {x-1,y+1},
        down = {x,y+1},
        downRight = {x+1,y+1};
        
        if(x <= 0){
            
            upLeft[0] = -1;
            left[0] = -1;
            downLeft[0] = -1;
        }else if (x >= mapa[0].length-1) {
            upRight[0] = -1;
            right[0] = -1;
            downRight[0] = -1;
        }      
                
        int[][] cells = {upLeft, up, upRight, left, right, downLeft,down,downRight};
        
        return cells;
    }
    
    public static boolean esNumero (int numero, int x, int y){
        if (numero == 0) return false;
        return mapa[x][y].equals(""+numero)||mapa[x][y].equals("2"+numero)||
                mapa[x][y].equals(""+numero+" ")||mapa[x][y].equals("2"+numero+" ");
    }
    
    public static boolean estaFuera(int x, int y) {
        return x < 0 || y < 0 || x >= mapa[0].length || y > mapa[0].length;
    }
}
    


