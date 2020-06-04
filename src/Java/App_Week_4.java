package Java;

import java.util.*;

public class App_Week_4 {

    public static void main(String[] args) {

        ArrayList<String> employeeNames = new ArrayList<>();
        HashSet<Integer> ids = new HashSet<>();
        HashMap<Integer, String> employeeMap = new HashMap<>();
        Iterator<Integer> idIterator = ids.iterator();

        employeeNames.add("Reuven");
        employeeNames.add("Shimon");
        employeeNames.add("Levi");
        employeeNames.add("Yehuda");
        employeeNames.add("Naftali");
        employeeNames.add("Gad");

        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        ids.add(6);

        StringBuilder idsBuilder = new StringBuilder();

        int i = 0;
        for(int id: ids){
            int currentID = id;
            String currentEmployee = employeeNames.get(i);
            employeeMap.put(currentID, currentEmployee);
            idsBuilder.append(currentID + "-");
            i++;
        }

        System.out.println(idsBuilder.toString());

        Iterator mapIterator = employeeMap.entrySet().iterator();

        for(Map.Entry entry: employeeMap.entrySet()){
            String key = entry.getKey().toString();
            String employee = (String) entry.getValue();
            System.out.println("Key: " + key + "\tValue: " + employee);
        }



        StringBuilder namesBuilder = new StringBuilder();
        for(String str: employeeNames){
            namesBuilder.append(str + "-");
        }

        System.out.println(namesBuilder.toString());
    }
}