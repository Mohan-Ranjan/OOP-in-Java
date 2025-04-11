import java.io.IOException;

public interface SkinConsultationManager {

    void initialize();

    void documentView(Doctor[] docList);

    void addDoctor(Doctor[] docList);

    void deleteDoctor(Doctor[] docList);

    void saveTextFile(Doctor[] docList, int programEnds) throws IOException;
}
