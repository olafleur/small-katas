import java.util.List;

public class TeacherPresenter {
    private final TeacherService teacherService;
    private final TeacherView view;
    private final ClassService classService;

    private int teacherId;

    public TeacherPresenter(TeacherService teacherService, TeacherView view, ClassService classService) {
        this.teacherService = teacherService;
        this.view = view;
        this.classService = classService;
    }

    public void fetchTeacher(int teacherId) {
        TeacherDto teacher = teacherService.findTeacherById(teacherId);



        if (teacher == null) {
            view.displayNoTeacher();
        } else {
            this.teacherId = teacher.id;
            List<StudentDto> studentDtos = classService.findStudentsByClassId(teacher.classId);

            view.displayTeacher(teacher);

            if (studentDtos.isEmpty()) {
                view.displayNoStudent();
            } else {
                for (StudentDto studentDto : studentDtos) {
                    if (studentDto.age > 18) {
                        view.displayStudent(studentDto);
                    }
                }
            }
        }
    }

    public void updateTeacherName(String newName) {
        teacherService.updateTeacherName(teacherId, newName);
    }
}
