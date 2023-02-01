/*
 * Escribe un programa que, dado un número, compruebe y muestre si es primo, fibonacci y par.
 * Ejemplos:
 * - Con el número 2, nos dirá: "2 es primo, fibonacci y es par"
 * - Con el número 7, nos dirá: "7 es primo, no es fibonacci y es impar"
 */
public class PrimoFibonacciPar {

    public void solution(int number){
        StringBuilder message = new StringBuilder();
        var isPrime = isPrime(number);
        var isEven = number % 2 == 0;
        var isFibonacci = isFibonacci(number);

        message.append(isPrime ? "Es primo": "No es primo");
        message.append(isFibonacci ? ",es fibonacci" : ",no es fibonacci");
        message.append(isEven ? ",es par" : ",es impar");

        System.out.println(message);

    }

    private boolean isPrime(int number){
        int divisor = 2;

        while(number != divisor){
            if(number % divisor == 0) return false;

            divisor++;
        }
        return true;
    }

    private boolean isFibonacci(int number){
       return isPerfectSquare(5*(Math.pow(number,2))+4)
               || isPerfectSquare(5*(Math.pow(number,2))-4);
    }

    private boolean isPerfectSquare(double number){
        double sq = Math.sqrt(number);
        return sq - (Math.floor(sq)) == 0;
    }
}
