public class TeacherPresenter {
    private final TeacherService teacherService;
    private final TeacherView view;

    public TeacherPresenter(TeacherService teacherService, TeacherView view) {
        this.teacherService = teacherService;
        this.view = view;
    }

    public void fetchTeacher(int teacherId) {
        TeacherDto teacher = teacherService.findTeacherById(teacherId);

        view.displayTeacher(teacher);
    }
}
