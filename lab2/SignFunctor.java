public class SignFunctor implements UnaryOp<Double,Integer> {
    public Integer op(Double x) {
        return x.compareTo(0.0d);
    }
}