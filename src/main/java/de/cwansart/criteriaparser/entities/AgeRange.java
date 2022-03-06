package de.cwansart.criteriaparser.entities;

public class AgeRange {

    private final boolean inclusiveStart;
    private final boolean inclusiveEnd;
    private final int start;
    private final int end;

    public AgeRange(
            boolean inclusiveStart,
            boolean inclusiveEnd,
            int start,
            int end
    ) {

        this.inclusiveStart = inclusiveStart;
        this.inclusiveEnd = inclusiveEnd;
        this.start = start;
        this.end = end;
    }

    public boolean isInclusiveStart() {
        return inclusiveStart;
    }

    public boolean isInclusiveEnd() {
        return inclusiveEnd;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "AgeRange{" +
                "inclusiveStart=" + inclusiveStart +
                ", inclusiveEnd=" + inclusiveEnd +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
