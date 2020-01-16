/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.Scanner;

/**
 *
 * @author chazy
 */
public class Exceptions
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (!Entero.ok)
        {
            System.out.print("(v1) Introduce un número entero: ");

            // exceptions already handled
            int numero1 = Entero.pedirEntero(sc.nextLine());
        }

        Entero.ok = false;

        while (!Entero.ok)
        {
            System.out.print("(v2) Introduce un número entero: ");

            // handle exceptions
            try
            {
                int numero2 = Entero.pedirEnteroV2(sc.nextLine());
            }

            catch(Exception e)
            {
                System.out.print(e);
            }
        }

        sc.close();
    }
}
