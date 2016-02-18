import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TeacherPresenterTest {
    private static final int TEACHER_ID = 43280;

    @InjectMocks
    private TeacherPresenter presenter;
    @Mock
    private TeacherService teacherService;
    @Mock
    private TeacherView view;

    @Test
    public void fetchTeacher_displaysTeacherInView() {
        TeacherDto teacher = new TeacherDto();
        willReturn(teacher).given(teacherService).findTeacherById(TEACHER_ID);

        presenter.fetchTeacher(TEACHER_ID);

        verify(view).displayTeacher(teacher);
    }
}
