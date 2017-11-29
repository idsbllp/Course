import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.util.*;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws IOException {
        getResult();
    }

    public static void getResult2() throws IOException {
        //Major Clazz Student
        Map<String,List<String>> data = Tools.getMajorToClassList();
        String majorName = "信息与计算科学专业实验班";
        List<String> classes = data.get(majorName);
        Major major = new Major();
        major.setName(majorName);
        List<Clazz> clazzes = new ArrayList<>();
        for (String classId : classes) {
            Clazz clazz = new Clazz();
            clazz.setClassId(classId);
            Map<String, List<String>> studentList = Tools.getStudentList(classId);
            List<Student> students = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : studentList.entrySet()) {
                String stuName = entry.getKey();
                List<String> stuInfo = entry.getValue();
                Student student = new Student();
                student.setName(stuName);
                student.setGender(stuInfo.get(1));
                student.setStuId(stuInfo.get(2));
                students.add(student);
            }
            clazzes.add(clazz);
        }
        major.setClazzes(clazzes);
    }

    public static void getResult() throws IOException {
        //学生信息  stuInfo      Map<attrName, attrValue>
        //班级信息  classInfo    Map<classId, stuInfoList>
        //专业信息  majorInfo    Map<major, classInfo>

        //Map<major, Map<classId, List<Map<attrName, attrValue>>>>>

        Map<String,List<String>> data = Tools.getMajorToClassList();
        String major = "信息与计算科学专业实验班";
        List<String> classes = data.get(major);


        Map<String, Map<String, List<Map<String, String>>>> result = new HashMap<>();

        Map<String, List<Map<String, String>>> classInfo = new HashMap<>();
        for (String clazz : classes) {
            List<Map<String, String>> studentsInfo = new ArrayList<>();
            Map<String, List<String>> studentList = Tools.getStudentList(clazz);
            for (Map.Entry<String, List<String>> entry : studentList.entrySet()) {
                Map<String, String> stuInfo = new HashMap<>();
                String name = entry.getKey();
                List<String> info = entry.getValue();
                stuInfo.put("name", name);
                stuInfo.put("stuId", info.get(1));
                stuInfo.put("gender", info.get(2));
                studentsInfo.add(stuInfo);
            }
            classInfo.put(clazz, studentsInfo);
        }
        result.put(major, classInfo);
        System.out.println(result.toString());
    }
}


class Tools {

    public static Map<String,ArrayList> getCollageToMajorMap() throws IOException {
        String data = getData("http://jwzx.cqupt.edu.cn/jwzxtmp/pubBjsearch.php?action=bjStu");
        Pattern pattern = Pattern.compile("<tr><td>(.*?)</td>");
        Matcher matcher = pattern.matcher(data);
        int i = 0;
        List collage = getCollageList();
        Map<String, ArrayList> collageToMajor = new LinkedHashMap();
        for (String string:getCollageList()){
            collageToMajor.put(string,new ArrayList<String>());
        }
        while (matcher.find()) {
            String temp = matcher.group(1);
            if (temp.equals("专业")) {
                i++;
                continue;
            }
            collageToMajor.get(collage.get(i-1)).add(matcher.group(1));
        }
        return collageToMajor;
    }

    public static List<String> getCollageList() throws IOException {
        String data = getData("http://jwzx.cqupt.edu.cn/jwzxtmp/pubBjsearch.php?action=bjStu");
        ArrayList<String> collage = new ArrayList<>();
        Pattern pattern = Pattern.compile("<h3>(.*?)</h3>");
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            collage.add(matcher.group(1));
        }
        return collage;

    }

    public static String getData(String strUrl) throws IOException {
        URL url = new URL(strUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(), "UTF-8"
                )
        );
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        connection.disconnect();
        return builder.toString();
    }

    public static Map<String, List<String>> getStudentList(String ClassID) throws IOException {
        URL url = new URL("http://jwzx.cqupt.edu.cn/jwzxtmp/showBjStu.php?bj=" + ClassID);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(), "UTF-8"
                )
        );
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        connection.disconnect();
        String PageData = builder.toString();
        Pattern pattern=Pattern.compile("<tr><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td>");
        Matcher matcher = pattern.matcher(PageData);
        Map<String, List<String>> students = new LinkedHashMap<>();
        while (matcher.find()) {
            if(matcher.group(1).equals("No."))
                continue;
            List<String> temp = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                if (i==3)
                    continue;
                temp.add(matcher.group(i));
            }
            students.put(matcher.group(3), temp);
        }
        return students;
    }

    public static Map<String,List<String>> getMajorToClassList() throws IOException {
        String data = getData("http://jwzx.cqupt.edu.cn/jwzxtmp/pubBjsearch.php?action=bjStu");
        Pattern pattern = Pattern.compile("<tr><td>(.*?)</td>(.*?)</tr>");
        Matcher matcher = pattern.matcher(data);
        Map<String, List<String>> clazzes = new HashMap<>();
        while (matcher.find()) {
            Pattern p = Pattern.compile("showBjStu\\.php\\?bj\\=(.*?)\\'");
            Matcher m = p.matcher(matcher.group(2));
            List<String> c = new ArrayList<>();
            while (m.find()) {
                c.add(m.group(1));
            }
            clazzes.put(matcher.group(1), c);
        }
        return clazzes;
    }
}

class Student {
    private String gender;
    private String name;
    private String stuId;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }
}


class Clazz {
    private String classId;

    private List<Student> students;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

class Major {
    private String name;

    private List<Clazz> clazzes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }
}
