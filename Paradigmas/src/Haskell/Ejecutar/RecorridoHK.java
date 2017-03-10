package Haskell.Ejecutar;

public class RecorridoHK {

    public static String variables = "";
    public static String visible = "";
    public static String tipo = "";
    public static String var = "";
    public static String[] vars;
    public static String asignar = "";
    public static String tam = "";
    public static String tamanio = "";
    public static String valores = "";
    public static boolean elseif = false;
    public static String valorSwitch = "";
    public static boolean romper = false;

    public String Recorrido(Nodo raiz) {
        String result = null;
        // Nodo nodo = null;
        if (raiz != null) {
            switch (raiz.texto) {
                case "INICIO":
                    Recorrido(raiz.hijos[0]);
                    break;
                case "INSTRUCCIONES":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]);
                            break;
                        case 2:
                            Recorrido(raiz.hijos[0]);
                            Recorrido(raiz.hijos[1]);
                            break;
                    }
                    break;
                case "INSTRUCCION":
                    Recorrido(raiz.hijos[0]);
                    break;
                case "LISTA":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            result = Recorrido(raiz.hijos[3]);
                            break;
                    }
                    break;
                case "MATRIZ":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            //Recorrido(raiz.hijos[0]);
                            break;
                        case 3:
                            Recorrido(raiz.hijos[1]);
                            break;
                        case 5:
                            Recorrido(raiz.hijos[0]);
                            Recorrido(raiz.hijos[3]);
                            break;
                    }
                    break;
                case "LOC":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            Recorrido(raiz.hijos[0]);
                            break;
                        case 3:
                            Recorrido(raiz.hijos[0]);
                            Recorrido(raiz.hijos[2]);
                            break;
                    }
                    break;
                case "CALCULAR":
                    Recorrido(raiz.hijos[2]);

                    break;
                case "OPERACION_LISTA":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            Recorrido(raiz.hijos[2]);
                            break;
                    }
                    break;
                case "NOMBRE_OP":
                    break;
                case "POSICION":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            Recorrido(raiz.hijos[1]);
                            break;
                        case 3:
                            Recorrido(raiz.hijos[0]);
                            Recorrido(raiz.hijos[2]);
                            break;
                    }
                    break;
                case "IF":
                    String condicion = "";
                    switch (raiz.cantidadHijos) {
                        case 7:
                            condicion = Recorrido(raiz.hijos[2]);
                            if (condicion.equals("true")) { //Si es true, hacer istruccion
                                Recorrido(raiz.hijos[5]);
                            }
                            break;
                        case 8:
                            condicion = Recorrido(raiz.hijos[2]);
                            if (condicion.equals("true")) { //Si es true, hacer istruccion
                                Recorrido(raiz.hijos[5]);
                            } else {
                                Recorrido(raiz.hijos[7]);
                            }
                            break;
                        case 9:
                            condicion = Recorrido(raiz.hijos[2]);
                            if (condicion.equals("true")) { //Si es true, hacer istruccion
                                Recorrido(raiz.hijos[5]);
                            } else {
                                String elseif = Recorrido(raiz.hijos[7]);
                                if (elseif.equals("false")) { //Si es true, hacer istruccion
                                    Recorrido(raiz.hijos[8]);
                                }
                            }
                            break;
                    }
                    break;
                case "SWITCH":
                    String valor = "";
                    switch (raiz.cantidadHijos) {
                        case 7:
                            valorSwitch = Recorrido(raiz.hijos[2]);
                            Recorrido(raiz.hijos[5]);
                            break;
                        case 8:
                            valorSwitch = Recorrido(raiz.hijos[2]);
                            result = Recorrido(raiz.hijos[5]);
                            if (result.equals("false")) { //Si es true, hacer istruccion
                                Recorrido(raiz.hijos[6]);
                            }
                            break;
                        case 9:
                            valorSwitch = Recorrido(raiz.hijos[2]);
                            Recorrido(raiz.hijos[5]);
                            result = Recorrido(raiz.hijos[6]);
                            if (result.equals("false")) { //Si es true, hacer istruccion
                                Recorrido(raiz.hijos[7]);
                            }

                            break;
                    }

                    break;
                case "CASO":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            String val = Recorrido(raiz.hijos[1]);
                            if (val.equals(valorSwitch)) {
                                Recorrido(raiz.hijos[3]);
                                result = "true";
                            }
                            result = "false";
                            break;
                        case 5:
                            result = Recorrido(raiz.hijos[0]);
                            if (result.equals("false")) {
                                val = Recorrido(raiz.hijos[2]);
                                if (val.equals(valorSwitch)) {
                                    Recorrido(raiz.hijos[4]);
                                    result = "true";
                                } else {
                                    try {
                                        double a = Double.parseDouble(val);
                                        double b = Double.parseDouble(valorSwitch);
                                        if (a == b) {
                                            Recorrido(raiz.hijos[4]);
                                            result = "true";
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Error ss = " + e);
                                    }
                                }
                            }
                            break;
                    }
                case "VALOR_PUNTUAL":
                    //Recorrido(raiz.hijos[2]);
                    break;
                case "LLAMADA":
//
                    break;
                case "OP":
                    result = Recorrido(raiz.hijos[0]);
                    break;
                case "E":
                    result = Operacion.resolverOperacion(raiz);
                    break;
            }
        }
        return result;
    }
    
    
    
}
