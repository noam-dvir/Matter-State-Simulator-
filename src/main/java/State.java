import java.util.List;

public interface State {
    void analyse(List<String> transList, int[] resStates);
}
