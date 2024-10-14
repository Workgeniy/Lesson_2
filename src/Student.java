import org.jetbrains.annotations.NotNull;

public class Student {
        @NonNull public String name;
        public int[] grades;


        public Student(String name, int[] grades) {
            this.name=name;
            this.grades=grades;
        }

        void DisplayInfo(){
            System.out.println("Name: "+name);
        }
}
