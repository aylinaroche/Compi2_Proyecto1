package Graphik;
import java_cup.runtime.Symbol;
%%
%class LexicoALS
%type Symbol
%public
%char
%line
%column
%ignorecase
%function next_token
%cup
Letra = [a-zA-Z_]|á|é|í|ó|ú
Digito = 0 | [1-9][0-9]* 

SinSaltos = [^\"|\r|\n]
SinSalto = [^'|\r|\n]
Saltos = \r|\n|\r\n\
Sin = [^\r|\n]
 
TiposComentarios = {MultilineaComentario} | {LineaComentario} 
MultilineaComentario   = "#/" [^/] ~"/#" | "#/" "/"+ "/#"
LineaComentario     = "#" {Sin}* {Saltos}? 

TiposCadenas = {CadenaSimple} | {CadenaDoble}
CadenaSimple  = "'"{SinSalto}* ~ "'" | '{SinSalto}* ~' |‘{SinSalto}* ~’
CadenaDoble = "\"" {SinSaltos}* ~"\"" |  “ {SinSaltos}* ~” |” {SinSaltos}* ~”


WHITE=[ \t\r\n]
%{
public String lexeme;

%}
%%
{WHITE} {/*Ignore*/}


<YYINITIAL>{
/* PALABRAS RESERVADAS */
"gk" {return new Symbol(sym.extension, yycolumn, yyline, new String(yytext()));}
"hereda" {return new Symbol(sym.hereda, yycolumn, yyline, new String(yytext()));}
"inicio" {return new Symbol(sym.inicio, yycolumn, yyline, new String(yytext()));}
"nuevo" {return new Symbol(sym.nuevo, yycolumn, yyline, new String(yytext()));}
"llamar" {return new Symbol(sym.llamar, yycolumn, yyline, new String(yytext()));}
"llamarHK" {return new Symbol(sym.llamarHK, yycolumn, yyline, new String(yytext()));}
"als" {return new Symbol(sym.als, yycolumn, yyline, new String(yytext()));}
"var" {return new Symbol(sym.var, yycolumn, yyline, new String(yytext()));}
"publico" {return new Symbol(sym.publico, yycolumn, yyline,new String(yytext()));}
"privado" {return new Symbol(sym.privado, yycolumn, yyline,new String(yytext()));}
"protegido" {return new Symbol(sym.protegido, yycolumn, yyline,new String(yytext()));}
"importar" {return new Symbol(sym.importar, yycolumn, yyline,new String(yytext()));}
"incluir_HK" {return new Symbol(sym.incluir, yycolumn, yyline, new String(yytext()));}
"flotante" {return new Symbol(sym.tipoFloat, yycolumn, yyline, new String(yytext()));}
"vacio" {return new Symbol(sym.tipoVoid, yycolumn, yyline, new String(yytext()));}
"entero" {return new Symbol(sym.tipoInt, yycolumn, yyline,new String(yytext()));}
"caracter" {return new Symbol(sym.tipoChar, yycolumn, yyline,new String(yytext()));}
"cadena" {return new Symbol(sym.tipoString, yycolumn, yyline,new String(yytext()));}
"decimal" {return new Symbol(sym.tipoDouble, yycolumn, yyline,new String(yytext()));}
"bool" {return new Symbol(sym.tipoBool, yycolumn, yyline,new String(yytext()));}
"imprimir" {return new Symbol(sym.imprimir, yycolumn, yyline,new String(yytext()));}
"retornar" {return new Symbol(sym.retornar, yycolumn, yyline,new String(yytext()));}
"Si" {return new Symbol(sym.si, yycolumn, yyline,new String(yytext()));}
"Sino" {return new Symbol(sym.sino, yycolumn, yyline,new String(yytext()));}
"Seleccion" {return new Symbol(sym.interrumpir, yycolumn, yyline,new String(yytext()));}
"Caso" {return new Symbol(sym.caso, yycolumn, yyline,new String(yytext()));}
"Defecto" {return new Symbol(sym.defecto, yycolumn, yyline,new String(yytext()));}
"Mientras" {return new Symbol(sym.mientras, yycolumn, yyline,new String(yytext()));}
"Hacer" {return new Symbol(sym.hacer, yycolumn, yyline,new String(yytext()));}
"Para" {return new Symbol(sym.para, yycolumn, yyline,new String(yytext()));}
"Terminar" {return new Symbol(sym.salir, yycolumn, yyline,new String(yytext()));}
"Continuar" {return new Symbol(sym.continuar, yycolumn, yyline,new String(yytext()));}
"verdadero" {return new Symbol(sym.verdadero, yycolumn, yyline,new String(yytext()));}
"falso" {return new Symbol(sym.falso, yycolumn, yyline,new String(yytext()));}
"+" {return new Symbol(sym.mas, yycolumn, yyline, new String(yytext()));}
"*" {return new Symbol(sym.por, yycolumn, yyline,new String(yytext()));}
"-" {return new Symbol(sym.menos, yycolumn, yyline,new String(yytext()));}
"/" {return new Symbol(sym.dividido, yycolumn, yyline,new String(yytext()));}
"^" {return new Symbol(sym.potencia, yycolumn, yyline,new String(yytext()));}
"--" {return new Symbol(sym.disminuir, yycolumn, yyline,new String(yytext()));}
"++" {return new Symbol(sym.aumentar, yycolumn, yyline,new String(yytext()));}
">" {return new Symbol(sym.mayor, yycolumn, yyline,new String(yytext()));}
"<" {return new Symbol(sym.menor, yycolumn, yyline,new String(yytext()));}
"<=" {return new Symbol(sym.menorIgual, yycolumn, yyline,new String(yytext()));}
">=" {return new Symbol(sym.mayorIgual, yycolumn, yyline,new String(yytext()));}
"=" {return new Symbol(sym.igual, yycolumn, yyline,new String(yytext()));}
"==" {return new Symbol(sym.igualDoble, yycolumn, yyline,new String(yytext()));}
"!=" {return new Symbol(sym.diferente, yycolumn, yyline,new String(yytext()));}
"(" {return new Symbol(sym.parentesisA, yycolumn, yyline,new String(yytext()));}
")" {return new Symbol(sym.parentesisC, yycolumn, yyline,new String(yytext()));}
"||" {return new Symbol(sym.or, yycolumn, yyline,new String(yytext()));}
"&|" {return new Symbol(sym.xor, yycolumn, yyline,new String(yytext()));}
"&&" {return new Symbol(sym.and, yycolumn, yyline,new String(yytext()));}
"!" {return new Symbol(sym.not, yycolumn, yyline,new String(yytext()));}
":" {return new Symbol(sym.dosPuntos, yycolumn, yyline,new String(yytext()));}
"," {return new Symbol(sym.coma, yycolumn, yyline,new String(yytext()));}
"[" {return new Symbol(sym.corcheteA, yycolumn, yyline,new String(yytext()));}
"]" {return new Symbol(sym.corcheteC, yycolumn, yyline,new String(yytext()));}
"{" {return new Symbol(sym.llaveA, yycolumn, yyline,new String(yytext()));}
"}" {return new Symbol(sym.llaveC, yycolumn, yyline,new String(yytext()));}
"." {return new Symbol(sym.punto, yycolumn, yyline,new String(yytext()));}
"?" {return new Symbol(sym.signo, yycolumn, yyline, new String(yytext()));}
"graphikar_funcion" {return new Symbol(sym.graphikar, yycolumn, yyline,new String(yytext()));}
"Datos" {return new Symbol(sym.datos, yycolumn, yyline,new String(yytext()));}
"Procesar" {return new Symbol(sym.procesar, yycolumn, yyline,new String(yytext()));}
"columna" {return new Symbol(sym.columna, yycolumn, yyline,new String(yytext()));}
"fila" {return new Symbol(sym.fila, yycolumn, yyline,new String(yytext()));}
"Donde" {return new Symbol(sym.donde, yycolumn, yyline,new String(yytext()));}
"DondeCada" {return new Symbol(sym.dondeCada, yycolumn, yyline,new String(yytext()));}
"DondeTodo" {return new Symbol(sym.dondeTodo, yycolumn, yyline,new String(yytext()));}

}
{Letra}({Letra}|{Digito}|"_")* {lexeme=yytext(); return new Symbol(sym.id, yycolumn, yyline,new String(yytext()));}
{Digito}+ {lexeme=yytext(); return new Symbol(sym.entero, yycolumn, yyline,new String(yytext()));}
{Digito}+("."{Digito}+) {lexeme=yytext(); return new Symbol(sym.decimal, yycolumn, yyline,new String(yytext()));}

{CadenaDoble} {lexeme=yytext(); return new Symbol(sym.cadena ,yycolumn, yyline,new String(yytext()));}
{CadenaSimple} {lexeme=yytext(); return new Symbol(sym.caracter ,yycolumn, yyline,new String(yytext()));}
{TiposComentarios} { }

. {//return new Symbol(sym.ERROR, yycolumn, yyline,new String(yytext()));
//ejecutar.Errores.agregarError(yytext(), "Error Lexico", "No pertenece al lenguaje",0,0);

}

