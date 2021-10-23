import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {

    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        ArrayList<Integer> intArrList = new ArrayList<>();

        for(int i = 0; i < data.size(); i++){
            if(data.get(i) % k == 0 && data.get(i) % n != 0){
                intArrList.add(data.get(i));
            }
        }
        return intArrList;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3

        ArrayList<Integer> newArr= new ArrayList<>();

        for (int j=0,i=1; j<size; i++){
            for(int k=0;j<size && k<i;k++) {
                newArr.add(i);
                j++;
            }
        }
        return newArr;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2

        s1.retainAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2

        s1.addAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        HashSet<Integer> newSet= new HashSet<>();

        newSet.addAll(s1);
        newSet.retainAll(s2);
        s2.removeAll(newSet);
        return s2;
    }

    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> newSet= new HashSet<>();
        HashSet<Integer> retainSet= new HashSet<>();

        retainSet.addAll(s1);
        retainSet.retainAll(s2);

        s1.removeAll(retainSet);
        s2.removeAll(retainSet);

        newSet.addAll(s1);
        newSet.addAll(s2);
        return newSet;
    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        HashMap<String, Double> newMap = new HashMap<>();

        for(int i=0;i<data.size();i++){
            double frequency=0;
            for(int j=0; j< data.size(); j++){
                if(data.get(i)==data.get(j)){
                    frequency++;
                }
            }
            frequency=frequency*100/ data.size();
            newMap.put(data.get(i),frequency);
        }

        return newMap;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно

        HashMap<String, Double> newMap= new HashMap<>();
        double max = data.get(0);
        double min = data.get(0);
        double mean = 0;

        for(int i=0; i<data.size();i++){
            if(data.get(i)<min){
                min=data.get(i);
            }
            if(data.get(i)>max){
                max=data.get(i);
            }
            mean+= data.get(i);
        }
        mean=mean/data.size();

        newMap.put("max", max);
        newMap.put("min", min);
        newMap.put("mean", mean);

        return newMap;
    }
}
