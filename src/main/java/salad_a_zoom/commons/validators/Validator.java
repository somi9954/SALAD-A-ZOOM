package salad_a_zoom.commons.validators;

public interface Validator<T> {
    void check(T t);
}