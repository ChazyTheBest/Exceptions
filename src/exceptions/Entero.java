/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author chazy
 */
public class Entero
{
    public static boolean ok = false;
    private static final String INT_MIN = (Integer.MIN_VALUE + "").replace("-", "");
    private static final String INT_MAX = Integer.MAX_VALUE + "";

    public static int pedirEntero(String cadena)
    {
        int numero = 0;

        try
        {
            numero = Integer.parseInt(cadena);
            System.out.println("El número convertido es: " + numero);
            ok = true;
        }

        catch(Exception e)
        {
            System.out.println("Debes introducir un número entero.");
        }

        return numero;
    }

    public static int pedirEnteroV2(String cadena) throws Exception
    {
        int numero = 0;
        boolean negativo = false;

        if (cadena.isEmpty())
        {
            throw new Exception("Debes introducir un número.\n");
        }

        else
        {
            // negative number
            if (cadena.charAt(0) == '-')
            {
                cadena = cadena.replace("-", "");

                if (cadena.length() >= INT_MIN.length() && cadena.compareTo(INT_MIN) > 0)
                {
                    throw new Exception("El número introducido excede el valor mínimo.\n");
                }

                negativo = true;
            }
            // positive number
            else
            {
                if (cadena.length() >= INT_MAX.length() && cadena.compareTo(INT_MAX) > 0)
                {
                    throw new Exception("El número introducido excede el valor máximo.\n");
                }
            }

            char[] elementos = cadena.toCharArray();

            int num = 1, length = elementos.length;

            for (int i = 0; i < length; i++)
            {
                char tmp = elementos[length - 1 - i];

                if (tmp >= '0' && tmp <= '9')
                {
                    // x * 1, y * 10, z * 100, ...
                    numero += Character.getNumericValue(tmp) * num;
                    num *= 10;
                }

                else
                {
                    throw new Exception("Solo debes introducir números.\n");
                }
            }

            if (negativo)
            {
                numero *= -1;
            }

            System.out.println("El número convertido es: " + numero);
            ok = true;
        }

        return numero;
    }
}
