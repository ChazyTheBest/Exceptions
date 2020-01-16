/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.Arrays;

/**
 *
 * @author chazy
 */
public class Entero
{
    public static boolean ok = false;

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

        if (!cadena.isEmpty())
        {
            // negative number
            if (cadena.charAt(0) == '-')
            {
                cadena = cadena.replace("-", "");

                if (cadena.length() >= 10 && cadena.compareTo((Integer.MIN_VALUE + "").replace("-", "")) > 0)
                {
                    throw new Exception("El número introducido excede el valor mínimo.\n");
                }

                negativo = true;
            }
            // positive number
            else
            {
                if (cadena.length() >= 10 && cadena.compareTo(Integer.MAX_VALUE + "") > 0)
                {
                    throw new Exception("El número introducido excede el valor máximo.\n");
                }
            }

            char[] elementos = cadena.toCharArray();

            Arrays.sort(elementos);

            for (int i = 0, j = elementos.length, z=j; i < j; i++,z--)
            {
                char tmp = elementos[i];

                if (tmp >= '0' && tmp <= '9')
                {
                    int num = 1;

                    for (int k = z; k > 1; k--)
                    {
                        num *= 10;
                    }

                    // x * 1, y * 10, z * 100, ...
                    numero += Character.getNumericValue(tmp)*num;
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

            System.out.print("El número convertido es: " + numero);
            ok = true;
        }

        else
        {
            throw new Exception("Debes introducir un número.\n");
        }

        return numero;
    }
}
