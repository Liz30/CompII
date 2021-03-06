   
import java_cup.runtime.*;
      
%%
   

%class Lexer


%line
%column
    

%cup
   

%{   
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
   

LineTerminator = \r|\n|\r\n
   

WhiteSpace     = {LineTerminator} | [ \t\f]
   
dec_int_lit = 0 | [1-9][0-9]*
   
dec_int_id = [A-Za-z_][A-Za-z_0-9]*
   
%%
      
<YYINITIAL> {
   
   
    ";"                { return symbol(sym.SEMI); }
    ","                { return symbol(sym.COMA); }
    "+"                {  return symbol(sym.PLUS); }
    "-"                {  return symbol(sym.MINUS); }
    "*"                {  return symbol(sym.TIMES); }
    "/"                {  return symbol(sym.DIVIDE); }
    "("                {  return symbol(sym.LPAREN); }
    ")"                {  return symbol(sym.RPAREN); }
    "="                {  return symbol(sym.ASSIGN); }
    "<-"               { return symbol(sym.ASSIGFOR); }
    ":"                { return symbol(sym.COLON); }
    "print"                {  return symbol(sym.PRINT); }
    "for"                {  return symbol(sym.FOR); }
    "to"                {  return symbol(sym.TO); }
    "do"                {  return symbol(sym.DO); }
    "end"                {  return symbol(sym.END); }
    "set_cursor"        { return symbol(sym.SET_CURSOR); }
    "move_down"         { return symbol(sym.MOVE_DOWN); }
    "move_up"           { return symbol(sym.MOVE_UP); }
    "move_left"         { return symbol(sym.MOVE_LEFT); }
    "move_right"        {return symbol(sym.MOVE_RIGHT); }
    "set_color"         {return symbol(sym.SET_COLOR); }
    "["                {  return symbol(sym.LBRACK); }
    "]"                {  return symbol(sym.RBRACK); }
   
    {dec_int_lit}      { 
                         return symbol(sym.NUMBER, new Integer(yytext())); }
   
    {dec_int_id}       { 
                         return symbol(sym.ID, yytext());}
   
    
    {WhiteSpace}       { /* just skip what was found, do nothing */ }   
}



[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
