import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TeacherPresenterTest {
    private static final int TEACHER_ID = 43280;
    private static final int CLASS_ID = 45498489;
    private static final String NEW_NAME = "32q40923";

    @InjectMocks
    private TeacherPresenter presenter;
    @Mock
    private TeacherService teacherService;
    @Mock
    private ClassService classService;
    @Mock
    private TeacherView view;
    private TeacherDto teacher;

    @Before
    public void setup() {
        teacher = new TeacherDto();
        teacher.id = TEACHER_ID;
        teacher.classId = CLASS_ID;
        willReturn(teacher).given(teacherService).findTeacherById(TEACHER_ID);
    }

    @Test
    public void fetchTeacher_findsTeacherById() {
        presenter.fetchTeacher(TEACHER_ID);

        verify(teacherService).findTeacherById(TEACHER_ID);
    }

    @Test
    public void fetchTeacher_displaysTeacherInView() {
        presenter.fetchTeacher(TEACHER_ID);

        verify(view).displayTeacher(teacher);
    }

    @Test
    public void fetchTeacher_findsStudentsByClassId() {
        presenter.fetchTeacher(TEACHER_ID);

        verify(classService).findStudentsByClassId(CLASS_ID);
    }

    @Test
    public void fetchTeacher_displaysNoTeacher_whenTheresNoTeacher() {
        willReturn(null).given(teacherService).findTeacherById(TEACHER_ID);

        presenter.fetchTeacher(TEACHER_ID);

        verify(view).displayNoTeacher();
    }

    @Test
    public void fetchTeacher_displaysClassroomStudents() {
        StudentDto student1 = new StudentDto();
        student1.age = 21;
        StudentDto student2 = new StudentDto();
        student2.age = 13;
        StudentDto student3 = new StudentDto();
        student3.age = 92;

        List<StudentDto> students = Arrays.asList(student1, student2, student3);
        willReturn(students).given(classService).findStudentsByClassId(CLASS_ID);

        presenter.fetchTeacher(TEACHER_ID);

        verify(view).displayStudent(student1);
        verify(view, never()).displayStudent(student2);
        verify(view).displayStudent(student3);
    }

    @Test
    public void fetchTeacher_displaysNoStudents_whenTheresNoStudent() {
        List<StudentDto> students = new ArrayList<>();
        willReturn(students).given(classService).findStudentsByClassId(CLASS_ID);

        presenter.fetchTeacher(TEACHER_ID);

        verify(view).displayNoStudent();
    }

    @Test
    public void updateTeacherName_savesTeacherWithNewName() {
        presenter.fetchTeacher(TEACHER_ID);

        presenter.updateTeacherName(NEW_NAME);

        verify(teacherService).updateTeacherName(TEACHER_ID, NEW_NAME);
    }
}
