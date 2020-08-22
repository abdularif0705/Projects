package Final_Exam;

public class GenericPair<T,S> {
    private T first;
    private S second;

    public GenericPair(T first, S second){
        this.first = first;
        this.second = second;
    }
    public T getFirst(){
        return first;
    }

    public S getSecond() {
        return second;
    }
}