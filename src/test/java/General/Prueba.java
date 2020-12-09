/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.text.DecimalFormat;

/**
 *
 * @author Dario
 */
public class Prueba {
    private static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        System.out.println(df.format(Double.parseDouble("129.1")));
    }
}
