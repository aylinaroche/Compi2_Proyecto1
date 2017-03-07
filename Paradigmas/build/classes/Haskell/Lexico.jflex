package Haskell;
import java_cup.runtime.Symbol;
%%
%class Lexico
%type Symbol
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
MultilineaComentario   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
LineaComentario     = "//" {Sin}* {Saltos}? 

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
"Succ" {return new Symbol(sym.succ, yycolumn, yyline, new String(yytext()));}
"Decc" {return new Symbol(sym.decc,yycolumn, yyline, new String(yytext()));}
"Calcular" {return new Symbol(sym.calcular  ,yycolumn, yyline,new String(yytext()));}
"let" {return new Symbol(sym.let,yycolumn, yyline, new String(yytext()));}
"true" {return new Symbol(sym.verdadero, yycolumn, yyline,new String(yytext()));}
"false" {return new Symbol(sym.falso, yycolumn, yyline,new String(yytext()));}
"end" {return new Symbol(sym.end, yycolumn, yyline,new String(yytext()));}
"Max" {return new Symbol(sym.max  ,yycolumn, yyline,new String(yytext()));}
"Min" {return new Symbol(sym.min  ,yycolumn, yyline,new String(yytext()));}
"if" {return new Symbol(sym.si, yycolumn, yyline,new String(yytext()));}
"else" {return new Symbol(sym.sino, yycolumn, yyline,new String(yytext()));}
"case" {return new Symbol(sym.caso, yycolumn, yyline,new String(yytext()));}
"sum" {return new Symbol(sym.sum, yycolumn, yyline,new String(yytext()));}
"product" {return new Symbol(sym.product, yycolumn, yyline,new String(yytext()));}
"revers" {return new Symbol(sym.revers, yycolumn, yyline,new String(yytext()));}
"impr" {return new Symbol(sym.impr, yycolumn, yyline,new String(yytext()));}
"par" {return new Symbol(sym.par, yycolumn, yyline,new String(yytext()));}
"asc" {return new Symbol(sym.asc, yycolumn, yyline,new String(yytext()));}
"desc" {return new Symbol(sym.desc, yycolumn, yyline,new String(yytext()));}
"length" {return new Symbol(sym.length, yycolumn, yyline,new String(yytext()));}
"then" {return new Symbol(sym.entonces, yycolumn, yyline,new String(yytext()));}

"'pot'" {return new Symbol(sym.pot  ,yycolumn, yyline,new String(yytext()));}
"'mod'" {return new Symbol(sym.mod  ,yycolumn, yyline,new String(yytext()));}
"'sqrt'" {return new Symbol(sym.sqrt  ,yycolumn, yyline,new String(yytext()));}
"++" {return new Symbol(sym.concatenar  ,yycolumn, yyline,new String(yytext()));}
"+" {return new Symbol(sym.mas  ,yycolumn, yyline,new String(yytext()));}
"-" {return new Symbol(sym.menos  ,yycolumn, yyline,new String(yytext()));}
"*" {return new Symbol(sym.por  ,yycolumn, yyline,new String(yytext()));}
"/" {return new Symbol(sym.div  ,yycolumn, yyline,new String(yytext()));}
":" {return new Symbol(sym.dosPuntos  ,yycolumn, yyline,new String(yytext()));}
"$" {return new Symbol(sym.dollar  ,yycolumn, yyline,new String(yytext()));}
">" {return new Symbol(sym.mayor, yycolumn, yyline,new String(yytext()));}
"<" {return new Symbol(sym.menor, yycolumn, yyline,new String(yytext()));}
"<=" {return new Symbol(sym.mayorIgual, yycolumn, yyline,new String(yytext()));}
">=" {return new Symbol(sym.menorIgual, yycolumn, yyline,new String(yytext()));}
"=" {return new Symbol(sym.igual, yycolumn, yyline,new String(yytext()));}
"==" {return new Symbol(sym.igualDoble, yycolumn, yyline,new String(yytext()));}
"!=" {return new Symbol(sym.diferente, yycolumn, yyline,new String(yytext()));}
"(" {return new Symbol(sym.parentesisA, yycolumn, yyline,new String(yytext()));}
")" {return new Symbol(sym.parentesisC, yycolumn, yyline,new String(yytext()));}
"||" {return new Symbol(sym.or, yycolumn, yyline,new String(yytext()));}
"&&" {return new Symbol(sym.and, yycolumn, yyline,new String(yytext()));}
"!" {return new Symbol(sym.not, yycolumn, yyline,new String(yytext()));}
"(" {return new Symbol(sym.parentesisA  ,yycolumn, yyline,new String(yytext()));}
")" {return new Symbol(sym.parentesisC ,yycolumn, yyline,new String(yytext()));}
"," {return new Symbol(sym.coma ,yycolumn, yyline,new String(yytext()));}
"{" {return new Symbol(sym.llaveA  ,yycolumn, yyline,new String(yytext()));}
"}" {return new Symbol(sym.llaveC  ,yycolumn, yyline,new String(yytext()));}
"[" {return new Symbol(sym.corcheteA, yycolumn, yyline,new String(yytext()));}
"]" {return new Symbol(sym.corcheteC, yycolumn, yyline,new String(yytext()));}
"!!" {return new Symbol(sym.posicion  ,yycolumn, yyline,new String(yytext()));}
"%" {return new Symbol(sym.porcentaje  ,yycolumn, yyline,new String(yytext()));}


}
{Digito}+"."{Digito}+ {lexeme=yytext(); return new Symbol(sym.decimal, yycolumn, yyline,new String(yytext()));}
{Digito}+ {lexeme=yytext(); return new Symbol(sym.numero,yycolumn, yyline,new String(yytext()));}

{CadenaDoble} {lexeme=yytext(); return new Symbol(sym.cadena ,yycolumn, yyline,new String(yytext()));}
{CadenaSimple} {lexeme=yytext(); return new Symbol(sym.caracter ,yycolumn, yyline,new String(yytext()));}

{Letra}({Letra}|{Digito})* {lexeme=yytext(); return new Symbol(sym.id,yycolumn, yyline, new String(yytext()));}
{TiposComentarios} {  }

. {return new Symbol(sym.ERROR,yycolumn, yyline,new String(yytext()));}


