public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int k=0;
        if (n1<n2) {
            for (int i = n1; i <= n2; i++) {
                if (i % a == 0 && i % b != 0) {
                    k++;
                }
            }
        }
        else{
            for (int i = n2; i <= n1; i++) {
                if (i % a == 0 && i % b != 0) {
                    k++;
                }
            }
        }
        return k;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int number=1;
        for (int j=1, i=1; j<=num; i++){
            j+=i;
            number=i;
        }

        return number;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int f0=num;
        int f1=0;
        int sum=num;
        for(int i=1; i<cnt;i++){
            f1=d*f0+1;
            f0=f1;
            sum+=f1;
        }
        return sum;
    }


    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int Sn=0;

        for (int i = 1; i <= n; i++) {
            int factorial=1;
            for (int j = 1; j <= i; j++) {
                factorial = factorial * j;
            }
            Sn = Sn + factorial;
        }
         return Sn;

    }
}
