package objectbook.chapter2;

public class SequenceCondition implements DiscountCondition{

    private int sequence;


    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(ScreenMovie screenMovie) {
        return screenMovie.isSequence(sequence);
    }
}
