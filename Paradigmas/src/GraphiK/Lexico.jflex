package GraphiK;
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
Saltos = \r|\n|\r\n\

TiposComentarios = {LineaComentario} |{Multi}
Multi = "/*" [^*] ~"*/" | "/*" "*"+ "/"
LineaComentario     = "---!" {SinSaltos}* {Saltos}? 

CadenaD = "\"" {SinSaltos}* ~"\"" |  “ {SinSaltos}* ~” |” {SinSaltos}* ~”

WHITE=[ \t\r\n]
%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}

<YYINITIAL>{
/* PALABRAS RESERVADAS */
"user" {return new Symbol(sym.user, yycolumn, yyline, new String(yytext()));}
"pass" {return new Symbol(sym.pass,yycolumn, yyline, new String(yytext()));}
"name" {return new Symbol(sym.name, yycolumn, yyline,new String(yytext()));}
"correo" {return new Symbol(sym.correo  ,yycolumn, yyline,new String(yytext()));}
"score" {return new Symbol(sym.score  ,yycolumn, yyline,new String(yytext()));}
"$" {return new Symbol(sym.dollar  ,yycolumn, yyline,new String(yytext()));}
"=" {return new Symbol(sym.igual  ,yycolumn, yyline,new String(yytext()));}
"@" {return new Symbol(sym.arroba  ,yycolumn, yyline,new String(yytext()));}
"correo.com" {return new Symbol(sym.correo  ,yycolumn, yyline,new String(yytext()));}
"(" {return new Symbol(sym.parentesisA  ,yycolumn, yyline,new String(yytext()));}
")" {return new Symbol(sym.parentesisC ,yycolumn, yyline,new String(yytext()));}
"," {return new Symbol(sym.coma ,yycolumn, yyline,new String(yytext()));}

}
{Digito}+"."{Digito}+ {lexeme=yytext(); return new Symbol(sym.decimal, yycolumn, yyline,new String(yytext()));}
{Digito}+ {lexeme=yytext(); return new Symbol(sym.numero,yycolumn, yyline,new String(yytext()));}

{CadenaD} {lexeme=yytext(); return new Symbol(sym.cadena ,yycolumn, yyline,new String(yytext()));}
{Letra}({Letra}|{Digito})* {lexeme=yytext(); return new Symbol(sym.id,yycolumn, yyline, new String(yytext()));}
{TiposComentarios} {  }

. {return new Symbol(sym.ERROR,yycolumn, yyline,new String(yytext()));}


