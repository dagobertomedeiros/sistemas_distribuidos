package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalcCliente {
    public static void main(String[] args) throws NotBoundException {
        try {
            ICalculadora c = (ICalculadora) Naming.lookup("rmi://localhost/rmiCalculatorService");
            Scanner s = new Scanner(System.in);
            int sair, opcao, num1, num2, resultado;
            
            do {
                opcao = sair = num1 = num2 = resultado = 0;
                System.out.println("First Number: ");
                num1 = s.nextInt();
                System.out.println("Second Number: ");
                num2 = s.nextInt();
                System.out.println("Operation:");
                System.out.println("1 - +");
                System.out.println("2 - _");
                System.out.println("3 - x");
                System.out.println("4 - /");
                opcao = s.nextInt();

                switch (opcao) {
                    case 1:
                        resultado = c.add(num1, num2);
                        System.out.println("result:: " + resultado);
                        break;
                    case 2:
                        resultado = c.sub(num1, num2);
                        System.out.println("result:: " + resultado);
                        break;
                    case 3:
                        resultado = c.mul(num1, num2);
                        System.out.println("result: " + resultado);
                        break;
                    case 4:
                        resultado = c.div(num1, num2);
                        System.out.println("result: " + resultado);
                        break;
                    default:
                        System.out.println("invalid>!");
                        break;
                }

                System.out.println("continue?");
                System.out.println("y - 1");
                System.out.println("n - any number");
                sair = s.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            } while (sair == 1);
                System.out.println("exit");
        } catch (Exception e) {
            System.out.println();
            System.out.println(e);
            System.exit(0);
        }
    }
}
