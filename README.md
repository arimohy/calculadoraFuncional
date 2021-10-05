# Calculadora Funcional
Se desarrollo las operaciones(suma,resta,multiplicacion y division)
usando programacion funcional.
1. Suma
    ```
   static IntBinaryOperator suma = (a, b) -> a + b;
   ```
2. Resta
    ```
   static IntBinaryOperator resta = (a, b) -> a - b;
   ```
3. Multiplicacion
    ```
      static IntBinaryOperator mult = (a, b) -> {
           Integer repeticion= IntStream.range(0, Math.abs(b) + 1)
                   .reduce((acumulado, number) ->
                           suma.applyAsInt(Math.abs(a), acumulado)).getAsInt();
           if((a<0 && b>0)|| (a>0 && b<0))
               return resta.applyAsInt(0,repeticion);
           return repeticion;
       };
    ```

4. Division
    ```
      static IntBinaryOperator div = (a, b) -> {
           return IntStream.range(0, Math.abs(a) + 1)
                   .reduce((acumulado, number) -> {
                       if(mult.applyAsInt(number,b)<=a)
                           acumulado++;
                       return acumulado;
                   }).getAsInt();

       };
    ```
   Espero que sea de su agrado ....