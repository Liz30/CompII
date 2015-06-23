/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codegeneration;

import java.util.List;
import treenodes.expresion.IdNode;

/**
 *
 * @author Admin
 */
public class ASMGenerator {

    String Header;
    String Footer;
    String Start;
    public List<IdNode> variables;
    int xActual=0;
    int yActual=0;
    
    public int getxActual() {
        return xActual;
    }

    public void setxActual(int xActual) {
        this.xActual = xActual;
    }

    public int getyActual() {
        return yActual;
    }

    public void setyActual(int yActual) {
        this.yActual = yActual;
    }
    
    public void setStart(String Start) {
        this.Start += Start;
    }   
    
    public String variablesList ()
    {
        // Ciclo para formar el string de las variables a declarar
        return "";
    }
    
    public ASMGenerator() {
        this.Header="; template for program using standard Win32 headers \n\n"+
                    "format PE CONSOLE 4.0 \n"+
                    "entry start \n\n"+
                    "include 'win32a.inc' \n\n"+
                    "section '.data' data readable writeable \n\n"+
                    " pauseCmd db  'p','a','u','s','e',0 \n"+
                    " msg db '*',10,13,0\n"+
                    " pos db 0,0,0,0 \n"+
                    " h dd -11 \n"+
                    " handle dd 0 \n"; 
        
        this.Start="\n\nsection '.code' code readable executable \n\n" +
                   "  start: \n\n" +

                   "        push -11 \n" +
                   "        call [GetStdHandle] \n" +
                   "        add esp,4 \n\n" +
                   "        mov [handle],eax \n\n";
        
        this.Footer="\n        push msg\n" +
                    "        call [printf]\n" +
                    "        add esp,4\n\n"+
                    "        push pauseCmd\n" +
                    "        call [system]\n" +
                    "        add esp, 4\n\n" +
                    "        call [ExitProcess]\n\n" +
                    "section '.idata' import data readable writeable\n\n" +
                    "  library kernel,'KERNEL32.DLL',\\\n" +
                    "          ms ,'msvcrt.dll'\n\n" +
                    "  import kernel,\\\n" +
                    "         ExitProcess,'ExitProcess',\\\n" +
                    "         gotoxy, 'SetConsoleCursorPosition',\\\n" +
                    "         setcolor, 'SetConsoleTextAttribute',\\\n" +
                    "         GetStdHandle,'GetStdHandle'\n\n" +
                    "  import ms,\\\n" +
                    "         printf,'printf',\\\n" +
                    "         scanf,'scanf',\\\n" +
                    "         cget ,'_getch',\\\n" +
                    "         system,'system'  ";              
    };
    
       
    public String generator(String Code)
    {
        return this.Header+
               variablesList()+
               this.Start+
               "\n ; Codigo Nuevo:\n\n"+
               Code+"\n"+
               this.Footer;
    }
    
}
