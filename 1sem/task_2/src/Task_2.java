public class Task_2 implements Task_2_base {
    @Override
    public int subtask_1_while(int num) {
        // Найти максимальное число, являющееся полным квадратом,
        // не превосходящее заданное натуральное num
        int max=0;
        for(int i=0; i*i<=num; i++){
            max=i*i;
        }
        return max;
    }

    @Override
    public int subtask_2_while(int num) {
        // Последовательность целых чисел p(n) определяется следующим образом:
        // p(0) = 1
        // p(k) = 2 * p(k - 1) + 6, k > 0
        //Найти элемент последовательности с номером num
        int f0=1;
        int f1;
        for(int i=1; i<=num;i++){
           f1=2*f0+6;
           f0=f1;
        }
        return f0;
    }

    @Override
    public boolean subtask_3_while(int num, int base) {
        // Проверить, является ли число num натуральной степенью числа base
        int yes=0;
        int degree=base;
        if(num==base){
            return true;
        }
        else {
            for (int i = 1; i <= 100000000; i++) {
                degree = degree * base;
                if (degree == num) {
                    yes = 1;
                }
            }
            if (yes == 1) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    @Override
    public int subtask_4_while(int start, int end) {
        // Вычислить, за какое минимальное число операций
        // вычесть 1
        // поделить на 2
        // число start можно превратить в end. Гарантируется, что start >= end >= 1
       int i=0;
        while (start > end) {
            if (start % 2 == 0 && start / 2 >= end) {
                start /= 2;
            } else {
                start--;
            }
          i++;
        }
        return i;
    }
}
