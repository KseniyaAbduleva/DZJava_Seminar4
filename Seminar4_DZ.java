/*import java.io.FileReader;
import java.io.FileWriter;
/*1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader */

/*public class Seminar4_DZ {
    public static void main(String[] args) throws Exception {
        String file = "baza.sql";
        FileWriter writer = new FileWriter(file, true);
        writeFile(writer);
        readFile(file);
    }
        public static void writeFile(FileWriter writer)throws Exception{
            writer.append("Иванов Иван Иванович 32 М\n");
            writer.append("Иванова Ирина Петровна 42 Ж\n");
            writer.append("Петров Семен Петрович 56 М\n");
            writer.append("Якубрвич Василий Семенович 59 М\n");
            writer.append("Петрова Нина Ивановна 65 Ж");
            writer.flush();
        }

        public static void readFile(String file)throws Exception{
            String personalData = "";
            FileReader reader = new FileReader(file);
            while (reader.ready()) {
                personalData +=(char)reader.read();
            }
            System.out.println(personalData);
            reader.close();
    }
}



/*2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы.
 Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М" */

/* public class Seminar4_DZ {
    public static void main(String[] args) throws Exception {
        String file = "baza.sql";
        readFile(file);

}

public static void readFile(String file)throws Exception{
    String personalData = "";
    FileReader reader = new FileReader(file);
    while (reader.ready()) {
        personalData +=(char)reader.read();
    }
    String [] string = personalData.split("\n");
    for (int i = 0; i < string.length; i++) {
        String [] tmp = string[i].split(" ");
        System.out.println(tmp[0]+ " " + tmp[1].charAt(0)+ "." + tmp[2].charAt(0)+"." +" "+ tmp[3]+" "+tmp[4]);
    }
    reader.close();
}
} */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
/*3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
  4.Отсортировать по возрасту используя дополнительный список индексов. */
public class Seminar4_DZ {
    public static void main(String[] args) throws Exception {
        String file = "baza.sql";
        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        String personalData = "";
        FileReader reader = new FileReader(file);
        while (reader.ready()) {
            personalData +=(char)reader.read();
        }
        reader.close();

        String[] str = personalData.split("\n");
        for (int i = 0; i < str.length; i++) {
            String[] result = str[i].split(" ");
            family.add(result[0]+" ");
            name.add(result[1].charAt(0) + ".");
            soname.add(result[2].charAt(0) + ".");
            age.add(Integer.valueOf(result[3]));
            gender.add(result[4].equals("М") ? true : false);
            index.add(i);
        }
       
        int buf;
        int k = age.size();
        for(int i=0; i <k-1;i++){
            boolean sort = false;
            for (int j= 0; j < k-i-1; j++) {
                if((age.get(index.get(j)) > age.get(index.get(j+1)))){
                    buf=index.get(j);
                    index.set(j, index.get(j+1));
                    index.set(index.get(j+1), buf);
                    sort=true;  
                }
            }
            if(!sort) break;
        }
  
        for (int i = 0; i < index.size(); i++) {
            System.out.printf(family.get(index.get(i)));
            System.out.printf(name.get(index.get(i)));
            System.out.printf(soname.get(index.get(i)));
            System.out.printf(age.get(index.get(i)).toString());
            System.out.printf((gender.get(index.get(i)) ? " M" : " Ж"));
            System.out.println();
        }  
}}